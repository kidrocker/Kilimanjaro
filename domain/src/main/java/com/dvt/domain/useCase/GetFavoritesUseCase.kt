package com.dvt.domain.useCase

import com.dvt.domain.model.Favorite
import com.dvt.domain.repository.favorite.FavoritesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFavoritesUseCase @Inject constructor(
    private val getFavoritesRepository: FavoritesRepository
) {
     operator fun invoke(): Flow<List<Favorite>> =
        getFavoritesRepository.getFavorites()
}