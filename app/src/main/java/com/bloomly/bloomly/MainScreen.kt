package com.bloomly.bloomly

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.bloomly.bloomly.home.HomeRoute
import com.bloomly.bloomly.home.HomeScreen
import com.bloomly.bloomly.profile.ProfileRoute
import kotlinx.coroutines.launch

@Preview
@Composable
fun MainScreen(){
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        bottomBar = { BottomBar(currentRoute, navController) },
        snackbarHost = { SnackbarHost(snackbarHostState)  },
        modifier = Modifier
            .fillMaxSize()
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = Routes.Home.route,
            modifier = Modifier.padding(padding)
        ){
            composable(Routes.Home.route) {
                HomeRoute {  }
            }
            composable(Routes.Login.route) {
                LoginScreen(
                    onSubmit = { username, password ->
                        if(username != "" && password != ""){
                            navController.navigate(Routes.Home.route){
                                launchSingleTop = true
                            }
                        }
                        else{
                            scope.launch {
                                val res = snackbarHostState.showSnackbar(
                                    message = "Username and Password cannot be empty",
                                    actionLabel = "Close"
                                )
                                when (res){
                                    SnackbarResult.ActionPerformed -> {
                                        snackbarHostState.currentSnackbarData?.dismiss()
                                    }
                                    SnackbarResult.Dismissed -> {
                                        snackbarHostState.currentSnackbarData?.dismiss()
                                    }
                                }
                            }
                        }
                    }
                )
            }
            composable(Routes.Profile.route){
                ProfileRoute(
                    onLoggedOut = {
                        navController.navigate(Routes.Login.route) {
                            launchSingleTop = true
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun BottomBar(currentRoute: String?, navController: NavController){

    AnimatedVisibility(
//        visible = true,
        visible = currentRoute != Routes.Login.route,
        content = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.primary
            ){
                NavItems.forEach { item -> //https://developer.android.com/guide/navigation/backstack#pop-actions
                    NavigationBarItem(
                        selected = false,
                        alwaysShowLabel = true,
                        onClick = {
                            navController.navigate(item.route){
                                launchSingleTop = true
                            }
                        },
                        icon = { Icon(
                            painter =
                                if(currentRoute == item.route){
                                    painterResource(item.iconFilled)
                                }
                                else{
                                    painterResource(item.icon)
                                },
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.tertiary
                        )},
                        label = {Text(
                            text = item.label,
                            fontWeight =
                                if(currentRoute == item.route){
                                    FontWeight.Bold
                                }
                                else{
                                    FontWeight.Normal
                                }
                            )
                        }
                    )
                }
            }
        }
    )
}