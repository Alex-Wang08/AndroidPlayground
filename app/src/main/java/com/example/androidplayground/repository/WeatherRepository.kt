package com.example.androidplayground.repository

import com.example.androidplayground.model.Weather
import retrofit2.Response

interface WeatherRepository {
    suspend fun getWeather(): Response<Weather>
}