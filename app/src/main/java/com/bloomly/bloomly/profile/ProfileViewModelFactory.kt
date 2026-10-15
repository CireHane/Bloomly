package com.bloomly.bloomly.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bloomly.bloomly.data.ProfileRepository

class ProfileViewModelFactory(
    val repository: ProfileRepository
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProfileViewModel(repository) as T
    }
}