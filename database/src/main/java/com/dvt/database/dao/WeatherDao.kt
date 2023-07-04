package com.dvt.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dvt.database.model.WeatherEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherDao {

    @Query(value = """SELECT * FROM weather WHERE lat IN (:lat) AND lng IN (:lng)""")
    fun getLastFiveDays(lat: String, lng: String): Flow<List<WeatherEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeather(entities: List<WeatherEntity>)

    @Query(value = """DELETE FROM weather WHERE lat IN (:lat) AND lng IN (:lng) """)
    suspend fun deleteCurrentLocation(lat: String, lng: String)
}