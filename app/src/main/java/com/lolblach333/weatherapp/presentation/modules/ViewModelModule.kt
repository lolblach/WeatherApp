package com.lolblach333.weatherapp.presentation.modules

import com.lolblach333.weatherapp.presentation.ui.main.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}
