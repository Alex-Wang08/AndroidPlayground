package com.example.androidplayground.activities.flow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class FlowViewModel : ViewModel() {

    // cold flow
    val countDownFlow = flow<Int> {
        val startingValue = 10
        var currentValue = startingValue
        emit(startingValue)

        while(currentValue > 0) {
            delay(1000L)
            currentValue--
            emit(currentValue)

        }
    }

    init {
        collectFlow()
//        viewModelScope.launch {
//            shareFlow.collect {
//
//            }
//        }
    }

    private fun collectFlow() {
        viewModelScope.launch {
            countDownFlow.collect { time ->
                println("the current time is $time")
            }
        }
    }

    // StateFlow and SharedFlow
    private val _stateFlow = MutableStateFlow(0)
    val stateFlow = _stateFlow.asStateFlow()

    fun incrementCounter() {
        _stateFlow.value += 1
    }


    private val _shareFlow = MutableSharedFlow<Int>(0)
    val shareFlow = _stateFlow.asSharedFlow()

    fun squareNumber(number: Int) {

        viewModelScope.launch {

        }
        _shareFlow
    }





}