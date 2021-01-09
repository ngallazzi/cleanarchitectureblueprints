package com.ngallazzi.cleanarchitectureblueprints.di

import android.content.Context
import com.ngallazzi.cleanarchitectureblueprints.BuildConfig
import com.ngallazzi.data.db.BooksDatabase
import com.ngallazzi.data.repositories.books.BooksLocalDataSourceImpl
import com.ngallazzi.data.repositories.books.BooksRemoteDataSourceImpl
import com.ngallazzi.data.api.NetworkModule
import com.ngallazzi.data.mappers.BookApiResponseMapper
import com.ngallazzi.data.mappers.BookEntityMapper
import com.ngallazzi.data.repositories.books.BooksRepositoryImpl
import com.ngallazzi.data.repositories.books.BooksLocalDataSource
import kotlinx.coroutines.Dispatchers

object ServiceLocator {
    private var database: BooksDatabase? = null
    private val networkModule by lazy {
        NetworkModule()
    }
    private val bookEntityMapper by lazy {
        BookEntityMapper()
    }

    @Volatile
    var booksRepository: BooksRepositoryImpl? = null

    fun provideBooksRepository(context: Context): BooksRepositoryImpl {
        // useful because this method can be accessed by multiple threads
        synchronized(this) {
            return booksRepository ?: createBooksRepository(context)
        }
    }

    private fun createBooksRepository(context: Context): BooksRepositoryImpl {
        val newRepo =
            BooksRepositoryImpl(
                createBooksLocalDataSource(context),
                BooksRemoteDataSourceImpl(
                    networkModule.createBooksApi(BuildConfig.GOOGLE_APIS_ENDPOINT),
                    BookApiResponseMapper()
                )
            )
        booksRepository = newRepo
        return newRepo
    }

    private fun createBooksLocalDataSource(context: Context): BooksLocalDataSource {
        val database = database ?: createDataBase(context)
        return BooksLocalDataSourceImpl(
            database.bookDao(),
            Dispatchers.IO,
            bookEntityMapper
        )
    }

    private fun createDataBase(context: Context): BooksDatabase {
        val result = BooksDatabase.getDatabase(context)
        database = result
        return result
    }
}