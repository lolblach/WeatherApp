package com.lolblach333.weatherapp

import android.app.Application
import com.lolblach333.weatherapp.presentation.modules.networkModule
import com.lolblach333.weatherapp.presentation.modules.repositoryModule
import com.lolblach333.weatherapp.presentation.modules.viewModelModule
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin

class WeatherApp : Application(), KoinComponent {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            printLogger()
            modules(networkModule, repositoryModule, viewModelModule)
        }
    }
}
