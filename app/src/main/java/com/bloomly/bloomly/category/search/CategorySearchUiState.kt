package com.bloomly.bloomly.category.search

import com.bloomly.bloomly.data.Item

data class CategorySearchUiState (
    val isLoading : Boolean = false,
    val items : List<Item>,
    val errorMessage : String? = null
) {
}