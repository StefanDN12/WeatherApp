package com.stefan.weatherapp.dataclases

import java.io.Serializable

data class LEVS(
    val contribution: Double,
    val distance: Double,
    val id: String,
    val latitude: Double,
    val longitude: Double,
    val name: String,
    val quality: Int,
    val useCount: Int
): Serializable