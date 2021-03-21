/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme

class HomeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MainScreen()
            }
        }
    }

    data class Item(
        val image: Int,
        val name: String
    )
}

val themes = listOf(
    HomeActivity.Item(R.drawable.theme1, "Desert chic"),
    HomeActivity.Item(R.drawable.theme2, "Tiny terrariums"),
    HomeActivity.Item(R.drawable.theme3, "Jungle vibes"),
    HomeActivity.Item(R.drawable.theme4, "Easy case"),
    HomeActivity.Item(R.drawable.theme5, "Statements"),
)

val flowers = listOf(
    HomeActivity.Item(R.drawable.flower1, "Monstera"),
    HomeActivity.Item(R.drawable.flower2, "Aglaonema"),
    HomeActivity.Item(R.drawable.flower3, "Peace Lily"),
    HomeActivity.Item(R.drawable.flower4, "Fiddle leaf tree"),
    HomeActivity.Item(R.drawable.flower5, "Snake plant"),
    HomeActivity.Item(R.drawable.flower6, "Photos"),
)

@Composable
fun Home() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        color = MaterialTheme.colors.background
    ) {
        val isLightTheme = MaterialTheme.colors.isLight
        Column {
            Spacer(Modifier.height(40.dp))
            OutlinedTextField(
                value = "Search",
                onValueChange = { /* nop */ },
                modifier = Modifier
                    .height(56.dp)
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth(),
                textStyle = MaterialTheme.typography.body1,
                leadingIcon = { Icon(Icons.Default.Search, "") }
            )
            Column(
                modifier = Modifier
                    .wrapContentHeight()
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Browse themes",
                    modifier = Modifier
                        .firstBaselineToTop(48.dp, 32.dp),
                    color = MaterialTheme.colors.onPrimary,
                    style = MaterialTheme.typography.h1
                )
            }

            LazyRow(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth(),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 0.dp)
            ) {
                itemsIndexed(themes) { index, theme ->
                    Card(
                        modifier = Modifier
                            .height(136.dp)
                            .width(136.dp)
                            .padding(bottom = 8.dp),
                        shape = MaterialTheme.shapes.small,
                        elevation = 1.dp
                    ) {
                        Column(
                            modifier = Modifier
                                .wrapContentHeight()
                                .fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = theme.image),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(136.dp, 96.dp),
                                contentScale = ContentScale.Crop,
                            )
                            Column(
                                modifier = Modifier
                                    .height(40.dp)
                                    .fillMaxWidth(),
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = theme.name,
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    color = MaterialTheme.colors.onPrimary,
                                    textAlign = TextAlign.Center,
                                    style = MaterialTheme.typography.h2
                                )
                            }
                        }
                    }

                    if (index != themes.size) {
                        Spacer(Modifier.width(8.dp))
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                Text(
                    text = "Design your home garden",
                    modifier = Modifier
                        .weight(1f),
                    style = MaterialTheme.typography.h1
                )
                Icon(Icons.Default.FilterList, "")
            }
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .wrapContentHeight()
                    .fillMaxWidth(),
            ) {
                itemsIndexed(flowers) { index, flower ->
                    Card(
                        modifier = Modifier
                            .height(64.dp)
                            .fillMaxWidth(),
                        shape = MaterialTheme.shapes.small,
                        backgroundColor = MaterialTheme.colors.background,
                        elevation = 0.dp
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = flower.image),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(64.dp, 64.dp)
                                    .clip(shape = MaterialTheme.shapes.small),
                                contentScale = ContentScale.Crop,
                            )
                            Spacer(Modifier.width(16.dp))
                            Row {
                                Column(
                                    modifier = Modifier
                                        .padding(bottom = 8.dp)
                                        .weight(1f),
                                ) {
                                    Text(
                                        text = flower.name,
                                        style = MaterialTheme.typography.h2
                                    )
                                    Text(
                                        text = "This is description",
                                        style = MaterialTheme.typography.body1
                                    )
                                }
                                Checkbox(
                                    checked = index == 0,
                                    onCheckedChange = { /* nop */ },
                                    modifier = Modifier
                                        .size(24.dp, 24.dp),
                                    colors = CheckboxDefaults.colors(
                                        checkedColor = MaterialTheme.colors.secondary,
                                        checkmarkColor = MaterialTheme.colors.onSecondary
                                    )
                                )
                            }
                        }
                    }
                    Divider(
                        startIndent = 80.dp,
                        color = Color.LightGray
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    val items = listOf(
        Pair(
            R.string.navigation_home,
            Icons.Default.Home
        ),
        Pair(
            R.string.navigation_favorites,
            Icons.Default.FavoriteBorder
        ),
        Pair(
            R.string.navigation_profile,
            Icons.Default.AccountCircle
        ),
        Pair(
            R.string.navigation_cart,
            Icons.Default.ShoppingCart
        ),
    )
    Scaffold(
        bottomBar = {
            BottomNavigation(
                backgroundColor = MaterialTheme.colors.primary,
                elevation = 16.dp
            ) {
                items.forEachIndexed { index, item ->
                    BottomNavigationItem(
                        icon = { Icon(item.second, "") },
                        label = {
                            Text(
                                text = stringResource(item.first),
                                color = MaterialTheme.colors.onPrimary,
                            )
                        },
                        selected = (index == 0),
                        onClick = { /* nop */ }
                    )
                }
            }
        }
    ) {
        Home()
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun HomeLightPreview() {
    MyTheme {
        MainScreen()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun HomeDarkPreview() {
    MyTheme(darkTheme = true) {
        MainScreen()
    }
}
