package com.stefan.weatherapp.dataclases

import androidx.room.Embedded
import java.io.Serializable

data class Stations(
    val AT982: AT982,
    val C1784: C1784,
    val F7959: F7959,
    val LEMD: LEMD,
    val LETO: LETO,
    val LEVS: LEVS
): Serializable