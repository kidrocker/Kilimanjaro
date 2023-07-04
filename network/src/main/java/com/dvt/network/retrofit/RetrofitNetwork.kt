package com.dvt.network.retrofit

import com.dvt.network.BuildConfig
import com.dvt.network.NetworkDataSource
import com.dvt.network.model.NetworkWeather
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.Call
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton


private const val NetworkBaseUrl = BuildConfig.API_URL

@Singleton
class RetrofitNetwork @Inject constructor(
    networkJson: Json,
    okhttpCallFactory: Call.Factory
) : NetworkDataSource {

    private val networkApi = Retrofit.Builder()
        .baseUrl(NetworkBaseUrl)
        .callFactory(okhttpCallFactory)
        .addConverterFactory(
            networkJson.asConverterFactory("application/json".toMediaType()),
        )
        .build()
        .create(RetrofitNetworkApi::class.java)


    override suspend fun getCurrentWeather(lat: String, lng: String): NetworkWeather =
        networkApi.getCurrentWeather(lat, lng).data


    override suspend fun getLastFiveDays(lat: String, lng: String): List<NetworkWeather> =
        networkApi.getForecast(lat, lng).data
}