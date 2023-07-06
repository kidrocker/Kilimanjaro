package com.dvt.network.retrofit

import com.dvt.network.NetworkResponse
import com.dvt.network.model.NetworkFiveDay
import com.dvt.network.model.NetworkWeather
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitNetworkApi {

    @GET(value = "weather")
    suspend fun getCurrentWeather(
        @Query("lat") lat: String,
        @Query("lon") lng: String
    ): NetworkWeather


    @GET(value = "forecast")
    suspend fun getForecast(
        @Query("lat") lat: String,
        @Query("lon") lng: String,
        @Query("cnt") days:Int = 5,
    ): NetworkResponse<List<NetworkFiveDay>>
}