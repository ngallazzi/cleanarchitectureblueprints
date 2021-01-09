package com.ngallazzi.data.mappers

import com.ngallazzi.data.api.BooksApiResponse
import com.ngallazzi.domain.entities.Volume
import com.ngallazzi.domain.entities.VolumeInfo

class BookApiResponseMapper {
    fun toVolumeList(response: BooksApiResponse): List<Volume> {
        return response.items.map {
            Volume(
                it.id, VolumeInfo(
                    it.volumeInfo.title,
                    it.volumeInfo.authors,
                    it.volumeInfo.imageLinks?.thumbnail?.replace("http", "https")
                )
            )
        }
    }
}