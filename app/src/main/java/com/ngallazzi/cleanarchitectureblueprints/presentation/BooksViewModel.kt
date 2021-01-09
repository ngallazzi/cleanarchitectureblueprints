package com.ngallazzi.cleanarchitectureblueprints.presentation

import androidx.lifecycle.*
import com.ngallazzi.cleanarchitectureblueprints.entities.BookWithStatus
import com.ngallazzi.cleanarchitectureblueprints.mappers.BookWithStatusMapper
import com.ngallazzi.domain.common.Result
import com.ngallazzi.domain.entities.Volume
import com.ngallazzi.domain.usecases.BookmarkBookUseCase
import com.ngallazzi.domain.usecases.GetBookmarksUseCase
import com.ngallazzi.domain.usecases.GetBooksUseCase
import com.ngallazzi.domain.usecases.UnbookmarkBookUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class BooksViewModel(
    private val getBooksUseCase: GetBooksUseCase,
    private val getBookmarksUseCase: GetBookmarksUseCase,
    private val bookmarkBookUseCase: BookmarkBookUseCase,
    private val unbookmarkBookUseCase: UnbookmarkBookUseCase,
    private val mapper: BookWithStatusMapper
) : ViewModel() {

    private val _dataLoading = MutableLiveData(true)
    val dataLoading: LiveData<Boolean> = _dataLoading

    private val _books = MutableLiveData<List<BookWithStatus>>()
    val books = _books

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    private val _remoteBooks = arrayListOf<Volume>()

    // Getting books with uncle bob as default author :)
    fun getBooks(author: String) {
        viewModelScope.launch {
            _dataLoading.postValue(true)
            when (val booksResult = getBooksUseCase.invoke(author)) {
                is Result.Success -> {
                    _remoteBooks.clear()
                    _remoteBooks.addAll(booksResult.data)

                    val bookmarksFlow = getBookmarksUseCase.invoke()
                    bookmarksFlow.collect { bookmarks ->
                        books.value = mapper.fromVolumeToBookWithStatus(_remoteBooks, bookmarks)
                        _dataLoading.postValue(false)
                    }
                }

                is Result.Error -> {
                    _dataLoading.postValue(false)
                    books.value = emptyList()
                    _error.postValue(booksResult.exception.message)
                }
            }
        }
    }

    fun bookmark(book: BookWithStatus) {
        viewModelScope.launch {
            bookmarkBookUseCase.invoke(mapper.fromBookWithStatusToVolume(book))
        }
    }

    fun unbookmark(book: BookWithStatus) {
        viewModelScope.launch {
            unbookmarkBookUseCase.invoke(mapper.fromBookWithStatusToVolume(book))
        }
    }

    class BooksViewModelFactory(
        private val getBooksUseCase: GetBooksUseCase,
        private val getBookmarksUseCase: GetBookmarksUseCase,
        private val bookmarkBookUseCase: BookmarkBookUseCase,
        private val unbookmarkBookUseCase: UnbookmarkBookUseCase,
        private val mapper: BookWithStatusMapper
    ) :
        ViewModelProvider.NewInstanceFactory() {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return BooksViewModel(
                getBooksUseCase,
                getBookmarksUseCase,
                bookmarkBookUseCase,
                unbookmarkBookUseCase,
                mapper
            ) as T
        }
    }
}