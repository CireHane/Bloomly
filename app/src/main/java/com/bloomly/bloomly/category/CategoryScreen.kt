package com.bloomly.bloomly.category

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bloomly.bloomly.R
import com.bloomly.bloomly.ui.theme.LiberationSansFamily

@Composable
fun CategoryScreen(onBack: () -> Unit, onClickFlower: () -> Unit, onClickHamper: () -> Unit, onClickMoney: () -> Unit){
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBackIosNew,
                contentDescription = null,
                modifier = Modifier.clickable(onClick = onBack)
            )
            Text(
                text = "Kategori",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontFamily = LiberationSansFamily
            )
        }

        CategoryCard(onClickFlower, "Buket Bunga", "Buket segat dan artificial", R.drawable.placeholder_300x200)
        CategoryCard(onClickMoney, "Buket Uang", "Kado anti mainstream", R.drawable.placeholder_300x200)
        CategoryCard(onClickHamper, "Hamper", "Makanan, gift, self care ...", R.drawable.placeholder_300x200)
    }
}

@Composable
private fun CategoryCard(onClick: () -> Unit, header: String, subtext: String, imageId: Int){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp, 5.dp),
        colors = CardDefaults.cardColors(
            MaterialTheme.colorScheme.primary,
            Color.Black
        ),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .clickable(onClick = onClick)
                .fillMaxSize()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Box(
                Modifier
                    .size(100.dp),
                contentAlignment = Alignment.Center
            ){
                Image(
                    painter = painterResource(imageId),
                    contentDescription = null,
                    contentScale = ContentScale.Fit
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(horizontal = 10.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = header,
                    fontFamily = LiberationSansFamily,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = subtext,
                    fontFamily = LiberationSansFamily,
                    color = Color(0x65000000),
                    fontSize = 12.sp
                )
            }
        }
    }
}