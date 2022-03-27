package com.example.androidplayground.di

import com.example.androidplayground.api.TodoApi
import com.example.androidplayground.api.WeatherApi
import com.example.androidplayground.repository.TodoRepository
import com.example.androidplayground.repository.TodoRepositoryImpl
import com.example.androidplayground.repository.WeatherRepository
import com.example.androidplayground.repository.WeatherRepositoryImpl
import com.example.androidplayground.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideTodoRetrofitInstance(): TodoApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL_TODO)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TodoApi::class.java)
    }

    @Provides
    @Singleton
    fun provideTodoRepository(todoApi: TodoApi): TodoRepository {
        return TodoRepositoryImpl(todoApi)
    }

    @Provides
    @Singleton
    fun providesWeatherReportRetrofitInstance(): WeatherApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL_WEATHER)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApi::class.java)
    }

    @Provides
    @Singleton
    fun providesWeatherRepository(weatherApi: WeatherApi) : WeatherRepository {
        return WeatherRepositoryImpl(weatherApi)
    }

}