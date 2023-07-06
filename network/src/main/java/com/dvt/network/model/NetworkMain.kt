package com.dvt.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkMain(
    val temp: Double,

    @SerialName("feels_like")
    val feelsLike: Double,

    @SerialName("temp_min")
    val tempMin: Double,

    @SerialName("temp_max")
    val tempMax: Double,
    val pressure: Int,
    val humidity: Int
)