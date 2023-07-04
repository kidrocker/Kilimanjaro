package com.dvt.network.model

import kotlinx.serialization.Serializable

@Serializable
data class NetworkWeather(
    val base: String,
    val main: Main,
    val visibility: Int,
    val dt: Int,
    val timezone: Int,
    val id: Int,
    val name: String,
    val cod: Int
)

@Serializable
data class Main(
    val temp: Double,
    val feelsLike: Double,
    val tempMin: Double,
    val tempMax: Double,
    val pressure: Int,
    val humidity: Int

)
