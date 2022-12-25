package com.example.weatherapp.ui

import com.example.weatherapp.Main2DataMinMax


data class Main2UiMinMax(val temp_max: Double, val temp_min: Double){
    companion object{
        fun toUiModel(main2DataMinMax: Main2DataMinMax) : Main2UiMinMax {
            return Main2UiMinMax(main2DataMinMax.temp_max,main2DataMinMax.temp_min)
        }
    }
}
