package com.stefan.weatherapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.stefan.weatherapp.core.Converters
import com.stefan.weatherapp.dataclases.WeatherModel

//@Database(entities = [WeatherModel::class], version = 1)
//@TypeConverters(Converters::class)
abstract class WeatherRoom: RoomDatabase() {

}