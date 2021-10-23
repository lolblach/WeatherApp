package com.lolblach333.weatherapp.presentation.modules

import com.lolblach333.weatherapp.domain.WeatherRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { WeatherRepository() }
}
