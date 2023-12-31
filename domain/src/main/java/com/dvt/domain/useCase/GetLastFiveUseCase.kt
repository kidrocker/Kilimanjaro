package com.dvt.domain.useCase

import com.dvt.domain.model.Day
import com.dvt.domain.repository.weather.WeatherRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLastFiveUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository
) {

    operator fun invoke(lat: String, lng: String): Flow<List<Day>> =
        weatherRepository.getLastFiveDays(lat, lng)
}