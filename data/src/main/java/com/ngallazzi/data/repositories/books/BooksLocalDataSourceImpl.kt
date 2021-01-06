package com.ngallazzi.data.repositories.books

import com.ngallazzi.data.db.BookDao
import com.ngallazzi.data.entities.BookEntity
import com.ngallazzi.data.mappers.BookEntityMapper
import com.ngallazzi.domain.entities.Volume
import com.ngallazzi.domain.entities.VolumeInfo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class BooksLocalDataSourceImpl(
    private val bookDao: BookDao,
    private val dispatcher: CoroutineDispatcher,
    private val bookEntityMapper: BookEntityMapper
) : BooksLocalDataSource {
    override suspend fun saveBook(book: Volume) = withContext(dispatcher) {
        bookDao.saveBook(bookEntityMapper.toBookEntity(book))
    }

    override suspend fun deleteBook(book: Volume) = withContext(dispatcher) {
        bookDao.deleteBook(bookEntityMapper.toBookEntity(book))
    }

    override suspend fun getSavedBooks(): List<Volume> = withContext(dispatcher) {
        return@withContext bookDao.getSavedBooks()
            .map { bookEntityMapper.toVolume(it) }
    }
}