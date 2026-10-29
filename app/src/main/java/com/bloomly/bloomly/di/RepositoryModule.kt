package com.bloomly.bloomly.di

import androidx.compose.ui.tooling.preview.Preview
import com.bloomly.bloomly.data.FakeHomeRepository
import com.bloomly.bloomly.data.FakeProfileRepository
import com.bloomly.bloomly.data.HomeRepository
import com.bloomly.bloomly.data.ProfileRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindProfileRepository(
        repo : FakeProfileRepository
    ) : ProfileRepository

    @Binds
    @Singleton
    abstract fun bindHomeRepository(
        repo : FakeHomeRepository
    ) : HomeRepository
}