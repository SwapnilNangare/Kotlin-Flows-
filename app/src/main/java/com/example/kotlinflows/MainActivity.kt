package com.example.kotlinflows

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    val channel = Channel<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        producer()
        consumer()
    }

    // Channels Introduction
    fun producer() {

        CoroutineScope(Dispatchers.Main).launch {
            channel.send(1)
            channel.send(2)
        }


    }

    fun consumer() {

        CoroutineScope(Dispatchers.Main).launch {
//            channel.receive()
//            channel.receive()
            Log.d("consumer", channel.receive().toString())
            Log.d("consumer", channel.receive().toString())
        }

    }
}