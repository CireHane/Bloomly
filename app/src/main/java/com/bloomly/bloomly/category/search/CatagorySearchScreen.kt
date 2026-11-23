package com.bloomly.bloomly.category.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bloomly.bloomly.R
import com.bloomly.bloomly.data.Item
import com.bloomly.bloomly.formatPrice
import com.bloomly.bloomly.ui.theme.LiberationSansFamily
import kotlin.collections.forEach

@Composable
fun CatagorySearchScreen(
    uiState: CategorySearchUiState,
    category: String = "",
    search: String = "",
    promoStart: Boolean = false,
    onBack: () -> Unit,
    onSearch: (String) -> Unit
) {
    val searchBarState = rememberTextFieldState(search)
    var categoryExpandState by remember { mutableStateOf(false) }
    var sortExpandState by remember { mutableStateOf(false) }
    var promoExpandState by remember { mutableStateOf(false) }

    var filter by rememberSaveable { mutableStateOf(category) }
    var sort by rememberSaveable { mutableStateOf("") }
    var promo by rememberSaveable { mutableStateOf(promoStart) }

    Column(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.background)
    ) {
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBackIosNew,
                contentDescription = null,
                modifier = Modifier
                    .padding(8.dp)
                    .clip(RoundedCornerShape(100))
                    .clickable(onClick = onBack)
            )
            OutlinedTextField(
                state = searchBarState,
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(100),
                placeholder = { Text("buket mawar, hamper sweet...") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Search",
                        modifier = Modifier
                            .border(0.dp, SolidColor(Color(1, 1, 1, 0)), RoundedCornerShape(100))
                            .clickable(onClick = { onSearch(searchBarState.toString()) })
                    )
                },
                lineLimits = TextFieldLineLimits.SingleLine,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.secondary,
                    unfocusedContainerColor = MaterialTheme.colorScheme.secondary,
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    focusedTextColor = MaterialTheme.colorScheme.tertiary,
                    unfocusedTextColor = MaterialTheme.colorScheme.tertiary
                ),
            )
        }
        Spacer(Modifier.height(10.dp))

        Row(
            modifier = Modifier
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            // Filter Button //
            Box{

                Button(
                    onClick = {categoryExpandState = !categoryExpandState},
                    shape = RoundedCornerShape(100),
                    colors = ButtonDefaults.buttonColors(
                        if (filter == "")
                            MaterialTheme.colorScheme.primary
                        else
                            MaterialTheme.colorScheme.tertiary,
                        if (filter == "")
                            MaterialTheme.colorScheme.tertiary
                        else
                            MaterialTheme.colorScheme.background),
                    elevation = ButtonDefaults.buttonElevation(2.dp)
                ) {
                    Text(
                        text =
                            if(filter == ""){
                                "Category"
                            }
                            else{
                                "Category: ${ filter.replaceFirstChar { it.uppercase() } }"
                            }
                    )
                }
                DropdownMenu(
                    expanded = categoryExpandState,
                    onDismissRequest = {categoryExpandState = false},
                    containerColor = MaterialTheme.colorScheme.secondary,
                    shape = RoundedCornerShape(15)
                ) {
                    DropdownMenuItem(
                        text = {Text(
                            "Clear",
                            fontFamily = LiberationSansFamily,
                            fontSize = 13.sp
                        )},
                        onClick = {
                            filter = ""
                            categoryExpandState = false
                        }
                    )
                    DropdownMenuItem(
                        text = {Text(
                            "Bunga",
                            fontFamily = LiberationSansFamily,
                            fontSize = 13.sp
                        )},
                        onClick = {
                            filter = "bunga"
                            categoryExpandState = false
                        }
                    )
                    DropdownMenuItem(
                        text = {Text(
                            "Hamper",
                            fontFamily = LiberationSansFamily,
                            fontSize = 13.sp
                        )},
                        onClick = {
                            filter = "hamper"
                            categoryExpandState = false
                        }
                    )
                    DropdownMenuItem(
                        text = {Text(
                            "Uang",
                            fontFamily = LiberationSansFamily,
                            fontSize = 13.sp
                        )},
                        onClick = {
                            filter = "uang"
                            categoryExpandState = false
                        }
                    )
                }
            }

            // Sort Button //
            Box{

                Button(
                    onClick = {sortExpandState = !sortExpandState},
                    shape = RoundedCornerShape(100),
                    colors = ButtonDefaults.buttonColors(
                        if (sort == "")
                            MaterialTheme.colorScheme.primary
                        else
                            MaterialTheme.colorScheme.tertiary,
                        if (sort == "")
                            MaterialTheme.colorScheme.tertiary
                        else
                            MaterialTheme.colorScheme.background),
                    elevation = ButtonDefaults.buttonElevation(2.dp)
                ) {
                    Text(
                        text =
                            if(sort == ""){
                                "Sort"
                            }
                            else{
                                "Sort: ${ sort.replaceFirstChar { it.uppercase() } }"
                            }
                    )
                }
                DropdownMenu(
                    expanded = sortExpandState,
                    onDismissRequest = {sortExpandState = false},
                    containerColor = MaterialTheme.colorScheme.secondary,
                    shape = RoundedCornerShape(15)
                ) {
                    DropdownMenuItem(
                        text = {Text(
                            "Clear",
                            fontFamily = LiberationSansFamily,
                            fontSize = 13.sp
                        )},
                        onClick = {
                            sort = ""
                            sortExpandState = false
                        }
                    )
                    DropdownMenuItem(
                        text = {Text(
                            "Terlaris",
                            fontFamily = LiberationSansFamily,
                            fontSize = 13.sp
                        )},
                        onClick = {
                            sort = "terlaris"
                            sortExpandState = false
                        }
                    )
                    DropdownMenuItem(
                        text = {Text(
                            "Termurah",
                            fontFamily = LiberationSansFamily,
                            fontSize = 13.sp
                        )},
                        onClick = {
                            sort = "termurah"
                            sortExpandState = false
                        }
                    )
                }
            }

            // Promo Button //
            Box{

                Button(
                    onClick = {promoExpandState = !promoExpandState},
                    shape = RoundedCornerShape(100),
                    colors = ButtonDefaults.buttonColors(
                        if (!promo)
                            MaterialTheme.colorScheme.primary
                        else
                            MaterialTheme.colorScheme.tertiary,
                        if (!promo)
                            MaterialTheme.colorScheme.tertiary
                        else
                            MaterialTheme.colorScheme.background),
                    elevation = ButtonDefaults.buttonElevation(2.dp)
                ) {
                    Text(
                        text =
                            if(!promo){
                                "Show All"
                            }
                            else{
                                "Show Promo item"
                            }
                    )
                }
                DropdownMenu(
                    expanded = promoExpandState,
                    onDismissRequest = {promoExpandState = false},
                    containerColor = MaterialTheme.colorScheme.secondary,
                    shape = RoundedCornerShape(15)
                ) {
                    DropdownMenuItem(
                        text = {Text(
                            "Show All",
                            fontFamily = LiberationSansFamily,
                            fontSize = 13.sp
                        )},
                        onClick = {
                            promo = false
                            promoExpandState = false
                        }
                    )
                    DropdownMenuItem(
                        text = {Text(
                            "Show Promo only",
                            fontFamily = LiberationSansFamily,
                            fontSize = 13.sp
                        )},
                        onClick = {
                            promo = true
                            promoExpandState = false
                        }
                    )
                }
            }
        }
        Spacer(Modifier.height(12.dp))

        when{
            uiState.isLoading -> LoadingCompose()
            else -> ListProduct(uiState.items, {})
        }
    }
}

@OptIn(ExperimentalGridApi::class)
@Composable
private fun ListProduct(items: List<Item>, onProduct: (Int) -> Unit){
    Grid(
        config = {
            gap(20.dp)
            column(0.5f)
            column(0.5f)
        },
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        items.forEach { item ->

            Card(
                modifier = Modifier
                    .clickable(onClick = {onProduct(item.id)}),
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