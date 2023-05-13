package com.stefan.weatherapp.service

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import com.stefan.weatherapp.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch


class NotificationService : Service() {
    private var job: Job? = null
    private var notification: Notification? = null

    private var temperatura:Int?= 0
    private var condition: String? = ""
    private var humidity: Int?  = 0


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("NotificationService", "onStartCommand")

        with(intent) {
            temperatura = this?.getIntExtra("temperatura", 0)
            condition = this?.getStringExtra("condition")
            humidity = this?.getIntExtra("humidity", 0)
        }

        job = CoroutineScope(Dispatchers.Default).launch {
            while (isActive) {
                sendNotification()
                delay(600000)
            }
        }
        return super.onStartCommand(intent, flags, startId)
    }

    private fun sendNotification() {
        Log.d("NotificationService", "sendNotification")

        val NOTIFICATION_CHANEL_ID = "com.stefan.weatherapp"
        val CHANEL_NAME = "Weather_channel"
        val notificationChannel = NotificationChannel(NOTIFICATION_CHANEL_ID,CHANEL_NAME,NotificationManager.IMPORTANCE_NONE)
        notificationChannel.lightColor = Color.BLUE
        notificationChannel.lockscreenVisibility = Notification.VISIBILITY_PRIVATE
        val manager = (getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager)!!
        manager.createNotificationChannel(notificationChannel)


        val notificationBuilder = NotificationCompat.Builder(this, NOTIFICATION_CHANEL_ID )
        notification = notificationBuilder.setOngoing(true)
            .setContentTitle("El tiempo hoy estara: $condition")
            .setSmallIcon(R.drawable.lluvia)
            .setContentText("Hace una temperatura de:${temperatura}º y la humedad es de: $humidity")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .build()

        startForeground(1,notification)

    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }
}