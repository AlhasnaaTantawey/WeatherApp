package com.example.weatherapp.ui

import com.example.weatherapp.WeatherData


sealed class UIStateWeather(){
    object LoadingState: UIStateWeather()
    data class sucessState(val weather: WeatherData): UIStateWeather()
   data class ErrorState(val message :String): UIStateWeather()
    class CheckConnState() : UIStateWeather()

}
