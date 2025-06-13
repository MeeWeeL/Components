package com.example.components

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class Receiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        Log.d("COMPONENT_TRACE", "BroadcastReceiver: onReceive() called")
    }
}
