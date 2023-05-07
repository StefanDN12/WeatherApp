package com.stefan.weatherapp.model

import com.stefan.weatherapp.dataclases.*
import com.stefan.weatherapp.network.Retrofit
import com.stefan.weatherapp.network.data.WeatherApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WeatherRepository {
    private val retrofit = Retrofit.getRetrofit()


    suspend fun getWeather(): WeatherModel{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(WeatherApiClient::class.java).getWetherMadrid()
            response.body() ?: WeatherModel("",
                CurrentConditions(0.0,"","",0,0.0,0.0,0.0,"",
                    0.0,0.0,0.0,"",0.0,0.0,0.0,0.0,0.0,"",
                emptyList(),"",0,"",0,0.0,0.0,0.0,0.0,"",0.0
                ), emptyList(),0.0,0.0,0,"", Stations(
                    AT982(0.0,0.0,"",0.0,0.0,"",0,0),
                    C1784(0.0,0.0,"",0.0,0.0,"",0,0),
                    F7959(0.0,0.0,"",0.0,0.0,"",0,0),
                    LEMD(0.0,0.0,"",0.0,0.0,"",0,0),
                    LETO(0.0,0.0,"",0.0,0.0,"",0,0),
                    LEVS(0.0,0.0,"",0.0,0.0,"",0,0)
                ),"",0.0
            )
        }
    }
}