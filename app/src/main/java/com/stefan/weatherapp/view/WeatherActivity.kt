package com.stefan.weatherapp.view

import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.stefan.weatherapp.databinding.ActivityMainBinding
import com.stefan.weatherapp.viewmodels.WeatherViewModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.*
import kotlin.math.roundToInt

class WeatherActivity : AppCompatActivity() {
    private val weatherViewModel: WeatherViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private val currentDate = LocalDate.now().dayOfMonth

    private val LifecycleOwner = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        weatherViewModel.onCreate()
        Log.d("Fecha", currentDate.toString())

        binding.apply {

            weatherViewModel.isLoading.observe(LifecycleOwner, Observer {
                if (it) {
                    progressBar.isVisible = it;
                } else {
                    progressBar.isVisible = it;
                    imgVWeatherIcon.isVisible = true
                    txtWeatherCondition.isVisible = true
                    cardLayout.isVisible = true
                }

            })

            weatherViewModel.weatherModel.observe(LifecycleOwner, Observer { weatherResponse ->
                weatherResponse.days.forEach { day ->
                    when {
                        (currentDate == day.datetime.split("-")[2].toInt()) -> {
                            txtWeatherTemp.text = "${((((day.temp - 32) * 5) / 9).roundToInt())}°"
                            txtHumidity.text = "H" + day.humidity.roundToInt()
                            imgVWeatherIcon.setImageResource(
                                resources.getIdentifier(
                                    applicationContext.packageName + ":drawable/" + day.icon.replace(
                                        "-",
                                        "_"
                                    ),
                                    null,
                                    null
                                )
                            )
                            txtWinsSpeed.text = "WS" + day.windspeed.roundToInt()
                            txtWeatherCondition.text = day.conditions
                        }
                    }
                    Log.d(
                        "DAY",
                        LocalDate.parse(
                            day.datetime,
                            DateTimeFormatter.ofPattern("yyyy-MM-dd")
                        ).dayOfWeek.getDisplayName(TextStyle.FULL, Locale.getDefault())
                    )
                }
                this.txtDay1.text = LocalDate.parse(
                    weatherResponse.days[2].datetime,
                    DateTimeFormatter.ofPattern("yyyy-MM-dd")
                ).dayOfWeek.getDisplayName(TextStyle.FULL, Locale.getDefault()).take(3)
                this.txtDay2.text = LocalDate.parse(
                    weatherResponse.days[1].datetime,
                    DateTimeFormatter.ofPattern("yyyy-MM-dd")
                ).dayOfWeek.getDisplayName(TextStyle.FULL, Locale.getDefault()).take(3)
                this.txtDay3.text = LocalDate.parse(
                    weatherResponse.days[3].datetime,
                    DateTimeFormatter.ofPattern("yyyy-MM-dd")
                ).dayOfWeek.getDisplayName(TextStyle.FULL, Locale.getDefault()).take(3)

                this.ImgViwDay1.setImageResource(
                    resources.getIdentifier(
                        applicationContext.packageName + ":drawable/" + weatherResponse.days[1].icon.replace(
                            "-",
                            "_"
                        ), null, null
                    )
                )
                this.ImgViwDay2.setImageResource(
                    resources.getIdentifier(
                        applicationContext.packageName + ":drawable/" + weatherResponse.days[2].icon.replace(
                            "-",
                            "_"
                        ), null, null
                    )
                )
                this.ImgViwDay3.setImageResource(
                    resources.getIdentifier(
                        applicationContext.packageName + ":drawable/" + weatherResponse.days[3].icon.replace(
                            "-",
                            "_"
                        ), null, null
                    )
                )

            })
        }
    }
}