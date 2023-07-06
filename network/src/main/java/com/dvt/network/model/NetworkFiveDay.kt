package com.dvt.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkFiveDay(
    val main: NetworkMain,

    @SerialName("dt_txt")
    val dt:String,
    val weather:List<Weather>
)
