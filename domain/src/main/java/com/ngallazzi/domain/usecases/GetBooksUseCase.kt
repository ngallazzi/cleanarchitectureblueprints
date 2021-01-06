package com.ngallazzi.domain.usecases

import com.ngallazzi.domain.repositories.BooksRepository

class GetBooksUseCase(private val booksRepository: BooksRepository) {
    suspend operator fun invoke(author: String) = booksRepository.getRemoteBooks(author)
}