package com.stefan.weatherapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.stefan.weatherapp.dataclases.WeatherModel

@Database(entities = [WeatherModel::class], version = 1)
abstract class WeatherRoom: RoomDatabase() {

}