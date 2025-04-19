package com.example.kotlinflow

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class FlowViewModel : ViewModel() {

    val flowViewModel = flow<Int> {
        for (i in 1..100) {
            emit(i)
            delay(1000)
            Log.d("MainActivity ", "Produced ${i}")
        }
    }

    init {
        BackPressureDemo()
    }

    //Producer
    private fun BackPressureDemo() {
        val backPressureFlow = flow<Int> {
            for (i in 1..10) {
                Log.d("MainActivity ", "Produced ${i}")
                emit(i)
                delay(1000)
            }
        }

        //Consumer will consume after producer produce it
        /*   viewModelScope.launch {
               backPressureFlow.collect{
                   delay(2000)
                   Log.d("MainActivity " , "consumed ${it}")
               }
           }*/

        // consumer will consume and producer will produce concurrently/independently
        /* viewModelScope.launch {
             backPressureFlow.buffer().collect{
                 delay(2000)
                 Log.d("MainActivity " , "consumed ${it}")
             }
         }*/

        // consume the latest value
        viewModelScope.launch {
            backPressureFlow.filter { it ->
                it % 3 == 0
            }.map { it ->
                showMessage(it)
            }
                .collect {
                    Log.d("MainActivity ", "consumed ${it}")
                }
        }
    }

    private fun showMessage(count: Int): String {
        return "Hello ${count}"
    }

}