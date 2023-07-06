package com.dvt.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dvt.database.dao.CurrentDao
import com.dvt.database.dao.FiveDayDao
import com.dvt.database.entity.CurrentEntity
import com.dvt.database.entity.FiveDayEntity
import com.dvt.database.util.InstantConverter

@Database(
    entities = [
        FiveDayEntity::class,
        CurrentEntity::class
    ],
    version = 1,
    exportSchema = true
)
@TypeConverters(InstantConverter::class)
abstract class KilimanjaroDatabase : RoomDatabase() {
    abstract fun fiveDayDao(): FiveDayDao
    abstract fun currentDao():CurrentDao
}