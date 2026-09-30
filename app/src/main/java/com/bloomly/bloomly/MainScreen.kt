package com.bloomly.bloomly

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.bloomly.bloomly.Routes

@Preview
@Composable
fun MainScreen(){
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = { BottomBar(currentRoute, navController) },
        modifier = Modifier.fillMaxSize()
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = Routes.Home.route,
            modifier = Modifier.padding(padding)
        ){
            composable(Routes.Home.route) {
                HomeScreen({ it })
            }
            composable(Routes.Login.route) {
                LoginScreen(onSubmit = {
                    navController.navigate(Routes.Home.route){
                        launchSingleTop = true
                    }
                })
            }
        }
    }
}

@Composable
fun BottomBar(currentRoute: String?, navController: NavController){

    AnimatedVisibility(
        visible = true,
//        visible = currentRoute != Routes.Login.route,
        content = {
            NavigationBar {
                NavItems.forEach { item -> //https://developer.android.com/guide/navigation/backstack#pop-actions
                    NavigationBarItem(
                        selected = currentRoute == item.route,
                        onClick = {
                            navController.navigate(item.route){
                                launchSingleTop = true
                            }
                        },
                        icon = { Icon(
                            imageVector = item.icon,
                            contentDescription = null )
                               },
                        label = {Text(item.label)}
                    )
                }
            }
        }
    )
}