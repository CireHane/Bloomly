package com.bloomly.bloomly

import android.media.Image

data class NavItem(
    val label: String,
    val route: String,
    val icon: Int
)

val NavItems = listOf<NavItem>(
    NavItem(
        "Home",
        Routes.Home.route,
        R.drawable.home_64dp
    ),
    NavItem(
        "Login",
        Routes.Login.route,
        R.drawable.home_64dp
    )

)