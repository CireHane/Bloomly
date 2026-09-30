package com.bloomly.bloomly

sealed class Routes(val route:String) {
    data object Home : Routes("home")
    data object Login : Routes("login")

}