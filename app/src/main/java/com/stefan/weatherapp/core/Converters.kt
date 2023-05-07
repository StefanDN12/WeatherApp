package com.stefan.weatherapp.core

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
//    private val gson = Gson()
//
//    @TypeConverter
//    fun <T> fromJson(json: String, type: Class<T>): T {
//        return gson.fromJson(json, type)
//    }
//
//    @TypeConverter
//    fun <T> toJson(obj: T): String {
//        return gson.toJson(obj)
//    }
//
//    @TypeConverter
//    inline fun <reified T> fromJson(json: String): T {
//        return fromJson(json, object : TypeToken<T>() {}.rawType as Class<T>)
//    }
//
////    @TypeConverter
////    inline fun <reified T> toJson(obj: T): String {
////        return toJson(obj, T::class.java)
////    }
//
//    companion object {
//        @JvmStatic
//        fun <T> fromJson(json: String, type: Class<T>): T {
//            return Converters().fromJson(json, type)
//        }
//
//        @JvmStatic
//        fun <T> toJson(obj: T): String {
//            return Converters().toJson(obj)
//        }
//    }
}