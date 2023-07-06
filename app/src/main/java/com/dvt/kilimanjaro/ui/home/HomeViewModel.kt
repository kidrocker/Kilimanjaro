package com.dvt.kilimanjaro.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dvt.domain.model.Day
import com.dvt.domain.model.Favorite
import com.dvt.domain.model.Weather
import com.dvt.domain.useCase.GetCurrentUseCase
import com.dvt.domain.useCase.GetLastFiveUseCase
import com.dvt.domain.useCase.GetSavedFavoriteUseCase
import com.dvt.domain.useCase.SyncDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    lastFiveUseCase: GetLastFiveUseCase,
    getCurrentUseCase: GetCurrentUseCase,
    syncDataUseCase: SyncDataUseCase,
    private val getSavedFavoriteUseCase: GetSavedFavoriteUseCase
) : ViewModel() {
    private var favorite: Favorite

    init {
        runBlocking {
            favorite = getSavedFavoriteUseCase().first()
        }
        viewModelScope.launch {
            syncDataUseCase(favorite.lat, favorite.lng)
        }
    }

    private fun homeUIState(
        getCurrentUseCase: GetCurrentUseCase,
        lastFiveUseCase: GetLastFiveUseCase
    ): Flow<UIState> {
        val lastFive: Flow<List<Day>> = lastFiveUseCase(favorite.lat, favorite.lng)
        val current: Flow<Weather?> = getCurrentUseCase(favorite.lat, favorite.lng)

        return current.combine(
            lastFive,
        ) { cur, last ->
            UIState.WeatherData(
                current = cur,
                lastFive = last,
                favorite = favorite
            )
        }
    }

    val uiState: StateFlow<UIState> = homeUIState(getCurrentUseCase, lastFiveUseCase)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = UIState.Loading
        )
}


sealed interface UIState {
    object Loading : UIState
    data class WeatherData(
        val lastFive: List<Day>,
        val current: Weather?,
        val favorite: Favorite
    ) : UIState
}
