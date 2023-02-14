package com.example.homework27

import com.example.homework27.data.models.BreedResponse
import com.example.homework27.data.models.CatResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CatService {
    @GET("images/search")
    fun getCatImage(@Query("breed_ids") id: String): Call<List<CatResponse>>

    @GET("breeds")
    fun getListOfBreeds(): Call<List<BreedResponse>>
}