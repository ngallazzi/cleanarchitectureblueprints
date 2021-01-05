package com.ngallazzi.domain.repositories

import com.ngallazzi.domain.common.Result
import com.ngallazzi.domain.entities.Volume

interface BooksRepository {

    suspend fun getBooks(author: String): Result<List<Volume>>

    suspend fun getSavedBooks(): List<Volume>

    suspend fun saveBook(book: Volume)

    suspend fun deleteBook(book: Volume)
}