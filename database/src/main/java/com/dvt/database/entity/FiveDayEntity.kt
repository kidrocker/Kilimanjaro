package com.dvt.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "five_day"
)
data class FiveDayEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val degrees: Double,
    val day:String,
    val weather:String,
    val lat:String,
    val lng:String,
)
