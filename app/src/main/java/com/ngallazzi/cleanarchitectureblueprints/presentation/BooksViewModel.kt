package com.ngallazzi.cleanarchitectureblueprints.presentation

import androidx.lifecycle.*
import com.ngallazzi.domain.common.Result
import com.ngallazzi.domain.entities.Volume
import com.ngallazzi.domain.usecases.GetBooksUseCase
import kotlinx.coroutines.launch


class BooksViewModel(private val getBooksUseCase: GetBooksUseCase) : ViewModel() {

    private val _dataLoading = MutableLiveData(true)
    val dataLoading: LiveData<Boolean> = _dataLoading

    private val _books = MutableLiveData<List<Volume>>()
    val books = _books

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    // Getting books with uncle bob as default author :)
    fun getBooks(author: String = "Robert Martin") {
        viewModelScope.launch {
            _dataLoading.postValue(true)
            when (val booksResult = getBooksUseCase.invoke(author)) {
                is Result.Success -> {
                    books.value = booksResult.data
                }
                is Result.Error -> {
                    books.value = emptyList()
                    _error.postValue(booksResult.exception.message)
                }
            }
            _dataLoading.postValue(false)
        }
    }

    class BooksViewModelFactory(private val getBooksUseCase: GetBooksUseCase) :
        ViewModelProvider.NewInstanceFactory() {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return BooksViewModel(getBooksUseCase) as T
        }
    }
}