package com.example.homework27

import android.app.Application
import com.example.homework27.di.ApplicationComponent
import com.example.homework27.di.DaggerApplicationComponent

class CatApp : Application() {
    val appComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory().create(applicationContext)
    }
}