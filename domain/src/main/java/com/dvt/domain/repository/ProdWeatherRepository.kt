package com.dvt.domain.repository

import com.dvt.database.dao.WeatherDao
import com.dvt.database.model.WeatherEntity
import com.dvt.domain.model.Weather
import com.dvt.network.NetworkDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.datetime.Clock
import javax.inject.Inject

class ProdWeatherRepository @Inject constructor(
    private val weatherDao: WeatherDao,
    private val network: NetworkDataSource
) : WeatherRepository {
    override fun getCurrentWeather(lat: String, lng: String): Flow<Weather> {
        TODO("Not yet implemented")
    }

    override fun getLastFiveDays(lat: String, lng: String): Flow<List<Weather>> =
        weatherDao.getLastFiveDays(lat, lng)
            .map { entities ->
                entities.map {
                    Weather(
                        min = it.min.toString(),
                        current = it.current.toString(),
                        max = it.max.toString()
                    )
                }
            }

    suspend fun getLastFiveFromApi(lat: String, lng: String) {
        val response = network.getLastFiveDays(lat, lng).map { networkWeather ->
            WeatherEntity(
                id = networkWeather.id.toString(),
                min = networkWeather.main.tempMin,
                current = networkWeather.main.temp,
                max = networkWeather.main.tempMax,
                lat = lat,
                lng = lng,
                lastUpdated = Clock.System.now()
            )
        }
        weatherDao.deleteCurrentLocation(lat, lng)
        weatherDao.insertWeather(response)
    }
}