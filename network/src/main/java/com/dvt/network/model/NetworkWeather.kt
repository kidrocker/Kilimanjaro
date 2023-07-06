package com.dvt.network.model

import kotlinx.serialization.Serializable

@Serializable
data class NetworkWeather(
    val main: NetworkMain,
    val id: Int,
//    @SerialName("dt_txt")
//    val dt: String,
    val weather: List<Weather>
)



