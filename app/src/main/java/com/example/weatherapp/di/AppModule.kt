package com.example.weatherapp.di

import android.content.Context
import androidx.room.Room
import com.example.weatherapp.data.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun providesMainApplicationInstance(@ApplicationContext context: Context): WeatherModule{
        return context as WeatherModule
    }
    @Provides
    @Singleton
    fun provideRetrofit():Retrofit{
          val baseUrl ="https://api.openweathermap.org/data/2.5/"
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient().newBuilder().build()).build()
    }
    @Singleton
    @Provides
    fun provideRoomDatabase(
       @ApplicationContext app: Context
    ) = Room.databaseBuilder(app,
        WeatherRoomDatabase::class.java,
        "myDatabase").allowMainThreadQueries().build()

    @Singleton
    @Provides
    fun provideDao(db: WeatherRoomDatabase) = db.weatherDao()



}