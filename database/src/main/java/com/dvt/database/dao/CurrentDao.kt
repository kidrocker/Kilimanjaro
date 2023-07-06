package com.dvt.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dvt.database.entity.CurrentEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CurrentDao {

    @Query(value = """SELECT * FROM current_weather WHERE lat IN (:lat) AND lng IN (:lng) LIMIT 1""")
    fun getCurrent(lat:String, lng:String): Flow<CurrentEntity?>

    @Query(value = """DELETE FROM current_weather WHERE lat IN (:lat) AND lng IN (:lng)""")
    suspend fun deleteCurrentLocation(lat: String, lng: String)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCurrent(entity: CurrentEntity)


}