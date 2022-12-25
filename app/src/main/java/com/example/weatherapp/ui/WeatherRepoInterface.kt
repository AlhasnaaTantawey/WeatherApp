package com.example.weatherapp.ui

import androidx.lifecycle.LiveData
import com.example.weatherapp.MinMaxTempData
import com.example.weatherapp.WeatherData


interface WeatherRepoInterface {
    suspend fun getWeatherData(lat :Double,lon :Double): UIStateWeather
    suspend fun getMinMaxTemp(lat :Double,lon :Double): UIStateMinMaxTemp
}