package com.ngallazzi.domain.usecases

import com.ngallazzi.domain.repositories.BooksRepository

class GetBookmarksUseCase(private val booksRepository: BooksRepository) {
    suspend operator fun invoke() = booksRepository.getBookmarks()
}