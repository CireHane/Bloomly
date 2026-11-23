package com.bloomly.bloomly.category.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bloomly.bloomly.data.HomeRepository
import com.bloomly.bloomly.data.Profile
import com.bloomly.bloomly.data.ProfileRepository
import com.bloomly.bloomly.home.HomeUiState
import com.bloomly.bloomly.profile.ProfileUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategorySearchViewModel @Inject constructor(
    private val repository: HomeRepository
): ViewModel() {

    private val _uiState = MutableStateFlow(
        CategorySearchUiState(
            isLoading = true,
            items = listOf()
        )
    )
    val uiState: StateFlow<CategorySearchUiState> = _uiState.asStateFlow()

    init{
        refresh()
    }

    fun refresh(){
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, errorMessage = null) }

            runCatching { repository.getPopular() }
                .onSuccess { items ->
                    _uiState.update { it.copy(isLoading = false, items = items) }
                }
                .onFailure { error ->
                    _uiState.update { it.copy(isLoading = false, errorMessage = error.message) }
                }
        }
    }
}