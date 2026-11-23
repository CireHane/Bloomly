package com.bloomly.bloomly.profile

import com.bloomly.bloomly.data.Profile

data class ProfileUiState(
    val isLoading: Boolean,
    val currentProfile: Profile,
    val errorMessage: String? = null
) {
    val username: String get() = currentProfile.username
    val email: String get() = currentProfile.email
    val phone: String get() = currentProfile.phone
    val address: String get() = currentProfile.address

    val isLoggedOut: Boolean get() = !isLoading and (currentProfile.id == -1)
}