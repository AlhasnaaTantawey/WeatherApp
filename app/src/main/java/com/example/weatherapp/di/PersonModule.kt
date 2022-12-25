package com.example.weatherapp.di

import com.example.weatherapp.Person
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object PersonModule {

    @Provides
    fun ProvidePerson(): Person {
        return Person("alhasnaa",23)
    }
}