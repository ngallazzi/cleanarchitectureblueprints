package com.ngallazzi.data.repositories.books

import com.ngallazzi.domain.common.Result
import com.ngallazzi.domain.entities.Volume
import com.ngallazzi.domain.repositories.BooksRepository

class BooksRepositoryImpl(
    private val localDataSource: BooksLocalDataSource,
    private val remoteDataSource: BooksRemoteDataSource
) : BooksRepository {
    override suspend fun getBooks(author: String): Result<List<Volume>> {
        return remoteDataSource.getBooks(author)
    }

    override suspend fun getSavedBooks(): List<Volume> {
        return localDataSource.getSavedBooks()
    }

    override suspend fun saveBook(book: Volume) {
        localDataSource.saveBook(book)
    }

    override suspend fun deleteBook(book: Volume) {
        localDataSource.deleteBook(book)
    }
}