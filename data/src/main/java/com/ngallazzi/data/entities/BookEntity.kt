package com.ngallazzi.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book")
data class BookEntity(
    @PrimaryKey
    val id: String,
    val title: String,
    val authors: List<String>,
    val imageUrl: String?
)