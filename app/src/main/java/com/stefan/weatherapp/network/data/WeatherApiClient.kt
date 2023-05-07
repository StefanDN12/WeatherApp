package com.stefan.weatherapp.network.data

import com.stefan.weatherapp.core.CommonHelper
import com.stefan.weatherapp.dataclases.WeatherModel
import retrofit2.Response
import retrofit2.http.GET

interface WeatherApiClient {
    @GET("Madrid?unitGroup=us&include=current&key=${CommonHelper.API_KEY}&contentType=json")
    suspend fun getWetherMadrid(): Response<WeatherModel>
}