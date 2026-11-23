package com.bloomly.bloomly.profile

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bloomly.bloomly.MainApplication

@Composable
fun ProfileRoute( onBack : () -> Unit , onLoggedOut : () -> Unit, onClickEdit : () -> Unit) {
    val viewModel: ProfileViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    ProfileScreen(
        onBack = onBack,
        onLoggedOut = onLoggedOut,
        onClickEdit = onClickEdit,
        uiState = uiState
    )
}