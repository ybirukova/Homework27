package com.example.homework27.data.mappers

import com.example.homework27.data.models.BreedResponse
import com.example.homework27.domain.models.BreedData
import javax.inject.Inject

class BreedMapper @Inject constructor() {

    operator fun invoke(response: BreedResponse) = with(response) {
        BreedData(
            breedId = breedId.orEmpty(),
            breed = breed.orEmpty()
        )
    }
}