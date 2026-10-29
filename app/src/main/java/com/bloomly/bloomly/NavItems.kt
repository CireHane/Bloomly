package com.bloomly.bloomly

import android.media.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Construction
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

data class NavItem(
    val label: String,
    val route: String,
    val icon: Int,
    val iconFilled: Int
)

val NavItems = listOf<NavItem>(
    NavItem(
        label      = "Home",
        route      = Routes.Home.route,
        icon       = R.drawable.icon_home_80,
        iconFilled = R.drawable.icon_home_filled_80

    ),
    NavItem(
        label      = "Kategeri",
        route      = "#",
        icon       = R.drawable.icon_kategory_80,
        iconFilled = R.drawable.icon_kategory_filled_80

    ),
    NavItem(
        label      = "Pesanan",
        route      = Routes.Login.route,
        icon       = R.drawable.icon_pesanan_80,
        iconFilled = R.drawable.icon_pesanan_filled_80
    ),
    NavItem(
        label      = "Profile",
        route      = Routes.Profile.route,
        icon       = R.drawable.icon_profile_80,
        iconFilled = R.drawable.icon_profile_filled_80
    )
)