package com.stefan.weatherapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.stefan.weatherapp.R

class WeatherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}