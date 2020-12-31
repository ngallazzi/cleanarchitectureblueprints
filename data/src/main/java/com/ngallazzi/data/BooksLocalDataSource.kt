package com.ngallazzi.data

import com.ngallazzi.domain.Book

interface BooksLocalDataSource {
    fun saveBook(book: Book)
    fun deleteBook(book: Book)
    fun getSavedBooks(): List<Book>
}