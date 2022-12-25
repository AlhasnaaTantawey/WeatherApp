package com.example.weatherapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.weatherapp.data.ConditionWeatherListConverter

@Entity
@TypeConverters(ConditionWeatherListConverter::class)
data class MinMaxTempData(
    @PrimaryKey(autoGenerate = true)
    var id: Int=0,
    var list: List<ConditionWeather>?=null
    ){ constructor(): this(0, null)
}

data class ConditionWeather(
    var main: Main2DataMinMax?=null,
    var dt_txt: String?=null,
    var weather: List<Weather2>?=null
){ constructor(): this(null,null, null)
}

data class Main2DataMinMax(
    var temp_max: Double=0.0,
    var temp_min: Double=0.0,
    var temp: Double=0.0
){ constructor(): this(0.0,0.0,0.0)
}
data class Weather2(
    var description: String?=null,
    var icon: String?=null,
    var main: String?=null
){ constructor(): this(null,null, null)}