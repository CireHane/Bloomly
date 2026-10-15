package com.bloomly.bloomly

import android.content.res.Resources
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.bloomly.bloomly.Routes
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
                HomeScreen({ it })
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
            composable(Routes.Profile.route){ ProfileRoute(
                onLoggedOut = {
                    navController.navigate(Routes.Login.route) {
                        launchSingleTop = true
                    }
                }
            ) }
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
                        selected = currentRoute == item.route,
                        alwaysShowLabel = true,
                        onClick = {
                            navController.navigate(item.route){
                                launchSingleTop = true
                            }
                        },
                        icon = { Icon(
                            imageVector = item.icon,
                            contentDescription = null
                        )},
                        label = {Text(item.label)}
                    )
                }
            }
        }
    )
}