package com.example.weatherapp.ui

import com.example.weatherapp.WeatherDataList


data class WeatherUiList(
    val icon: String,
    val main: String
){
    companion object{
        fun toUiModel(weatherDataList: WeatherDataList) :WeatherDataList{
            return WeatherDataList(weatherDataList.icon,weatherDataList.main)
        }
    }
}
