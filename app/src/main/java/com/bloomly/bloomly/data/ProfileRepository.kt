package com.bloomly.bloomly.data

import androidx.compose.runtime.remember
import com.bloomly.bloomly.data.Profile
import javax.inject.Inject

interface ProfileRepository{
    suspend fun getProfile(): Profile
    fun getCachedProfile(): Profile
}

class FakeProfileRepository @Inject constructor()
: ProfileRepository
{
    private val data = Profile(
        id = 1,
        username = "John Doe",
        email = "John0011@email.com",
        phone = "081234567890",
        address = "Jl. Boulevard Diponegoro No.1100, Klp. Dua, Kecamatan Kelapa Dua, Kabupaten Tangerang, Banten 15811"
    )

    var cached: Profile? = null
    override suspend fun getProfile(): Profile {
        cached = data
        return data
    }

    override fun getCachedProfile(): Profile {
        return cached ?: Profile()
    }
}