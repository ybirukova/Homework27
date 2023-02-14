package com.example.homework27.di

import com.example.homework27.data.BreedRepositoryImpl
import com.example.homework27.data.CatRepositoryImpl
import com.example.homework27.domain.repository.BreedRepository
import com.example.homework27.domain.repository.CatRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun getCatRepository(impl: CatRepositoryImpl): CatRepository

    @Binds
    abstract fun getBreedRepository(impl: BreedRepositoryImpl): BreedRepository
}