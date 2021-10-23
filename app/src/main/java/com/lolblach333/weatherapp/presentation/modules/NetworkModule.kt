package com.lolblach333.weatherapp.presentation.modules

import com.google.gson.Gson
import org.koin.dsl.module

val networkModule = module {
    single { Gson() }
}
