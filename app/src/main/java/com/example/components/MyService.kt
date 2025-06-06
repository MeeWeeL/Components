package com.example.components

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService : Service() {
    override fun onCreate() {
        super.onCreate()
        Log.d("COMPONENT_TRACE", "Service: onCreate() called")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("SERVICE", "Service: onStartCommand() called")
        Thread {
            repeat(5) {
                Log.d("SERVICE", "Working... $it")
                Thread.sleep(1000)
            }
            stopSelf()
        }.start()

        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}
