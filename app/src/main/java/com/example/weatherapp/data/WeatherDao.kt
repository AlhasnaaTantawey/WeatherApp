package com.example.weatherapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.weatherapp.MinMaxTempData
import com.example.weatherapp.WeatherData
import com.example.weatherapp.ui.UIStateWeather

@Dao
interface WeatherDao {
   @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(weatherData: WeatherData)

    @Query("select * from WeatherData")
     fun getWeatherData() :WeatherData

    @Insert
     fun insertMinMax(weatherData: MinMaxTempData)

    @Query("select * from MinMaxTempData  ")
      fun getMinMaxData() :MinMaxTempData

}
