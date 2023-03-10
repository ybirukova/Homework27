package com.example.homework27.di.modules

import com.example.homework27.data.BreedRepositoryImpl
import com.example.homework27.data.CatRepositoryImpl
import com.example.homework27.domain.repository.BreedRepository
import com.example.homework27.domain.repository.CatRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun getCatRepository(impl: CatRepositoryImpl): CatRepository

    @Binds
    @Singleton
    abstract fun getBreedRepository(impl: BreedRepositoryImpl): BreedRepository
}