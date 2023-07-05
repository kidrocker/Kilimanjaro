package com.dvt.kilimanjaro.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dvt.domain.model.Weather
import com.dvt.domain.useCase.GetLastFiveUseCase
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    lastFiveUseCase: GetLastFiveUseCase
) : ViewModel() {

    val uiState: StateFlow<UIState> =
        lastFiveUseCase("", "").map(
            UIState::WeatherData,
        ).stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = UIState.Loading
        )
}
    sealed interface UIState {
        object Loading : UIState
        data class WeatherData(
            val lastFive: List<Weather>
        ) : UIState

        object Empty:UIState
    }
