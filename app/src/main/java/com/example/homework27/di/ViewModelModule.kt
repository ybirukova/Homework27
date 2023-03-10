package com.example.homework27.di

import androidx.lifecycle.ViewModel
import com.example.homework27.ui.CatViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(CatViewModel::class)
    fun bindCatViewModel(viewModel: CatViewModel): ViewModel
}