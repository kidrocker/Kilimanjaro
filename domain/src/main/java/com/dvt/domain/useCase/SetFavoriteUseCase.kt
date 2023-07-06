package com.dvt.domain.useCase

import com.dvt.domain.model.Favorite
import com.dvt.domain.repository.DataStoreRepository
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class SetFavoriteUseCase @Inject constructor(
    private val dataStoreRepository: DataStoreRepository,
    private val getSavedFavoriteUseCase: GetSavedFavoriteUseCase
) {

    suspend operator fun invoke(applyNewFavorite: Favorite.() -> Favorite) {
        val current = getSavedFavoriteUseCase().first()
        val newFavorite = current.applyNewFavorite()

        dataStoreRepository.saveFavorite(newFavorite)
    }

}