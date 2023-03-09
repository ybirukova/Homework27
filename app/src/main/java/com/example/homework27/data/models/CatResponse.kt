package com.example.homework27.data.models

import com.google.gson.annotations.SerializedName

data class CatResponse(
    @SerializedName("url") val imageUrl: String? = null
)