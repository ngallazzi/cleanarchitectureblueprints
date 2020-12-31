package com.ngallazzi.data

import com.ngallazzi.domain.Book

class BooksRepository(
    private val localDataSource: BooksLocalDataSource,
    private val remoteDataSource: BooksRemoteDataSource
) {
    fun getBooks(author: String): List<Book> {
        return remoteDataSource.getBooks(author)
    }

    fun getSavedBooks(): List<Book> {
        return localDataSource.getSavedBooks()
    }

    fun saveBook(book: Book) {
        localDataSource.saveBook(book)
    }

    fun deleteBook(book: Book) {
        localDataSource.deleteBook(book)
    }
}