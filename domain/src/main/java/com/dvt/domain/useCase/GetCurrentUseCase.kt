package com.dvt.domain.useCase

import com.dvt.domain.model.Weather
import com.dvt.domain.repository.weather.WeatherRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCurrentUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository
) {
    operator fun invoke(lat: String, lng: String): Flow<Weather?> =
        weatherRepository.getCurrentWeather(lat, lng)

}