package com.stefan.weatherapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stefan.weatherapp.dataclases.WeatherModel
import com.stefan.weatherapp.model.WeatherRepository
import kotlinx.coroutines.launch

class WeatherViewModel: ViewModel() {

    private val weatherRepository = WeatherRepository()
    val weatherModel = MutableLiveData<WeatherModel>()
    val isLoading = MutableLiveData<Boolean>()
    fun onCreate(){
        viewModelScope.launch {
            isLoading.postValue(true)
            val response = weatherRepository.getWeather()
            weatherModel.postValue(response)
            isLoading.postValue(false)
        }
    }

    fun obtainWeather(){

    }

}