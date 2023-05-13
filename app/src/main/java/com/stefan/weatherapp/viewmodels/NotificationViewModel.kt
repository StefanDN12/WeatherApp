package com.stefan.weatherapp.viewmodels

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import com.stefan.weatherapp.service.NotificationService



class NotificationViewModel(private val context: Context): ViewModel() {
    private var notificationServiceIntent: Intent? = null
    private var temperatura=0
    private var condition = ""
    private var humidity = 0


    fun updateTemperature(temperature: Int){
        this.temperatura = temperature
    }

    fun updateCondition(condition: String){
        this.condition = condition
    }

    fun updateHumidity(humidity: Int){
        this.humidity = humidity
    }

    fun startNotificationService(context: Context){
        if (notificationServiceIntent == null){
            notificationServiceIntent = Intent(context, NotificationService::class.java).apply {
                putExtra("temperatura", temperatura)
                putExtra("condition", condition)
                putExtra("humidity", humidity)
            }
            ContextCompat.startForegroundService(context, notificationServiceIntent!!)
        }
    }

    public override fun onCleared() {
        if(notificationServiceIntent != null){
            notificationServiceIntent?.let {
                context.stopService(it)
            }
        }
    }


}