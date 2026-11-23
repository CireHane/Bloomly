package com.bloomly.bloomly.category.search

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bloomly.bloomly.category.CategoryScreen
import com.bloomly.bloomly.home.HomeScreen
import com.bloomly.bloomly.home.HomeViewModel

@Composable
fun CategorySearchRoute(
    category: String,
    search: String ="",
    onBack: () -> Unit,
    onSearch: (String) -> Unit
) {

    val viewModel : CategorySearchViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    CatagorySearchScreen(
        uiState = uiState,
        category = category,
        search = search,
        onBack = onBack,
        onSearch = onSearch
    )
}