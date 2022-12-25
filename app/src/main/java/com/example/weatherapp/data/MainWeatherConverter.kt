package com.example.weatherapp.data

import androidx.room.TypeConverter
import com.example.weatherapp.ConditionWeather
import com.example.weatherapp.MainData
import com.example.weatherapp.WeatherDataList
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class MainWeatherConverter {
    @TypeConverter
    fun fromTemp(value: Double?): MainData? {
        return value?.let { MainData(it) }
    }

    @TypeConverter
    fun dateToTemp(date: MainData?): Double? {
        return date?.temp
    }
}

class WeatherDataListConverter {

    @TypeConverter
    fun fromString(value: String): List<WeatherDataList> {
        val listType = object : TypeToken<List<WeatherDataList>>() {}.type
        return Gson().fromJson(value, listType)
    }

        @TypeConverter
        fun fromListLisr(list: List<WeatherDataList>): String {
            val gson = Gson()
            return gson.toJson(list)
        }

}

class ConditionWeatherListConverter {


    @TypeConverter
    fun fromString(value: String): List<ConditionWeather> {
        val listType = object : TypeToken<List<ConditionWeather>>() {}.type
        return Gson().fromJson(value, listType)}

    @TypeConverter
    fun fromListLisr(list: List<ConditionWeather>): String {
        val gson = Gson()
        return gson.toJson(list)
    }

}