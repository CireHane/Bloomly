package com.bloomly.bloomly.data

import androidx.compose.runtime.remember
import com.bloomly.bloomly.R
import com.bloomly.bloomly.data.Profile
import kotlinx.coroutines.delay
import javax.inject.Inject

interface HomeRepository{
    suspend fun getPopular(): List<Item>
    fun getCachedPopular(): List<Item>
}

class FakeHomeRepository @Inject constructor()
: HomeRepository
{
    private val data = listOf<Item>(
        Item(
            id = 0,
            image = R.drawable.placeholder_400,
            name = "Item 1",
            price = 200000
        ),
        Item(
            id = 0,
            image = R.drawable.placeholder_400,
            name = "Item 2",
            price = 50000
        ),
        Item(
            id = 0,
            image = R.drawable.placeholder_400,
            name = "Item 3",
            price = 1000000
        ),
        Item(
            id = 0,
            image = R.drawable.placeholder_400,
            name = "Item 4",
            price = 10000
        ),
        Item(
            id = 0,
            image = R.drawable.placeholder_400,
            name = "Item 5",
            price = 175427
        )

    )

    var cached: List<Item>? = null
    override suspend fun getPopular(): List<Item> {
        delay(15_000)
        cached = data
        return data
    }

    override fun getCachedPopular(): List<Item> {
        return cached ?: listOf()
    }
}