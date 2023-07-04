package com.dvt.database.di

import com.dvt.database.KilimanjaroDatabase
import com.dvt.database.dao.WeatherDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DaosModule {
    @Provides
    fun provideWeatherDao(
        database: KilimanjaroDatabase
    ):WeatherDao = database.weatherDao()
}