package com.example.weatherapp.ui

import com.example.weatherapp.MinMaxTempData

sealed class UIStateMinMaxTemp{
    object LoadingState: UIStateMinMaxTemp()
    data class sucessState(val weather: MinMaxTempData): UIStateMinMaxTemp()
    data class ErrorState(val message :String): UIStateMinMaxTemp()
    class CheckConnState() : UIStateMinMaxTemp()
}
