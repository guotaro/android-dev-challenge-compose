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
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme

class LogInActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                LogIn()
            }
        }
    }
}

@Composable
fun LogIn() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        color = MaterialTheme.colors.background

    ) {
        Column {

            Column(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Log in with email",
                    modifier = Modifier
                        .firstBaselineToTop(200.dp, 184.dp),
                    style = MaterialTheme.typography.h1
                )
            }
            OutlinedTextField(
                value = "Email address",
                onValueChange = { /* nop */ },
                modifier = Modifier
                    .height(56.dp)
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth(),
                textStyle = MaterialTheme.typography.body1,
            )
            Spacer(Modifier.height(8.dp))
            OutlinedTextField(
                value = "Password (8+ characters)",
                onValueChange = { /* nop */ },
                modifier = Modifier
                    .height(56.dp)
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth(),
                textStyle = MaterialTheme.typography.body1,
            )
            Column(
                modifier = Modifier
                    .wrapContentHeight()
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = buildAnnotatedString {
                        append("By clicking below, you agree to our ")
                        withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                            append("Terms of Use")
                        }
                        append(" and consent to out ")
                        withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                            append("Privacy Policy")
                        }
                        append(".")
                    },
                    modifier = Modifier
                        .firstBaselineToTop(56.dp, 24.dp),
                    color = MaterialTheme.colors.onPrimary,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.body2,
                )
            }
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
                    .height(46.dp),
                shape = MaterialTheme.shapes.medium,
                elevation = null,
                colors = ButtonDefaults.textButtonColors(
                    backgroundColor = MaterialTheme.colors.secondary
                )
            ) {
                Text(
                    text = "Log in",
                    color = MaterialTheme.colors.onSecondary,
                    style = MaterialTheme.typography.button
                )
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LogInLightPreview() {
    MyTheme {
        LogIn()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun LogInDarkPreview() {
    MyTheme(darkTheme = true) {
        LogIn()
    }
}
