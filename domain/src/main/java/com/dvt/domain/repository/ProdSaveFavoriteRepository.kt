package com.dvt.domain.repository

import com.dvt.domain.datastore.Key
import com.dvt.domain.datastore.KeyValueStore
import com.dvt.domain.model.Favorite
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.distinctUntilChanged
import javax.inject.Inject

class ProdSaveFavoriteRepository @Inject constructor(
    private val keyValueStore: KeyValueStore
) : DataStoreRepository {
    override val favorite: Flow<Favorite>
        get() = combine(
            keyValueStore.load(ID),
            keyValueStore.load(NAME),
            keyValueStore.load(LAT),
            keyValueStore.load(LNG),
        ) { combineArray ->
            Favorite(
                id = (combineArray[0] ?: 0) as Int,
                name = (combineArray[1] ?: "") as String,
                lat = (combineArray[2] ?: "") as String,
                lng = (combineArray[3] ?: "") as String,

                )
        }.distinctUntilChanged()

    override suspend fun saveFavorite(featureStore: Favorite) {
        keyValueStore.store(NAME, featureStore.name)
        keyValueStore.store(LAT, featureStore.lat)
        keyValueStore.store(LNG, featureStore.lng)
        keyValueStore.store(ID, featureStore.id)
    }

    companion object {
        private val NAME = Key.String("com.dvt.name")
        private val LAT = Key.String("com.dvt.lat")
        private val LNG = Key.String("com.dvt.lng")
        private val ID = Key.Int("com.dvt.id")
    }
}