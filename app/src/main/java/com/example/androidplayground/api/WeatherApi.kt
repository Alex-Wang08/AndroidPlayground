package com.example.androidplayground.api

import com.example.androidplayground.model.Weather
import retrofit2.Response
import retrofit2.http.GET

interface WeatherApi {
    @GET("weather/Luanda")
    suspend fun getWeather(): Response<Weather>
}