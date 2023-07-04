package com.dvt.domain.repository

import androidx.lifecycle.LiveData
import com.dvt.domain.model.Weather
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    fun getCurrentWeather(lat:String, lng:String): Flow<Weather>
    fun getLastFiveDays(lat: String, lng: String): Flow<List<Weather>>
}