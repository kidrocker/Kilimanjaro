package com.dvt.kilimanjaro.di

import android.content.Context
import com.dvt.kilimanjaro.KilimanjaroApp
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideApp(@ApplicationContext app:Context):KilimanjaroApp = app as KilimanjaroApp

    @Singleton
    @Provides
    fun provideContext(app:KilimanjaroApp):Context = app.applicationContext

//    @Singleton
//    @Provides
//    fun provideNavigator():DestinationsNavigator = DestinationsNavigator()
}