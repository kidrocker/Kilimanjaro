package com.dvt.domain.di


import com.dvt.domain.repository.DataStoreRepository
import com.dvt.domain.repository.ProdSaveFavoriteRepository
import com.dvt.domain.repository.favorite.FavoritesRepository
import com.dvt.domain.repository.favorite.ProdFavoriteRepository
import com.dvt.domain.repository.sync.DataSyncRepository
import com.dvt.domain.repository.sync.ProdDataSyncRepository
import com.dvt.domain.repository.weather.ProdWeatherRepository
import com.dvt.domain.repository.weather.WeatherRepository
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
    ): WeatherRepository

    @Binds
    fun bindDataSyncRepository(
        dataSyncRepository: ProdDataSyncRepository
    ): DataSyncRepository


    @Binds
    fun bindsNetworkMonitor(
        networkMonitor: ConnectivityManagerNetworkMonitor,
    ): NetworkMonitor

    @Binds
    fun bindFavoriteRepository(
        favoritesRepository: ProdFavoriteRepository
    ): FavoritesRepository

    @Binds
    fun bindDataStoreRepository(
        dataStoreRepository: ProdSaveFavoriteRepository
    ): DataStoreRepository


}