
package com.bloomly.bloomly

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicSecureTextField
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextObfuscationMode
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.CardGiftcard
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
private val Maroon = Color(0xFF8D4A53)
private val DarkText = Color(0xFF59474A)
private val HintText = Color(0xFFB49FA2)

@Composable
fun LoginScreen(
    onSubmit: (String, String) -> Unit,
    onRegister: () -> Unit = {},
    onBack: () -> Unit = {}
) {

    val email = rememberTextFieldState()
    val password = rememberTextFieldState()

    var showPassword by remember { mutableStateOf(false) }
    var emailError by remember { mutableStateOf(false) }
    var passwordError by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 16.dp)
    ) {

        // HEADER
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                Icons.Filled.ArrowBackIosNew,
                contentDescription = "Back",
                tint = DarkText,
                modifier = Modifier.clickable { onBack() }
            )

            Spacer(Modifier.weight(1f))

            Text(
                "Login",
                fontWeight = FontWeight.SemiBold,
                color = DarkText,
                fontSize = 18.sp
            )

            Spacer(Modifier.weight(1f))
            Spacer(Modifier.size(24.dp))
        }

        Spacer(Modifier.height(12.dp))

        // BADGE
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier
                    .background(
                        MaterialTheme.colorScheme.secondary,
                        RoundedCornerShape(50.dp)
                    )
                    .padding(horizontal = 12.dp, vertical = 5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    Icons.Default.CardGiftcard,
                    contentDescription = null,
                    tint = Maroon,
                    modifier = Modifier.size(13.dp)
                )

                Spacer(Modifier.width(5.dp))

                Text(
                    "MORE THAN JUST A GIFT",
                    fontSize = 9.sp,
                    color = Maroon,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Spacer(Modifier.height(20.dp))

        // TITLE
        Text(
            "Welcome Back!",
            modifier = Modifier.fillMaxWidth(),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = DarkText,
            textAlign = TextAlign.Center
        )

        Spacer(Modifier.height(5.dp))

        Text(
            "Masuk untuk melanjutkan pesanan manis Anda",
            modifier = Modifier.fillMaxWidth(),
            fontSize = 13.sp,
            color = HintText,
            textAlign = TextAlign.Center
        )

        Spacer(Modifier.height(24.dp))

        // LOGIN FORM
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Color.White,
                    RoundedCornerShape(22.dp)
                )
                .padding(16.dp)
        ) {

            // EMAIL
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    Icons.Default.Email,
                    contentDescription = null,
                    tint = Maroon,
                    modifier = Modifier.size(16.dp)
                )

                Spacer(Modifier.width(6.dp))

                Text(
                    "Email atau Nomor HP",
                    fontSize = 13.sp,
                    color = DarkText
                )
            }

            Spacer(Modifier.height(7.dp))

            OutlinedTextField(
                state = email,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(58.dp),
                placeholder = {
                    Text(
                        "nama@email.com / 0812xxx",
                        fontSize = 13.sp,
                        color = HintText
                    )
                },
                isError = emailError,
                shape = RoundedCornerShape(13.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.secondary,
                    unfocusedContainerColor = MaterialTheme.colorScheme.secondary,
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    errorBorderColor = Maroon,
                    focusedTextColor = DarkText,
                    unfocusedTextColor = DarkText
                ),
                lineLimits = TextFieldLineLimits.SingleLine
            )

            // PASSWORD
            Spacer(Modifier.height(10.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    Icons.Default.Lock,
                    contentDescription = null,
                    tint = Maroon,
                    modifier = Modifier.size(16.dp)
                )

                Spacer(Modifier.width(6.dp))

                Text(
                    "Password",
                    fontSize = 13.sp,
                    color = DarkText
                )
            }

            Spacer(Modifier.height(7.dp))

            BasicSecureTextField(
                state = password,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(58.dp),
                textStyle = TextStyle(
                    fontSize = 13.sp,
                    color = DarkText
                ),
                cursorBrush = SolidColor(Maroon),
                textObfuscationMode =
                    if (showPassword)
                        TextObfuscationMode.Visible
                    else
                        TextObfuscationMode.Hidden,

                decorator = { innerTextField ->
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                MaterialTheme.colorScheme.secondary,
                                RoundedCornerShape(13.dp)
                            )
                            .padding(horizontal = 14.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier.weight(1f)
                        ) {
                            if (password.text.isEmpty()) {
                                Text(
                                    "Masukkan kata sandi",
                                    color = HintText,
                                    fontSize = 13.sp
                                )
                            }

                            innerTextField()
                        }

                        Icon(
                            imageVector =
                                if (showPassword)
                                    Icons.Default.Visibility
                                else
                                    Icons.Default.VisibilityOff,
                            contentDescription = "Toggle Password",
                            tint = Maroon,
                            modifier = Modifier.clickable {
                                showPassword = !showPassword
                            }
                        )
                    }
                }
            )

            // FORGOT PASSWORD
            Text(
                "Lupa password?",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 9.dp)
                    .clickable {
                        // Fitur lupa password
                    },
                color = Maroon,
                fontSize = 12.sp,
                textAlign = TextAlign.End
            )

            Spacer(Modifier.height(14.dp))

            // LOGIN BUTTON
            Button(
                onClick = {
                    emailError = email.text.isEmpty()
                    passwordError = password.text.isEmpty()

                    if (!emailError && !passwordError) {
                        showPassword = false
                        onSubmit(
                            email.text.toString(),
                            password.text.toString()
                        )
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                shape = RoundedCornerShape(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Maroon
                )
            ) {
                Text(
                    "Login",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(Modifier.width(8.dp))

                Icon(
                    Icons.Default.ArrowForward,
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
            }
        }

        Spacer(Modifier.height(16.dp))

        // SECURITY MESSAGE
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Color(0xFFF9EDEF),
                    RoundedCornerShape(13.dp)
                )
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                Icons.Default.Lock,
                contentDescription = null,
                tint = Maroon,
                modifier = Modifier.size(18.dp)
            )

            Spacer(Modifier.width(10.dp))

            Text(
                "Setiap transaksi dirangkai penuh kehangatan tanpa mengorbankan keamanan.",
                fontSize = 10.sp,
                color = DarkText,
                lineHeight = 15.sp
            )
        }

        Spacer(Modifier.height(18.dp))

        // REGISTER
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "Belum punya akun?",
                fontSize = 12.sp,
                color = HintText
            )

            Spacer(Modifier.width(5.dp))

            Text(
                "Daftar",
                fontSize = 12.sp,
                color = Maroon,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable {
                    onRegister()
                }
            )
        }

        Spacer(Modifier.height(20.dp))
    }
}
