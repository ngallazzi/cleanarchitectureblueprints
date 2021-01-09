package com.ngallazzi.data.repositories.books

import com.ngallazzi.domain.common.Result
import com.ngallazzi.domain.entities.Volume

interface BooksRemoteDataSource {
    suspend fun getBooks(author: String): Result<List<Volume>>
}