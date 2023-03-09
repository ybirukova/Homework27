package com.example.homework27.data.models

import com.google.gson.annotations.SerializedName

data class BreedResponse(
    @SerializedName
        ("id") val breedId: String? = null,
    @SerializedName
        ("name") val breed: String? = null
)
