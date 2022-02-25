package com.example.androidplayground.repository

import com.example.androidplayground.api.WeatherApi
import com.example.androidplayground.model.Weather
import retrofit2.Response

class WeatherRepositoryImpl(
    private val weatherApi: WeatherApi
) : WeatherRepository {

    override suspend fun getWeather(): Response<Weather> {
        return weatherApi.getWeather()
    }
}