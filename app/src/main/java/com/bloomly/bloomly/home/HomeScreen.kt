package com.bloomly.bloomly.home

import android.transition.CircularPropagation
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalGridApi
import androidx.compose.foundation.layout.Grid
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.bloomly.bloomly.R
import com.bloomly.bloomly.data.Item
import com.bloomly.bloomly.ui.theme.LiberationSansFamily

//@Preview
//@Composable
//private fun PreviewHomeScreen(){
//    Scaffold(Modifier.fillMaxWidth()) { padding ->
//        Spacer(Modifier.padding(padding))
//        HomeScreen(onSearch = {})
//    }
//}

@Composable
fun HomeScreen(
    uiState: HomeUiState,
    onSearch: (String) -> Unit
){
    val searchBarState = rememberTextFieldState()

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(Modifier.height(20.dp))
        Text(
            text = "Hai, John!",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 6.dp),
            textAlign = TextAlign.Start,
            fontFamily = LiberationSansFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 6.em
        )
        Text(
            text = "Siap membuat hari seseorang lebih special?",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start,
            fontFamily = LiberationSansFamily,
            color = Color(0x65000000)
        )
        Spacer(Modifier.height(48.dp))
        TextField(
            state = searchBarState,
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(100),
            placeholder = { Text("Cari buket, hamper, atau occasion...") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search",
                    modifier = Modifier
                        .border(0.dp, SolidColor(Color(1, 1, 1, 0)), RoundedCornerShape(100))
                        .clickable(onClick = { onSearch(searchBarState.toString()) })
                )
            },
            lineLimits = TextFieldLineLimits.SingleLine
        )

        Spacer(Modifier.height(24.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp, 0.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .padding(4.dp),
                contentAlignment = Alignment.Center
            ){
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        painter = painterResource(R.drawable.icon_buket_80),
                        contentDescription = null,
                        modifier = Modifier
                            .clickable(true, onClick = {})
                            .background(MaterialTheme.colorScheme.secondary, RoundedCornerShape(12.dp))
                            .padding(18.dp),
                        tint = MaterialTheme.colorScheme.tertiary
                    )
                    Spacer(Modifier.height(8.dp))
                    Text("Buket")
                }
            }
            Box(
                modifier = Modifier
                    .padding(4.dp),
                contentAlignment = Alignment.Center
            ){
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        painter = painterResource(R.drawable.icon_hamper_80),
                        contentDescription = null,
                        modifier = Modifier
                            .clickable(true, onClick = {})
                            .background(MaterialTheme.colorScheme.secondary, RoundedCornerShape(12.dp))
                            .padding(18.dp),
                        tint = MaterialTheme.colorScheme.tertiary
                    )
                    Spacer(Modifier.height(8.dp))
                    Text("Hamper")
                }
            }
            Box(
                modifier = Modifier
                    .padding(4.dp),
                contentAlignment = Alignment.Center
            ){
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        painter = painterResource(R.drawable.icon_custom_80),
                        contentDescription = null,
                        modifier = Modifier
                            .clickable(true, onClick = {})
                            .background(MaterialTheme.colorScheme.secondary, RoundedCornerShape(12.dp))
                            .padding(18.dp),
                        tint = MaterialTheme.colorScheme.tertiary
                    )
                    Spacer(Modifier.height(8.dp))
                    Text("Custom")
                }
            }
            Box(
                modifier = Modifier
                    .padding(4.dp),
                contentAlignment = Alignment.Center
            ){
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        painter = painterResource(R.drawable.icon_promo_80),
                        contentDescription = null,
                        modifier = Modifier
                            .clickable(true, onClick = {})
                            .background(MaterialTheme.colorScheme.secondary, RoundedCornerShape(12.dp))
                            .padding(18.dp),
                        tint = MaterialTheme.colorScheme.tertiary
                    )
                    Spacer(Modifier.height(8.dp))
                    Text("Promo")
                }
            }
        }
        Spacer(Modifier.height(24.dp))
        MiddleSection()
        Spacer(Modifier.height(24.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Product Terlaris",
                fontFamily = LiberationSansFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 4.em
            )
            Text(
                text = "Lihat Semua",
                modifier = Modifier
                    .clickable(onClick = {}),
                fontFamily = LiberationSansFamily,
                color = MaterialTheme.colorScheme.tertiary
            )
        }
        Spacer(Modifier.height(12.dp))

        when{
            uiState.isLoading -> LoadingCompose()
            else -> ListPopularProduct( uiState.popularItems )
        }
    }
}

@Composable
private fun MiddleSection(){
    Row(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.secondary, RoundedCornerShape(20.dp))
            .padding(20.dp, 12.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = "Special Gift",
                fontFamily = LiberationSansFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 5.em
            )
            Text(
                text = "For a Special Person",
                fontFamily = LiberationSansFamily,
            )
            Spacer(Modifier.height(24.dp))
            Button(
                onClick = {},
                modifier = Modifier
                    .padding(8.dp, 4.dp),
                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.tertiary),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "Lihat Koleksi →",
                    fontFamily = LiberationSansFamily,
                    color = MaterialTheme.colorScheme.background
                )
            }
        }
        Image(
            painter = painterResource(id= R.drawable.placeholder_300x200),
            contentDescription = null,
        )
    }
}

@OptIn(ExperimentalGridApi::class)
@Composable
private fun ListPopularProduct(popularItems: List<Item>){
    Grid(
        config = {
            gap(20.dp)
            column(0.5f)
            column(0.5f)
        },
        modifier = Modifier.fillMaxWidth()
    ) {
        popularItems.forEach { item ->

            Card(
//                modifier = Modifier
//                    .fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    MaterialTheme.colorScheme.primary,
                    Color.Black
                )
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(id = item.image),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .padding(8.dp)
                            .clip(RoundedCornerShape(8.dp))
                    )
                    Text(
                        text = item.name,
                        modifier = Modifier
                            .fillMaxWidth(0.9f),
                        textAlign = TextAlign.Start,
                        fontFamily = LiberationSansFamily,
                        fontWeight = FontWeight.Normal
                    )
                    Text(
                        text = "Rp." + formatPrice(item.price),
                        modifier = Modifier
                            .fillMaxWidth(0.9f),
                        textAlign = TextAlign.Start,
                        fontFamily = LiberationSansFamily,
                        fontWeight = FontWeight.Normal,
                        color = MaterialTheme.colorScheme.tertiary
                    )
                    Spacer(Modifier.height(12.dp))
                }
            }
        }
    }
}

@Composable
fun LoadingCompose(){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 64.dp),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            color = MaterialTheme.colorScheme.tertiary,
            strokeWidth = 6.dp
        )
    }
}

// TODO - Find a better way
private fun formatPrice(price : Int) : String{
     return price.toString()
        .reversed()
        .chunked(3)
        .joinToString(".")
        .reversed()
}