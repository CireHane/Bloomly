package com.bloomly.bloomly.profile

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Logout
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.bloomly.bloomly.data.Profile
import com.bloomly.bloomly.ui.theme.LiberationSansFamily

@Composable
fun ProfileScreen(
    onBack : () -> Unit,
    onLoggedOut : () -> Unit,
    onClickEdit : () -> Unit,
    uiState: ProfileUiState
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
                Icon(
                    imageVector = Icons.Filled.ArrowBackIosNew,
                    contentDescription = null,
                    modifier = Modifier.clickable(onClick = onBack)
                )
                Text("Profile Saya")
                Spacer(Modifier)
            }
        }
    ) { padding ->
        Column(
            Modifier
                .fillMaxWidth()
                .padding(padding)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when{
                uiState.isLoading -> LoadingScreen()
                uiState.isLoggedOut -> onLoggedOut()
                else -> MainScreen(onClickEdit, uiState)
//                else -> onLoggedOut()
            }
        }
    }
}

@Composable
private fun LoadingScreen(){
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}

@Composable
private fun MainScreen(
    onClickEdit: () -> Unit,
    uiState: ProfileUiState
){
    Spacer(Modifier.height(32.dp))
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary, RoundedCornerShape(24.dp))
            .padding(18.dp,18.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Icon(
            imageVector        = Icons.Filled.AccountCircle,
            contentDescription = null,
            modifier           = Modifier
                .size(100.dp)
                .border(1.dp, color = MaterialTheme.colorScheme.tertiary, shape = CircleShape),
        )
        Spacer(Modifier.width(12.dp))
        Column(
           modifier = Modifier
               .padding(vertical = 6.dp)
        ) {
            Text(
                uiState.username,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = LiberationSansFamily
            )
            Text(
                text = uiState.email,
                fontSize = 14.sp,
                fontFamily = LiberationSansFamily,
                color = Color(0x65000000)
            )
            Spacer(Modifier.height(8.dp))
            Row(
                Modifier
                    .clip(RoundedCornerShape(50))
                    .background(MaterialTheme.colorScheme.secondary)
                    .padding(12.dp,4.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = Icons.Filled.CheckCircle,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.tertiary,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(Modifier.width(6.dp))
                Text(
                    "Member Bloomly",
                    fontSize = 13.sp,
                    fontFamily = LiberationSansFamily,
                    color = Color(0x45000000)
                )
            }
        }
    }
    Spacer(Modifier.height(20.dp))

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary, RoundedCornerShape(24.dp))
            .padding(12.dp,18.dp),
    ) {
        Row(
            Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Informasi Akun",
                fontSize = 18.sp,
                fontFamily = LiberationSansFamily,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.tertiary
            )

            Text(
                text = "Edit Informasi",
                fontSize = 13.sp,
                fontFamily = LiberationSansFamily,
                color = Color(0x65000000),
                modifier = Modifier.clickable(onClick = onClickEdit)
            )
        }

        InfoCard("Nama Lengkap", uiState.username, onClickEdit)
        InfoCard("Email", uiState.email, onClickEdit)
        InfoCard("Nomor Telelpon / Whatsapp", uiState.phone, onClickEdit)
        InfoCard("Alamat", uiState.address, onClickEdit, true)
    }
    Spacer(Modifier.height(20.dp))

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        settingCard(Icons.Filled.Home,text = "Daftar Alamat Tersimpan", "top")
        settingCard(Icons.Filled.List,text = "Daftar Alamat Tersimpan")
        settingCard(Icons.Filled.Logout, text = "Keluar Akun", "bottom", Color.Red)

    }
}

@Composable
private fun InfoCard(header: String, info: String, onClick: () -> Unit, isTextbox: Boolean = false){
    Column(
        Modifier.fillMaxWidth()
    ) {
        Text(
            text = header,
            fontSize = 13.sp,
            fontFamily = LiberationSansFamily,
            color = Color(0x65000000)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = info,
                fontSize = 18.sp,
                fontFamily = LiberationSansFamily,
                color = Color(0xFF000000)
            )
            if(!isTextbox){
                Icon(
                    imageVector = Icons.Filled.ArrowForwardIos,
                    contentDescription = null,
                    modifier = Modifier.clickable(onClick = onClick)
                )
            }
        }
    }
}

@Composable
private fun settingCard(icon: ImageVector, text: String, position:String? = null, color: Color? = null){
    val roundedTop =
        if(position != null && position=="top")
            18.dp
        else
            0.dp

    val roundedBottom =
        if(position != null && position=="bottom")
            18.dp
        else
            0.dp
    Row(
        Modifier
            .clickable(onClick = {})
            .fillMaxWidth()
            .background(
                MaterialTheme.colorScheme.primary,
                RoundedCornerShape(topStart = roundedTop, topEnd = roundedTop, bottomEnd = roundedBottom,bottomStart = roundedBottom)
            )
            .padding(18.dp, 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.secondary, RoundedCornerShape(25))
                    .padding(8.dp),
                tint =
                    if(color!=null)
                        color
                    else
                        MaterialTheme.colorScheme.tertiary

            )
            Spacer(Modifier.width(12.dp))
            Text(
                text = text,
                fontSize = 18.sp,
                fontFamily = LiberationSansFamily,
                color =
                    if(color!=null)
                        color
                    else
                        Color.Black
            )
        }

        Icon(
            imageVector = Icons.Filled.ArrowForwardIos,
            contentDescription = null
        )
    }
}