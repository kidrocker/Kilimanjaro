package com.dvt.domain.di

import com.dvt.domain.repository.ProdWeatherRepository
import com.dvt.domain.repository.WeatherRepository
import com.dvt.domain.util.ConnectivityManagerNetworkMonitor
import com.dvt.domain.util.NetworkMonitor
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindWeatherRepository(
        weatherRepository: ProdWeatherRepository
    ):WeatherRepository


    @Binds
    fun bindsNetworkMonitor(
        networkMonitor: ConnectivityManagerNetworkMonitor,
    ): NetworkMonitor
}