package com.dvt.domain.repository

import com.dvt.domain.model.Favorite
import kotlinx.coroutines.flow.Flow

interface DataStoreRepository {
    val favorite: Flow<Favorite>
    suspend fun saveFavorite(featureStore: Favorite)
}