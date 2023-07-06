package com.dvt.domain.repository.favorite

import com.dvt.domain.model.Favorite
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProdFavoriteRepository @Inject constructor() : FavoritesRepository {
    override fun getFavorites(): Flow<List<Favorite>> {

        return flow {
            emit(
                listOf(
                    Favorite(name = "Nairobi", lat = "-1.286389", lng = "36.817223", id = 1),
                    Favorite(name = "Cairo", lat = "30.04442", lng = "31.235712", id = 2),
                    Favorite(name = "Cape Town", lat = "-33.918861", lng = "18.423300", id = 3),
                    Favorite(name = "Harare", lat = "-17.824858", lng = "31.053028", id = 4),
                    Favorite(name = "Lagos", lat = "6.465422", lng = "3.406448", id = 5),
                    Favorite(name = "Casablanca", lat = "33.589886", lng = "-7.603869", id = 6),
                )
            )
        }
    }

    override suspend fun saveFavorite(favorite: Favorite) {
        TODO("Not yet implemented")
    }
}