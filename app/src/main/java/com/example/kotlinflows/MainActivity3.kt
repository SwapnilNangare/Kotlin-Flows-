package com.example.kotlinflows

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import java.util.concurrent.Flow

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        GlobalScope.launch {
            producer()
            /*
             .onStart {
                 emit(-1)
                 Log.d("Swap", "STARTING OUT")
             }
             .onCompletion {
                 emit(11)
                 Log.d("Swap", "COMPLETED")

             }
             .onEach {
                 Log.d("Swap", "ABOUT TO EMIT -$")

             }
             .collect {
                 Log.d("Swap", "${it.toString()}")

             }


             */
        }
    }

    fun producer(): kotlinx.coroutines.flow.Flow<Int> {
        return flow<Int> {
            val list = listOf(1, 2, 3, 4, 5)
            list.forEach {
                delay(1000)
                emit(it)
            }
        }


    }
}