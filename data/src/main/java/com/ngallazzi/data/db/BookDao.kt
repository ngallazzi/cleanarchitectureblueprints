package com.ngallazzi.data.db

import androidx.room.*
import com.ngallazzi.data.entities.BookEntity

@Dao
interface BookDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveBook(book: BookEntity)

    @Query("SELECT * FROM book")
    suspend fun getSavedBooks(): List<BookEntity>

    @Delete
    suspend fun deleteBook(book: BookEntity)
}