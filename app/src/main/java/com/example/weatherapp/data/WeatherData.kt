package com.example.weatherapp

import androidx.room.*
import com.example.weatherapp.data.MainWeatherConverter
import com.example.weatherapp.data.WeatherDataListConverter
@Entity
@TypeConverters(MainWeatherConverter::class,WeatherDataListConverter::class)
data class WeatherData (
    @PrimaryKey(autoGenerate = true)
    var id: Int=0,
    var main: MainData?=null,
    var weather: MutableList<WeatherDataList>?=null
){ constructor(): this(0, null, null)
}

data class WeatherDataList(
    var icon: String?=null,
    var main: String?=null
)
{
    constructor():this ("", "")
}
data class MainData (
    var temp: Double=0.0
 )
{
    constructor(): this(0.0)
}