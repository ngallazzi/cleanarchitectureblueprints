package com.ngallazzi.domain.usecases

import com.ngallazzi.domain.repositories.BooksRepository

class GetSavedBooksUseCase(private val booksRepository: BooksRepository) {
    suspend operator fun invoke(author: String) = booksRepository.getBooks(author)
}