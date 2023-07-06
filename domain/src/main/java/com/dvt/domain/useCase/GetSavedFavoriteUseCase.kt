package com.dvt.domain.useCase

import com.dvt.domain.model.Favorite
import com.dvt.domain.repository.DataStoreRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSavedFavoriteUseCase @Inject constructor(
    private val dataStoreRepository: DataStoreRepository
) {
    operator fun invoke(): Flow<Favorite> = dataStoreRepository.favorite
}