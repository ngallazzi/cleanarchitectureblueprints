package com.ngallazzi.data.repositories.books

import com.ngallazzi.data.api.BooksApi
import com.ngallazzi.data.mappers.BookApiResponseMapper
import com.ngallazzi.domain.common.*
import com.ngallazzi.domain.entities.Volume
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BooksRemoteDataSourceImpl(
    private val service: BooksApi,
    private val mapper: BookApiResponseMapper
) : BooksRemoteDataSource {
    override suspend fun getBooks(author: String): Result<List<Volume>> =
        withContext(Dispatchers.IO) {
            try {
                val response = service.getBooks(author)
                if (response.isSuccessful) {
                    return@withContext Result.Success(mapper.toVolumeList(response.body()!!))
                } else {
                    return@withContext Result.Error(Exception(response.message()))
                }
            } catch (e: Exception) {
                return@withContext Result.Error(e)
            }
        }
}