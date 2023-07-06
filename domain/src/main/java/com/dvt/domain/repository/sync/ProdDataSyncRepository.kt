package com.dvt.domain.repository.sync

import com.dvt.database.dao.CurrentDao
import com.dvt.database.dao.FiveDayDao
import com.dvt.database.entity.CurrentEntity
import com.dvt.database.entity.FiveDayEntity
import com.dvt.network.NetworkDataSource
import kotlinx.datetime.Clock
import javax.inject.Inject

class ProdDataSyncRepository @Inject constructor(
    private val fiveDayDao: FiveDayDao,
    private val currentDao: CurrentDao,
    private val network: NetworkDataSource
) : DataSyncRepository {
    override suspend fun syncHomeData(lat: String, lng: String) {
        getCurrentWeatherFromApi(lat, lng)
        getLastFiveFromApi(lat, lng)
    }

    private suspend fun getLastFiveFromApi(lat: String, lng: String) {
        val response = network.getLastFiveDays(lat, lng).map { fiveDay ->
            FiveDayEntity(
                degrees = fiveDay.main.temp,
                weather = fiveDay.weather[0].main,
                lat = lat,
                lng = lng,
                day = fiveDay.dt
            )
        }
        fiveDayDao.deleteCurrentLocation(lat, lng)
        fiveDayDao.insertFiveDay(response)
    }

    private suspend fun getCurrentWeatherFromApi(lat: String, lng: String) {
        val response = network.getCurrentWeather(lat, lng)
        val entity = CurrentEntity(
            id = response.id.toString(),
            minTemp = response.main.tempMin,
            maxTemp = response.main.tempMax,
            current = response.main.temp,
            lat = lat,
            lng = lng,
            lastUpdated = Clock.System.now(),
            weather = response.weather[0].main
        )

        currentDao.deleteCurrentLocation(lat, lng)
        currentDao.insertCurrent(entity)
    }
}