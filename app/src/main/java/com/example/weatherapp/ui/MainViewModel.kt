package com.example.weatherapp.ui

import android.app.Application
import androidx.lifecycle.*
import com.example.weatherapp.*
import com.example.weatherapp.data.WeatherRepositary
import com.example.weatherapp.data.WeatherRoomDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(application: Application,val repository :WeatherRepoInterface
) : AndroidViewModel(application) {


// private   var repository :WeatherRepoInterface = WeatherRepositary(application,db.weatherDao(),)
    var arrayOfCountries: Array<String> = getApplication<Application>().baseContext.resources.getStringArray(
        R.array.Country
    )
    val uiStateWeather = MutableLiveData<UIStateWeather>()
    val uiStateMinMaxTemp = MutableLiveData<UIStateMinMaxTemp>()
    val backgroundView = MutableLiveData<Int>()

    fun getWeatherDate(lat: Double, lon: Double) {
       viewModelScope.launch {
            val dataState=repository.getWeatherData(lat, lon)
            uiStateWeather.value = dataState
      }
    }

    fun getMinMaxTemp(lat: Double, lon: Double) {
       viewModelScope.launch {
            val dataState =repository.getMinMaxTemp(lat, lon)
            uiStateMinMaxTemp.value=dataState

    }
    }

    fun getCountryWeather(p2: Int) {
        if (arrayOfCountries[p2].lowercase().equals("cairo".lowercase())) {
            getMinMaxTemp(30.0444, 31.2357)
            getWeatherDate(30.0444, 31.2357)
            backgroundView.value= R.drawable.cairo


        } else if (arrayOfCountries[p2].lowercase().equals("mecca".lowercase())) {
            getMinMaxTemp(21.3891, 39.8579)
            getWeatherDate(21.3891, 39.8579)
            backgroundView.value= R.drawable.mecca

        } else {
            getMinMaxTemp(25.2048, 55.2708)
            getWeatherDate(25.2048, 55.2708)
            backgroundView.value= R.drawable.dubai

        }
    }

//    class PairMediatorLiveData<F, S>(firstLiveData: LiveData<F>, secondLiveData: LiveData<S>) :
//        MediatorLiveData<Pair<F?, S?>>() {
//        init {
//            addSource(firstLiveData) {firstLiveDataValue: F ->
//                value = firstLiveDataValue to secondLiveData.value }
//            addSource(secondLiveData) { secondLiveDataValue: S ->
//                value = firstLiveData.value to secondLiveDataValue }
//        }
//    }

}

