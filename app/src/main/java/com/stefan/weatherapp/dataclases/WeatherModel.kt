package com.stefan.weatherapp.dataclases

data class WeatherModel(
    val address: String,
    val currentConditions: CurrentConditions,
    val days: List<Day>,
    val latitude: Double,
    val longitude: Double,
    val queryCost: Int,
    val resolvedAddress: String,
    val stations: Stations,
    val timezone: String,
    val tzoffset: Double
)