package com.ngallazzi.data.repositories.books

import com.ngallazzi.domain.common.Result
import com.ngallazzi.domain.entities.Volume
import com.ngallazzi.domain.repositories.BooksRepository
import kotlinx.coroutines.flow.Flow

class BooksRepositoryImpl(
    private val localDataSource: BooksLocalDataSource,
    private val remoteDataSource: BooksRemoteDataSource
) : BooksRepository {

    override suspend fun getRemoteBooks(author: String): Result<List<Volume>> {
        return remoteDataSource.getBooks(author)
    }

    override suspend fun getBookmarks(): Flow<List<Volume>> {
        return localDataSource.getBookmarks()
    }

    override suspend fun bookmark(book: Volume) {
        localDataSource.bookmark(book)
    }

    override suspend fun unbookmark(book: Volume) {
        localDataSource.unbookmark(book)
    }
}