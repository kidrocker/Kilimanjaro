package com.dvt.network.retrofit

import com.dvt.network.BuildConfig
import com.dvt.network.NetworkDataSource
import com.dvt.network.model.NetworkFiveDay
import com.dvt.network.model.NetworkWeather
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.Call
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class RetrofitNetwork @Inject constructor(
    networkJson: Json,
    okhttpCallFactory: Call.Factory
) : NetworkDataSource {

    private val networkApi = Retrofit.Builder()
        .baseUrl(BuildConfig.API_URL)
        .callFactory(okhttpCallFactory)
        .client(
            OkHttpClient.Builder()
                .addInterceptor { chain ->
                    val url = chain
                        .request()
                        .url
                        .newBuilder()
                        .addQueryParameter("appid", BuildConfig.APP_ID)
                        .addQueryParameter("units", "metric")
                        .build()
                    chain.proceed(chain.request().newBuilder().url(url).build())
                }
                .build()
        )
        .addConverterFactory(
            networkJson.asConverterFactory("application/json".toMediaType()),
        )
        .build()
        .create(RetrofitNetworkApi::class.java)


    override suspend fun getCurrentWeather(lat: String, lng: String): NetworkWeather =
        networkApi.getCurrentWeather(lat, lng)


    override suspend fun getLastFiveDays(lat: String, lng: String): List<NetworkFiveDay> =
        networkApi.getForecast(lat, lng).list
}