package com.example.androidplayground.activities.weatherreport

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidplayground.model.Weather
import com.example.androidplayground.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

const val LOG_TAG = "WeatherReportViewModel"

@HiltViewModel
class WeatherReportViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository
): ViewModel() {

    private val _resp = MutableLiveData<Weather>()
    val weatherResp : LiveData<Weather>
        get() = _resp


    init {
        getWeather()
    }


    private fun getWeather() = viewModelScope.launch {

        weatherRepository.getWeather().let { response ->
            if (response.isSuccessful) {
                _resp.postValue(response.body())
            } else {
                Log.d(LOG_TAG, "getWeather Error Response: ${response.message()}")
            }
        }
    }
}