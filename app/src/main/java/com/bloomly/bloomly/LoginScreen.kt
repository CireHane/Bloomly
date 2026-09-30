package com.bloomly.bloomly

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicSecureTextField
import androidx.compose.foundation.text.input.TextObfuscationMode
import androidx.compose.foundation.text.input.delete
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen(onSubmit: () -> Unit){
    val username = rememberTextFieldState()
    val password = rememberTextFieldState()
    val showPassword = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Username")
        OutlinedTextField(
            state = username,
            placeholder = { Text("username")}
        )
        Spacer(Modifier.height(16.dp))
        Text("Password")
        BasicSecureTextField(
            state = password,
            textObfuscationMode =
                if(showPassword.value)
                    TextObfuscationMode.Visible
                else
                    TextObfuscationMode.Hidden,
            decorator = { innerTextField ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.7f)
                        .requiredHeight(52.dp)
                        .border(
                            width = 1.dp,
                            brush = SolidColor(Color.Black),
                            shape = RoundedCornerShape(4.dp)
                        )
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.85f)
                            .align(Alignment.CenterStart)
                            .padding(16.dp)
                    ) {
                        innerTextField()
                    }
                    Icon(
                        imageVector =
                            if(showPassword.value)
                                Icons.Filled.VisibilityOff
                            else
                                Icons.Filled.Visibility,
                        contentDescription = null,
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .padding(end = 16.dp)
                            .clickable(onClick = { showPassword.value = !showPassword.value })
                    )
                }
            }
        )
        Spacer(Modifier.height(16.dp))
        Button(
            onClick = {
                onSubmit()
                username.edit { delete(0,username.text.length) }
                password.edit { delete(0,password.text.length) }
                showPassword.value = false
            },
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(0.8f),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text("Login")
        }
    }
}