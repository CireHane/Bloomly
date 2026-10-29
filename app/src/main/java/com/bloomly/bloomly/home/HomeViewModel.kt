package com.bloomly.bloomly.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bloomly.bloomly.data.HomeRepository
import com.bloomly.bloomly.data.Profile
import com.bloomly.bloomly.data.ProfileRepository
import com.bloomly.bloomly.profile.ProfileUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: HomeRepository
): ViewModel() {

    private val _uiState = MutableStateFlow(
        HomeUiState(
            isLoading = true,
            popularItems = listOf()
        )
    )
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init{
        refresh()
    }

    fun refresh(){
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, errorMessage = null) }

            runCatching { repository.getPopular() }
                .onSuccess { items ->
                    _uiState.update { it.copy(isLoading = false, popularItems = items) }
                }
                .onFailure { error ->
                    _uiState.update { it.copy(isLoading = false, errorMessage = error.message) }
                }
        }
    }
}