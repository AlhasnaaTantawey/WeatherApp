package com.example.weatherapp.ui

import com.example.weatherapp.MainData

data class MainUi(val temp: Double){
    companion object{
        fun toUiModel(main : MainData) :MainUi{
            return MainUi(main.temp)
        }
    }
}
