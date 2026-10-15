package com.bloomly.bloomly

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Construction
import androidx.compose.material.icons.filled.HeartBroken
import androidx.compose.material.icons.filled.MonitorHeart
import androidx.compose.material.icons.filled.Percent
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.SetMeal
import androidx.compose.material.icons.filled.Tag
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.draw.innerShadow
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp

@Preview
@Composable
private fun PreviewHomeScreen(){
    HomeScreen(onSearch = {})
}
@Composable
fun HomeScreen(onSearch: (String) -> Unit){
    val searchBarState = rememberTextFieldState()

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Welcome User...",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp),
            textAlign = TextAlign.Start
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
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
        ){
            item{
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                        .aspectRatio(1f)
                        .align(Alignment.CenterHorizontally),
                    contentAlignment = Alignment.Center
                ){
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            imageVector = Icons.Filled.HeartBroken,
                            contentDescription = null,
                            modifier = Modifier
                                .clickable(true, onClick = {})
                                .background(MaterialTheme.colorScheme.secondary, RoundedCornerShape(12.dp))
                                .padding(18.dp)
                        )
                        Spacer(Modifier.height(8.dp))
                        Text("Buket")
                    }
                }
            }

            item{
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                        .aspectRatio(1f)
                        .align(Alignment.CenterHorizontally),
                    contentAlignment = Alignment.Center
                ){
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            imageVector = Icons.Filled.SetMeal,
                            contentDescription = null,
                            modifier = Modifier
                                .clickable(true, onClick = {})
                                .background(MaterialTheme.colorScheme.secondary, RoundedCornerShape(12.dp))
                                .padding(18.dp)
                        )
                        Spacer(Modifier.height(8.dp))
                        Text("Hamper")
                    }
                }
            }

            item{
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                        .aspectRatio(1f)
                        .align(Alignment.CenterHorizontally),
                    contentAlignment = Alignment.Center
                ){
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            imageVector = Icons.Filled.Tag,
                            contentDescription = null,
                            modifier = Modifier
                                .clickable(true, onClick = {})
                                .background(MaterialTheme.colorScheme.secondary, RoundedCornerShape(12.dp))
                                .padding(18.dp)
                        )
                        Spacer(Modifier.height(8.dp))
                        Text("Promo")
                    }
                }
            }
        }

        Spacer(Modifier.height(24.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = "Product Terlaris"
            )
            Text(
                text = "Lihat Semua",
                modifier = Modifier
                    .clickable(onClick = {}),
                color = Color.Blue
            )
        }
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(24.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp),
            horizontalArrangement = Arrangement.spacedBy(14.dp),
        ){
            items(count = 12){
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .shadow(2.dp, RoundedCornerShape(16.dp))
                        .background(MaterialTheme.colorScheme.primary, RoundedCornerShape(16.dp))
                        .aspectRatio(1f)
                        .clickable(onClick = {})

                        .align(Alignment.CenterHorizontally),
                    contentAlignment = Alignment.Center
                ){
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            imageVector = Icons.Filled.Construction,
                            contentDescription = null
                        )
                        Text(
                            "Item Name",
                            modifier = Modifier
                                .fillMaxWidth(0.8f),
                            textAlign = TextAlign.Start
                        )
                        Text(
                            "Rp.0",
                            modifier = Modifier
                                .fillMaxWidth(0.8f),
                            textAlign = TextAlign.Start
                        )
                    }
                }
            }
        }
    }
}