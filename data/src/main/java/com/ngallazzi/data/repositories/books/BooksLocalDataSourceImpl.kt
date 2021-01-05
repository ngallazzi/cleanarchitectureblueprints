package com.ngallazzi.data.repositories.books

import com.ngallazzi.data.db.BookDao
import com.ngallazzi.data.entities.BookEntity
import com.ngallazzi.domain.entities.Volume
import com.ngallazzi.domain.entities.VolumeInfo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class BooksLocalDataSourceImpl(
    private val bookDao: BookDao,
    private val dispatcher: CoroutineDispatcher
) : BooksLocalDataSource {
    override suspend fun saveBook(book: Volume) = withContext(dispatcher) {
        bookDao.saveBook(
            BookEntity(
                id = book.id,
                title = book.volumeInfo.title,
                authors = book.volumeInfo.authors,
                imageUrl = book.volumeInfo.imageUrl
            )
        )
    }

    override suspend fun deleteBook(book: Volume) = withContext(dispatcher) {
        bookDao.deleteBook(
            BookEntity(
                book.id,
                book.volumeInfo.title,
                book.volumeInfo.authors,
                book.volumeInfo.imageUrl
            )
        )
    }

    override suspend fun getSavedBooks(): List<Volume> = withContext(dispatcher) {
        return@withContext bookDao.getSavedBooks()
            .map { Volume(it.id, VolumeInfo(it.title, it.authors, it.imageUrl)) }
    }
}