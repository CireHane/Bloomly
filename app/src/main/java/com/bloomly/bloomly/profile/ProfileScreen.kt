package com.bloomly.bloomly.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.bloomly.bloomly.data.Profile

@Composable
fun ProfileScreen(
    uiState: ProfileUiState,
    onLoggedOut : () -> Unit
){
    Scaffold(
        modifier = Modifier
            .padding(16.dp,0.dp),
        topBar = {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 0.dp)
                    .background(MaterialTheme.colorScheme.background),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text("Profile Saya")
                Icon(
                    imageVector = Icons.Filled.Settings,
                    contentDescription = "Settings",
                    modifier = Modifier
                        .padding(2.dp)
                        .border(0.dp, SolidColor(Color(1, 1, 1, 0)), RoundedCornerShape(100))
                        .clickable(onClick = { })
                )
            }
        }
    ) { padding ->
        Column(
            Modifier
                .fillMaxWidth()
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when{
                uiState.isLoading -> LoadingScreen()
                uiState.isLoggedOut -> onLoggedOut()
                else -> MainScreen(uiState)
//                else -> onLoggedOut()
            }
        }
    }
}

@Composable
fun LoadingScreen(){
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}

@Composable
fun MainScreen(
    uiState: ProfileUiState
){
    Spacer(Modifier.height(32.dp))
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary, RoundedCornerShape(24.dp))
            .padding(0.dp,18.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector        = Icons.Filled.AccountCircle,
            contentDescription = null,
            modifier           = Modifier.size(100.dp),
        )
        Spacer(Modifier.height(12.dp))
        Text(
            uiState.username,
            fontSize = 10.em,
            fontWeight = FontWeight.Bold
        )
        Text(uiState.email)
        Text(uiState.noTelp)
    }
}