package com.dvt.kilimanjaro.ui.home

import com.dvt.kilimanjaro.ui.destinations.Destination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class HomeViewModel(
    navigator: Destination
) {

   // val uiState:StateFlow<UIState> =

    sealed interface UIState{
        object Loading:UIState
        data class Current(
            val min:String,
            val current:String,
            val max:String,

        )
    }
}