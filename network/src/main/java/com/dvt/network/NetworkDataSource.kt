package com.dvt.network

import com.dvt.network.model.NetworkFiveDay
import com.dvt.network.model.NetworkWeather


interface NetworkDataSource {
    suspend fun getCurrentWeather(lat:String, lng:String): NetworkWeather

    suspend fun getLastFiveDays(lat: String, lng: String): List<NetworkFiveDay>
}