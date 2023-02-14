package com.example.homework27.data

import com.example.homework27.Service
import com.example.homework27.data.mappers.BreedMapper
import com.example.homework27.domain.models.BreedData
import com.example.homework27.domain.repository.BreedRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BreedRepositoryImpl @Inject constructor(
    private val mapperBreed: BreedMapper,
    private val service: Service
) :
    BreedRepository {

    override suspend fun getListOfBreeds(): List<BreedData> {

        return withContext(Dispatchers.IO) {
            service.getService().getListOfBreeds().execute().body()?.map { mapperBreed(it) }
                ?: throw Exception()
        }
    }

    override suspend fun getListOfBreedNames(): List<String> {
        val listOfBreed = getListOfBreeds()
        val listOfBreedName: MutableList<String> = mutableListOf()
        for (breed in listOfBreed) {
            breed.breed?.let { name -> listOfBreedName.add(name) }
        }
        return listOfBreedName
    }
}