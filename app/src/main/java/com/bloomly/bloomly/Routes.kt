package com.bloomly.bloomly

sealed class Routes(val route:String) {
    data object Home : Routes("home")
    data object Login : Routes("login")
    data object Profile : Routes("profile")
    data object Category : Routes("category") // Catalog
    data object Buket : Routes("category/buket")
    data object Hamper : Routes("category/hamper")
    data object Uang : Routes("category/uang")

    data object Search : Routes("search")

    data object Pesanan : Routes("pesanan")
}