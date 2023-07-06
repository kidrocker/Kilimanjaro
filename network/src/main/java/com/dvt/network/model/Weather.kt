package com.dvt.network.model

import kotlinx.serialization.Serializable

@Serializable
data class Weather(
    val main: String
)