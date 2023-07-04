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
    val temp: Double? = null,
    val feelsLike: Double? = null,
    val tempMin: Double? = null,
    val tempMax: Double? = null,
    val pressure: Int? = null,
    val humidity: Int? = null

)
