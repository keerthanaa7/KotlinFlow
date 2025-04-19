package com.example.kotlinflow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingTotal:Int):ViewModel() {
    private var count = MutableLiveData<Int>()
    val result :LiveData<Int>
        get() = count

    init {
        count.value = startingTotal
    }

    private fun setTotal(input:Int) {
        count.value = count.value?.plus(input)
    }
}