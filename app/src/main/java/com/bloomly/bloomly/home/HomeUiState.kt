package com.bloomly.bloomly.home

import com.bloomly.bloomly.data.Item

data class HomeUiState (
    val isLoading : Boolean = false,
    val popularItems : List<Item>,
    val errorMessage : String? = null
) {
}