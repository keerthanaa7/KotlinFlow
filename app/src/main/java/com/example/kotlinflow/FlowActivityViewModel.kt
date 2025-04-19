package com.example.kotlinflow

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class FlowActivityViewModel(startingValue:Int): ViewModel() {

    private var flowVal = MutableStateFlow(0)
     val flowOutput:StateFlow<Int> = flowVal

    init {
        flowVal.value = startingValue
    }

    fun setFlowTotal(input:Int){
        flowVal.value = flowVal.value.plus(input)
    }

}