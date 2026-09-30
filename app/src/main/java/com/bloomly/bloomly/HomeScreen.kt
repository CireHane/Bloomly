package com.bloomly.bloomly

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
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(onSearch: (String) -> Unit){
    val searchBarState = rememberTextFieldState()

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
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
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(100),
            trailingIcon = {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search",
                    modifier = Modifier
                        .border(0.dp, SolidColor(Color(1,1,1,0)),RoundedCornerShape(100))
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
                        .border(1.dp, SolidColor(Color.Black), RoundedCornerShape(8.dp))
                        .clickable(onClick = {})
                        .align(Alignment.CenterHorizontally),
                    contentAlignment = Alignment.Center
                ){
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            imageVector = Icons.Filled.HeartBroken,
                            contentDescription = null
                        )
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
                        .border(1.dp, SolidColor(Color.Black), RoundedCornerShape(8.dp))
                        .clickable(onClick = {})
                        .align(Alignment.CenterHorizontally),
                    contentAlignment = Alignment.Center
                ){
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            imageVector = Icons.Filled.SetMeal,
                            contentDescription = null
                        )
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
                        .border(1.dp, SolidColor(Color.Black), RoundedCornerShape(8.dp))
                        .clickable(onClick = {})
                        .align(Alignment.CenterHorizontally),
                    contentAlignment = Alignment.Center
                ){
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            imageVector = Icons.Filled.Percent,
                            contentDescription = null
                        )
                        Text("Diskon")
                    }
                }
            }
        }

        Spacer(Modifier.height(24.dp))
        Text(
            text = "Product Terlaris",
            modifier = Modifier
                .fillMaxWidth(0.8f),
            textAlign = TextAlign.Start
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(24.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp),
            horizontalArrangement = Arrangement.spacedBy(14.dp)
        ){
            items(count = 12){
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f)
                        .border(1.dp, SolidColor(Color.Black), RoundedCornerShape(8.dp))
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