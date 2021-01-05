package com.ngallazzi.data.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface BooksApi {
    @GET("books/v1/volumes")
    suspend fun getBooks(@Query("q") author: String): Response<BooksApiResponse>
}