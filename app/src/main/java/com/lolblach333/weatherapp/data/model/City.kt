package com.lolblach333.weatherapp.data.model

data class City(
    val name: String,
    val coords: Coordinates,
    val district: String,
    val population: Int,
    val subject: String
)

data class Coordinates(val lat: Double, val lon: Double)
