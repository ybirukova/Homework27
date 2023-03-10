package com.example.homework27.di.modules

import com.example.homework27.data.network.CatService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun getRetrofit(): Retrofit {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()

        val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://api.thecatapi.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit
    }

    @Provides
    @Singleton
    fun getService(retrofit: Retrofit): CatService {
        return retrofit.create(CatService::class.java)
    }
}