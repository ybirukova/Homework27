package com.example.homework27.data.mappers

import com.example.homework27.data.models.CatResponse
import com.example.homework27.domain.models.CatData
import javax.inject.Inject

class CatMapper @Inject constructor() {

    operator fun invoke(response: CatResponse) = with(response) {
        CatData(
            imageUrl = imageUrl.orEmpty()
        )
    }
}