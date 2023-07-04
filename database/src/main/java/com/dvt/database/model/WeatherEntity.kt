package com.dvt.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.datetime.Instant

@Entity(
    tableName = "weather"
)
data class WeatherEntity(
    @PrimaryKey
    val id: String,
    val min: Double,
    val current: Double,
    val max: Double,
    val lat:String,
    val lng:String,
    @ColumnInfo(name = "last_updated")
    val lastUpdated: Instant?
)

