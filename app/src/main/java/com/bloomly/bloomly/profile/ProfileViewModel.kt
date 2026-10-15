package com.bloomly.bloomly.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bloomly.bloomly.data.Profile
import com.bloomly.bloomly.data.ProfileRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val profileRepository: ProfileRepository
): ViewModel() {

    private val _uiState = MutableStateFlow(ProfileUiState(isLoading = true, currentProfile = Profile()))
    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()

    init{
        refresh()
    }

    fun refresh(){
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, errorMessage = null) }

            runCatching { profileRepository.getProfile() }
                .onSuccess { profile ->
                    _uiState.update { it.copy(isLoading = false, currentProfile = profile) }
                }
                .onFailure { error ->
                    _uiState.update { it.copy(isLoading = false, errorMessage = error.message) }
                }
        }
    }
}