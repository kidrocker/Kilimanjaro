package com.dvt.kilimanjaro.ui.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dvt.domain.model.Favorite
import com.dvt.domain.useCase.GetFavoritesUseCase
import com.dvt.domain.useCase.SetFavoriteUseCase
import com.dvt.kilimanjaro.ui.destinations.HomeScreenDestination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    getFavoritesUseCase: GetFavoritesUseCase,
    private val setFavoriteUseCase: SetFavoriteUseCase,
) : ViewModel() {

    fun setNewFavorite(value: Favorite, navigator:DestinationsNavigator) {
        viewModelScope.launch {
            setFavoriteUseCase {
                copy(
                    value.id,
                    value.name,
                    value.lat,
                    value.lng
                )
            }
        }
        navigator.navigate(
            HomeScreenDestination()
        )
    }

    val uiState: StateFlow<UIState> = getFavoritesUseCase()
        .map(UIState::FavoriteData)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = UIState.Empty
        )

    sealed interface UIState {
        object Empty : UIState
        data class FavoriteData(
            val favorites: List<Favorite>
        ) : UIState
    }

}