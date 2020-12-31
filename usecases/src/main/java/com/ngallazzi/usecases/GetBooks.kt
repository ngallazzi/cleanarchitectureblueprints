package com.ngallazzi.usecases

import com.ngallazzi.data.BooksRepository
import com.ngallazzi.domain.Book

class GetBooks(private val booksRepository: BooksRepository) {
    operator fun invoke(author: String): List<Book> = booksRepository.getBooks(author)
}