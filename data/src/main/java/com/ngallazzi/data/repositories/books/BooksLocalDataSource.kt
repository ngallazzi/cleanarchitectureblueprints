package com.ngallazzi.data.repositories.books

import com.ngallazzi.domain.entities.Volume

interface BooksLocalDataSource {
    suspend fun saveBook(book: Volume)
    suspend fun deleteBook(book: Volume)
    suspend fun getSavedBooks(): List<Volume>
}