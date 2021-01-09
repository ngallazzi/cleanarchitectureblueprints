package com.ngallazzi.data.mappers

import com.ngallazzi.data.entities.BookEntity
import com.ngallazzi.domain.entities.Volume
import com.ngallazzi.domain.entities.VolumeInfo

class BookEntityMapper {
    fun toBookEntity(volume: Volume): BookEntity {
        return BookEntity(
            id = volume.id,
            title = volume.volumeInfo.title,
            authors = volume.volumeInfo.authors,
            imageUrl = volume.volumeInfo.imageUrl
        )
    }

    fun toVolume(bookEntity: BookEntity): Volume {
        return Volume(
            bookEntity.id,
            VolumeInfo(bookEntity.title, bookEntity.authors, bookEntity.imageUrl)
        )
    }
}