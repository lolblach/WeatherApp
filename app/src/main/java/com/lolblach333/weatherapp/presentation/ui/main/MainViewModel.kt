package com.lolblach333.weatherapp.presentation.ui.main

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.lolblach333.weatherapp.data.model.City
import com.google.gson.reflect.TypeToken
import com.lolblach333.weatherapp.R

class MainViewModel(private val gson: Gson) : ViewModel() {

    val citiesLiveData: LiveData<List<City?>?>
        get() = _citiesLiveData

    private val _citiesLiveData = MutableLiveData<List<City?>?>()

    fun getCities(context: Context) {
        _citiesLiveData.value = readCitiesFromJson(context)
    }

    private fun readCitiesFromJson(context: Context): List<City?>? {
        val stringJson = getJsonFromAssets(context)
        val typeToken = object : TypeToken<List<City?>?>() {}

        return gson.fromJson(stringJson, typeToken.type)
    }

    private fun getJsonFromAssets(context: Context): String {
        return context.resources.openRawResource(R.raw.russian_cities)
            .bufferedReader()
            .use { it.readText() }
    }
}
