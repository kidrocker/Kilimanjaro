package com.dvt.domain.repository.sync

interface DataSyncRepository {
    suspend fun syncHomeData(lat: String, lng: String)
}