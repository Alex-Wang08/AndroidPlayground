package com.example.androidplayground.coroutine

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Mistake5ViewModel : ViewModel() {

//    suspend fun postValueToApi() {
//        delay(10000L)
//    }
    fun postValueToApi() {
        viewModelScope.launch {
            delay(10000L)
        }
    }
}