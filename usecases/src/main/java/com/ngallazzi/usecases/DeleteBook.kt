package com.ngallazzi.usecases

import com.ngallazzi.data.BooksRepository
import com.ngallazzi.domain.Book

class DeleteBook(private val booksRepository: BooksRepository) {
    operator fun invoke(book: Book) = booksRepository.deleteBook(book)
}