package com.example.weatherapp.data

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

private  val baseUrl ="https://api.openweathermap.org/data/2.5/"
    fun getInstance(): Retrofit{
      return Retrofit.Builder()
          .baseUrl(baseUrl)
          .addConverterFactory(GsonConverterFactory.create())
          .client(OkHttpClient().newBuilder().build())
          .build()
    }
}