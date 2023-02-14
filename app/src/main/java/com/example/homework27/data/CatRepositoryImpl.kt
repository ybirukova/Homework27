package com.example.homework27.data

import com.example.homework27.Service
import com.example.homework27.data.mappers.CatMapper
import com.example.homework27.domain.models.CatData
import com.example.homework27.domain.repository.CatRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CatRepositoryImpl @Inject constructor(
    private val mapperCat: CatMapper,
    private val service: Service
) : CatRepository {

    override suspend fun getImagesUrl(id: String): List<CatData> {

        return withContext(Dispatchers.IO) {
            service.getService().getCatImage(id).execute().body()?.map { mapperCat(it) }
                ?: throw Exception()
        }
    }
}