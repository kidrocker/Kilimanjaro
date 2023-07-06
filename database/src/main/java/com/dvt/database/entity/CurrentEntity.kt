package com.dvt.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.datetime.Instant


@Entity(
    tableName = "current_weather"
)
data class CurrentEntity(
    @PrimaryKey
    val id: String,
    val current: Double,
    val minTemp: Double,
    val maxTemp: Double,
    val weather: String,
    val lat: String,
    val lng: String,
    @ColumnInfo(name = "last_updated")
    val lastUpdated: Instant
)