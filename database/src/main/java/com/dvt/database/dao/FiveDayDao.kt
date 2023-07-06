package com.dvt.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dvt.database.entity.FiveDayEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FiveDayDao {

    @Query(value = """SELECT * FROM five_day WHERE lat IN (:lat) AND lng IN (:lng)""")
    fun getLastFiveDays(lat: String, lng: String): Flow<List<FiveDayEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFiveDay(entities: List<FiveDayEntity>)

    @Query(value = """DELETE FROM five_day WHERE lat IN (:lat) AND lng IN (:lng) """)
    suspend fun deleteCurrentLocation(lat: String, lng: String)
}