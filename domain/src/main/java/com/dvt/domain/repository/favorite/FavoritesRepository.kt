package com.dvt.domain.repository.favorite

import com.dvt.domain.model.Favorite
import kotlinx.coroutines.flow.Flow

interface FavoritesRepository {
    fun getFavorites(): Flow<List<Favorite>>

    suspend fun saveFavorite(favorite: Favorite)
}