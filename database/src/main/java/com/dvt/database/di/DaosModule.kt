package com.dvt.database.di

import com.dvt.database.KilimanjaroDatabase
import com.dvt.database.dao.CurrentDao
import com.dvt.database.dao.FiveDayDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DaosModule {
    @Provides
    fun provideFiveDayDao(
        database: KilimanjaroDatabase
    ): FiveDayDao = database.fiveDayDao()


    @Provides
    fun provideCurrentDao(
        database: KilimanjaroDatabase
    ): CurrentDao = database.currentDao()
}