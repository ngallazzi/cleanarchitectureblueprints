package com.ngallazzi.data

import com.ngallazzi.domain.Book

interface BooksRemoteDataSource {
    fun getBooks(author: String): List<Book>
}