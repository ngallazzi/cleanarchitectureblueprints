package com.ngallazzi.cleanarchitectureblueprints.framework

import com.ngallazzi.data.BooksRemoteDataSource
import com.ngallazzi.domain.Book

class BooksRemoteDataSourceImpl : BooksRemoteDataSource {
    override fun getBooks(author: String): List<Book> {
        TODO("Not yet implemented")
    }
}