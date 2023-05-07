package com.stefan.weatherapp.network
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit {
    fun getRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}