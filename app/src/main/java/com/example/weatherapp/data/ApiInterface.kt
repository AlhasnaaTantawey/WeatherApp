package com.example.weatherapp.data

import com.example.weatherapp.MinMaxTempData
import com.example.weatherapp.WeatherData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("weather")
    suspend fun getWeatherData(@Query("lat") lat :Double,@Query("lon") lon :Double,
                               @Query("appid") appid :String="2f7161cd23082220dd968bfe1f403d49",@Query("units") units:String="metric") :Response<WeatherData>

    @GET("forecast")
    suspend fun getMinAndMaxTemp(@Query("lat") lat :Double,@Query("lon") lon :Double,
   @Query("appid") appid :String="771e398487d1375cc14509c4bf2bff25",@Query("units") units:String="metric") :Response<MinMaxTempData>

}