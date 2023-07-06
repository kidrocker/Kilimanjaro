package com.dvt.domain.model

data class Weather(
    val min: String,
    val current: String,
    val max: String,
    val main: String,
    val lastUpdated: String
)
