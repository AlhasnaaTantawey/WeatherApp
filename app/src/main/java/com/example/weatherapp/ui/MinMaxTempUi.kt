package com.example.weatherapp.ui

import com.example.weatherapp.ConditionWeather
import com.example.weatherapp.MinMaxTempData


data class MinMaxTempUi(
    val list: List<ConditionWeather>
){
    companion object{
        fun toUiModel(minMaxTempData: MinMaxTempData) : MinMaxTempUi  {
            return MinMaxTempUi(minMaxTempData.list!!)
        }
    }
}
