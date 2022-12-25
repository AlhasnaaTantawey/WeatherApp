package com.example.weatherapp.di

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherapp.data.ApiInterface
import com.example.weatherapp.data.WeatherDao
import com.example.weatherapp.data.WeatherRepositary
import com.example.weatherapp.data.WeatherRoomDatabase
import com.example.weatherapp.ui.WeatherRepoInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
object WeatherModule {



    @Provides
    fun provideWeatherPeposatory(  app:Application,
                                  dao :WeatherDao,apiInterface: ApiInterface):WeatherRepoInterface{
        return WeatherRepositary( app,dao,apiInterface)
    }

    @Provides
    fun provideApiInterface(retrofit: Retrofit):ApiInterface{
        return retrofit.create(ApiInterface::class.java)
    }
}