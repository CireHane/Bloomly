package com.bloomly.bloomly

import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicSecureTextField
import androidx.compose.foundation.text.input.TextObfuscationMode
import androidx.compose.foundation.text.input.delete
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(onSubmit: (String, String) -> Unit){
    val username = rememberTextFieldState()
    val usernameError = remember { mutableStateOf(false) }
    val password = rememberTextFieldState()
    val passwordError = remember { mutableStateOf(false) }
    val showPassword = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            "Welcome Back!",
            fontSize = 42.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            "Masuk untuk melanjutkan pemesanan Anda"
        )


        Column(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .background(MaterialTheme.colorScheme.primary, RoundedCornerShape(24.dp))
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Username")
            OutlinedTextField(
                state = username,
                placeholder = { Text("username")},
                modifier = Modifier.fillMaxWidth(),
                isError = usernameError.value,
                supportingText = {
                    if(usernameError.value){
                        Text(
                            "username required"
                        )
                    }
                }
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
                            .fillMaxWidth()
                            .requiredHeight(52.dp)
                            .border(
                                width = 1.dp,
                                brush =
                                    if(passwordError.value){
                                        SolidColor(Color.Red)
                                    }else{
                                        SolidColor(Color.Black)
                                    },
                                shape = RoundedCornerShape(4.dp)
                            )
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.CenterStart)
                                .padding(16.dp)
                        ) {
                            if(password.text == ""){
                                Text(
                                    "password",
                                    modifier = Modifier.selectable(false, false, onClick = {})
                                )
                            }
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
            Text(
                text = "Lupa Password?",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp,10.dp)
                    .clickable(true, onClick = {}),
                textAlign = TextAlign.Right
            )

            Spacer(Modifier.height(16.dp))
            Button(
                onClick = {
                    usernameError.value = username.text.toString() == ""
                    passwordError.value = password.text.toString() == ""

                    showPassword.value = false
                    if(!passwordError.value && !usernameError.value){
                        onSubmit(username.text.toString(), password.text.toString())
                    }
//                username.edit { delete(0,username.text.length) }
//                password.edit { delete(0,password.text.length) }
                },
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(32.dp),
                colors = ButtonColors(MaterialTheme.colorScheme.tertiary, MaterialTheme.colorScheme.primary,
                    MaterialTheme.colorScheme.secondary, MaterialTheme.colorScheme.primary)
            ) {
                Text("Login")
            }
        }
    }
}