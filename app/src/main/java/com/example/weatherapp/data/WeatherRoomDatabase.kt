package com.example.weatherapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.weatherapp.MinMaxTempData
import com.example.weatherapp.WeatherData

@Database(entities = arrayOf(WeatherData::class,MinMaxTempData::class), version = 1, exportSchema = false)

abstract class WeatherRoomDatabase : RoomDatabase() {
    abstract fun weatherDao(): WeatherDao


}