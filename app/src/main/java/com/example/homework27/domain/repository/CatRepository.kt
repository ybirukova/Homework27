package com.example.homework27.domain.repository

import com.example.homework27.domain.models.CatData

interface CatRepository {

    suspend fun getImagesUrl(id: String): List<CatData>
}