package com.rivibi.venoe.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rivibi.venoe.core.domain.entity.Event
import com.rivibi.venoe.core.domain.usecase.EventUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val eventUseCase: EventUseCase
) : ViewModel() {

    private val _uiState: MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> get() = _uiState

    init {
        loadEvents()
    }

    private fun loadEvents() {
        viewModelScope.launch {
            val upcomingEvents = eventUseCase.getUpcomingEvents()
            val ongoingEvents = eventUseCase.getOngoingEvents()
            val pastEvents = eventUseCase.getPastEvents()

            combine(
                upcomingEvents,
                ongoingEvents,
                pastEvents,
            ) { upcoming, ongoing, past ->
                HomeUiState(
                    upcoming.data ?: emptyList(),
                    ongoing.data ?: emptyList(),
                    past.data ?: emptyList()
                )
            }.collect {
                _uiState.value = it
            }
        }
    }
}

data class HomeUiState(
    val upcomingEvents: List<Event> = emptyList(),
    val ongoingEvents: List<Event> = emptyList(),
    val pastEvents: List<Event> = emptyList(),
)