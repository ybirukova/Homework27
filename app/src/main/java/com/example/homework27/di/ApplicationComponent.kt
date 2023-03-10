package com.example.homework27.di

import android.content.Context
import com.example.homework27.di.modules.DataModule
import com.example.homework27.di.modules.NetworkModule
import com.example.homework27.ui.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules = [DataModule::class, NetworkModule::class, ViewModelModule::class])
@Singleton
interface ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }

    fun inject(activity: MainActivity)
}