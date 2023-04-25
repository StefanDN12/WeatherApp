package com.stefan.weatherapp.database.daos

import androidx.room.Dao
import androidx.room.Insert
import com.stefan.weatherapp.dataclases.WeatherModel

@Dao
interface WeatherDao {
    @Insert
    fun insertAll(vararg weatherModel: WeatherModel)
}