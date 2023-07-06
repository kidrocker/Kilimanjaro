package com.dvt.domain.repository.weather

import com.dvt.database.dao.CurrentDao
import com.dvt.database.dao.FiveDayDao
import com.dvt.domain.model.Day

import com.dvt.domain.model.Weather
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import java.text.SimpleDateFormat
import java.util.Locale
import javax.inject.Inject

class ProdWeatherRepository @Inject constructor(
    private val fiveDayDao: FiveDayDao,
    private val currentDao: CurrentDao
) : WeatherRepository {
    override fun getCurrentWeather(lat: String, lng: String): Flow<Weather?> =
        currentDao.getCurrent(lat, lng).map {
            it?.let {
                Weather(
                    min = it.minTemp.toString(),
                    max = it.maxTemp.toString(),
                    current = it.current.toString(),
                    main = it.weather,
                    lastUpdated = it.lastUpdated.toLocalDateTime(TimeZone.currentSystemDefault()).toString()
                )
            }
        }

    override fun getLastFiveDays(lat: String, lng: String): Flow<List<Day>> =
        fiveDayDao.getLastFiveDays(lat, lng)
            .map { entities ->
                entities.map {
                    Day(
                        day = parseLocalDate(it.day),
                        weather = it.weather,
                        degrees = it.degrees.toString()
                    )
                }
            }

    private fun parseLocalDate(date: String): String {
        val formatFrom = SimpleDateFormat("yyyy-mm-dd HH:mm:ss", Locale.getDefault())
        val date = formatFrom.parse(date)
        val formatTo = SimpleDateFormat("EEEE", Locale.getDefault())
        return formatTo.format(date)
    }
}