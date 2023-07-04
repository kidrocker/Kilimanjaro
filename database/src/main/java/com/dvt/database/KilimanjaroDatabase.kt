package com.dvt.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dvt.database.dao.WeatherDao
import com.dvt.database.model.WeatherEntity
import com.dvt.database.util.InstantConverter

@Database(
    entities = [
        WeatherEntity::class
    ],
version =1,
exportSchema = true
)
@TypeConverters(InstantConverter::class)
abstract class KilimanjaroDatabase :RoomDatabase() {
    abstract fun weatherDao():WeatherDao
}