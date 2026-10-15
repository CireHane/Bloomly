package com.bloomly.bloomly.di

import com.bloomly.bloomly.data.FakeProfileRepository
import com.bloomly.bloomly.data.ProfileRepository

interface AppContainer {
    val profileRepository: ProfileRepository
}

class DefaultContainer: AppContainer{
    override val profileRepository: ProfileRepository by lazy {
        FakeProfileRepository()
    }
}