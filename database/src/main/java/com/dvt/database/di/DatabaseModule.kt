package com.dvt.database.di

import android.content.Context
import androidx.room.Room
import com.dvt.database.KilimanjaroDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideKilimanjaroDatabase(
        @ApplicationContext context:Context,
    ):KilimanjaroDatabase = Room.databaseBuilder(
        context,
        KilimanjaroDatabase::class.java,
        "kilimanjaro_db"
    ).build()
}