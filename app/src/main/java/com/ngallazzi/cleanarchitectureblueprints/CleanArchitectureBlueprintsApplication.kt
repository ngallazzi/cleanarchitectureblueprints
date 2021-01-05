package com.ngallazzi.cleanarchitectureblueprints

import android.app.Application
import com.ngallazzi.cleanarchitectureblueprints.di.ServiceLocator
import com.ngallazzi.data.repositories.books.BooksRepositoryImpl
import com.ngallazzi.domain.usecases.GetBooksUseCase
import timber.log.Timber

class CleanArchitectureBlueprintsApplication : Application() {
    val booksRepository: BooksRepositoryImpl
        get() = ServiceLocator.provideBooksRepository(this)

    val getBooksUseCase: GetBooksUseCase
        get() = GetBooksUseCase(booksRepository)

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}