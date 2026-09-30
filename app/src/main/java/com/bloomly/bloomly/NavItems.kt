package com.bloomly.bloomly

import android.media.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Construction
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

data class NavItem(
    val label: String,
    val route: String,
    val icon: ImageVector
)

val NavItems = listOf<NavItem>(
    NavItem(
        "Home",
        Routes.Home.route,
        Icons.Filled.Home
    ),
    NavItem(
        "Login",
        Routes.Login.route,
        Icons.Filled.Construction
    )

)