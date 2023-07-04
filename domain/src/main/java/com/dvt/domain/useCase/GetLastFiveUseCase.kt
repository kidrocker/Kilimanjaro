package com.dvt.domain.useCase

import com.dvt.domain.model.Weather
import com.dvt.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLastFiveUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository
) {

    operator fun invoke(lat: String, lng: String): Flow<List<Weather>> =
        weatherRepository.getLastFiveDays(lat, lng)
}