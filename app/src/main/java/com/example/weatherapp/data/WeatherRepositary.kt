package com.example.weatherapp.data

import android.annotation.SuppressLint
import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.weatherapp.MinMaxTempData
import com.example.weatherapp.WeatherData
import com.example.weatherapp.ui.UIStateMinMaxTemp
import com.example.weatherapp.ui.UIStateWeather
import com.example.weatherapp.tools.NetworkHelper
import com.example.weatherapp.ui.WeatherRepoInterface
import retrofit2.Retrofit
import javax.inject.Inject

class WeatherRepositary @Inject constructor (var  application :Application,
                                             val dao : WeatherDao,var apiInterface : ApiInterface) : WeatherRepoInterface {

    init {
//        retrofit= RetrofitClient.getInstance()
//        apiInterface=  retrofit.create(ApiInterface::class.java)
    }


    override suspend fun getWeatherData(lat :Double, lon :Double): UIStateWeather {
        var result : UIStateWeather?=null
        if(NetworkHelper().isConnected(application)==false){
            result= UIStateWeather.CheckConnState()
        }else {
            try {
                val response = apiInterface.getWeatherData(lat, lon).body()
                if (response != null) {
                    //insert dtabase
                    insert(response)
                    //get data from database
                    result = getWeatherDatae(lat, lon)
                }

            } catch (e: Exception) {
                Log.d("alhasnaa", "getWeatherData: failure")
                result= UIStateWeather.ErrorState(e.message ?: "failed")
            }
        }
        return result!!
    }


    override suspend fun getMinMaxTemp(lat :Double, lon :Double): UIStateMinMaxTemp {
        var result : UIStateMinMaxTemp
        if(NetworkHelper().isConnected(application)==false){
            result= UIStateMinMaxTemp.CheckConnState()
        }
        else {
            try {
                val response = apiInterface.getMinAndMaxTemp(lat, lon).body()!!
                //insert dtabase
                insertMinMax(response)

                result = getMinMaxData(lat, lon)
            } catch (e: Exception) {
                Log.d("tt", "getMinAndMaxTemp: failure")
                result= UIStateMinMaxTemp.ErrorState(e.message ?: "failed")
            }
       }
        return result

    }


     fun insert(weather :WeatherData) {
        dao.insert(weather)
    }
   fun insertMinMax(weather :MinMaxTempData) {
        dao.insertMinMax(weather)
    }

     fun getWeatherDatae(lat:Double, lon :Double):UIStateWeather {
       return UIStateWeather.sucessState(dao.getWeatherData())
    }

     fun getMinMaxData(lat:Double, lon :Double): UIStateMinMaxTemp{
        return UIStateMinMaxTemp.sucessState(dao.getMinMaxData())
    }


}