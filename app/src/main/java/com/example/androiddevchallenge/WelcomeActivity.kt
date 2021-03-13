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
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.*

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        color = MaterialTheme.colors.primary
    ) {
        val isLightTheme = MaterialTheme.colors.isLight

        Image(
            painter = painterResource(
                id = if (isLightTheme) R.drawable.light_welcome_bg else R.drawable.dark_welcome_bg
            ),
            contentDescription = "",
            modifier = Modifier.fillMaxWidth(),
        )
        Column {

            Spacer(Modifier.height(72.dp))
            Image(
                painter = painterResource(
                    id = if (isLightTheme) R.drawable.light_welcome_illos else R.drawable.dark_welcome_illos
                ),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 88.dp),
                alignment = Alignment.CenterStart,
                contentScale = ContentScale.None,
            )
            Spacer(Modifier.height(48.dp))
            Image(
                painter = painterResource(id = R.drawable.light_logo),
                contentDescription = "",
                modifier = Modifier.fillMaxWidth(),
            )
            Column(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Beautiful home garden solution",
                    modifier = Modifier
                        .firstBaselineToTop(72.dp, 32.dp),
                    style = typography.subtitle1
                )
            }
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
                    .height(46.dp),
                shape = shapes.medium,
                elevation = null,
                colors = ButtonDefaults.textButtonColors(
                    backgroundColor = MaterialTheme.colors.secondary
                )
            ) {
                Text(
                    text = "Create account",
                    color = MaterialTheme.colors.onSecondary,
                    style = typography.button
                )
            }
            Spacer(Modifier.height(8.dp))
            Column(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .wrapContentWidth()
                        .height(46.dp),
                    shape = shapes.medium,
                    elevation = null,
                    colors = ButtonDefaults.textButtonColors(
                        backgroundColor = Color.Transparent
                    )
                ) {
                    Text(
                        text = "Log in",
                        color = if (isLightTheme) pink900 else white,
                        style = typography.button
                    )
                }
            }
        }

    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 600, showBackground = true)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}

fun Modifier.firstBaselineToTop(
    contentHeight: Dp,
    firstBaselineToTop: Dp,
) = Modifier.layout { measurable, constraints ->
    // Measure the composable
    val placeable = measurable.measure(constraints)

    // Check the composable has a first baseline
    check(placeable[FirstBaseline] != AlignmentLine.Unspecified)
    val firstBaseline = placeable[FirstBaseline]

    // Height of the composable with padding - first baseline
    val placeableY = firstBaselineToTop.roundToPx() - firstBaseline
    layout(placeable.width, contentHeight.roundToPx()) {
        // Where the composable gets placed
        placeable.placeRelative(0, placeableY)
    }
}

