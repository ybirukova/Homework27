package com.example.homework27.domain.repository

import com.example.homework27.domain.models.BreedData

interface BreedRepository {

    suspend fun getListOfBreeds(): List<BreedData>

    suspend fun getListOfBreedNames(): List<String>
}