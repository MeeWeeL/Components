package com.example.components

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.RECEIVER_EXPORTED
import com.example.components.ui.theme.ComponentsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("COMPONENT_TRACE", "Activity: onCreate() called")
        service()
        receiver()
        enableEdgeToEdge()
        setContent {
            ComponentsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

private fun ComponentActivity.service() {
    val serviceIntent = Intent(this, MyService::class.java)
    startService(serviceIntent)
}

private fun ComponentActivity.receiver() {
    val receiver = Receiver()
    val filter = IntentFilter().apply {
        addAction("MY_CUSTOM_ACTION")
        addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
    }
    ContextCompat.registerReceiver(this, receiver, filter, RECEIVER_EXPORTED)
    sendBroadcast(Intent("MY_CUSTOM_ACTION"))
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComponentsTheme {
        Greeting("Android")
    }
}
