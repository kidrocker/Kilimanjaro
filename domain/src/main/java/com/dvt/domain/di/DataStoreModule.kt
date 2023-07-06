package com.dvt.domain.di

import android.content.Context
import com.dvt.domain.datastore.AndroidKeyValueStore
import com.dvt.domain.datastore.KeyValueStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    @Provides
    @Singleton
    fun bindKeyValueStore(
        @ApplicationContext app:Context
    ): KeyValueStore {
        return AndroidKeyValueStore(app)
    }
}