package com.dvt.network

import kotlinx.serialization.Serializable

@Serializable
 data class NetworkResponse<T>(
    val data: T,
)