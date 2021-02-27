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
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.PuppyRepo
import com.example.androiddevchallenge.ui.PuppyDetail
import com.example.androiddevchallenge.ui.components.StaggeredVerticalGrid
import com.example.androiddevchallenge.ui.theme.MyTheme
import dev.chrisbanes.accompanist.coil.CoilImage
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                JetsnackApp(onBackPressedDispatcher)
            }
        }
    }
}


@Composable
fun JetsnackApp(backDispatcher: OnBackPressedDispatcher) {
    val navigator: Navigator<Destination> = rememberSaveable(
        saver = Navigator.saver(backDispatcher)
    ) {
        Navigator(Destination.Home, backDispatcher)
    }
    val actions = remember(navigator) { Actions(navigator) }
    ProvideWindowInsets {
        MyTheme {
            Crossfade(navigator.current) { puppy ->
                when (puppy) {
                    Destination.Home -> Home(actions.selectPuppy)
                    is Destination.PuppyDetail -> PuppyDetail(
                        puppyId = puppy.puppyId,
                        upPress = actions.upPress
                    )
                }
            }
        }
    }
}

// Start building your app here!
@Composable
fun Home(onPuppySelected: (Long) -> Unit) {
    Surface(color = MaterialTheme.colors.background) {
        val columnWidth = mutableStateOf((100..250).random())

        Column {
            Button(
                onClick = {
                    columnWidth.value = (100..250).random()
                },
                modifier = Modifier.padding(6.dp)
            ) {
                Text(
                    text = "Card Resize",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            LazyColumn {
                item {
                    StaggeredVerticalGrid(
                        maxColumnWidth = columnWidth.value.dp,
                        modifier = Modifier.padding(4.dp)
                    ) {
                        PuppyRepo.puppyCollection.forEach {
                            Card(it.id,it.name, it.imageUrl, columnWidth,onPuppySelected)
                        }
                    }
                }
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        Home({})
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        Home({})
    }
}

@Composable
fun Card(
    id:Long,
    name: String,
    imageUrl: String,
    state: MutableState<Int>,
    onPuppySelected: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    val color = remember(state.value) {
        mutableStateOf(Color((0xFF000000..0xFFFFFFFF).random()))
    }

    Surface(
        modifier = modifier.padding(4.dp),
        color = color.value,
        elevation = 8.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier
                .height((100..250).random().dp)
                .clickable { onPuppySelected(id) }
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center
        ) {
            CoilImage(
                data = imageUrl,
                contentDescription = name,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

private fun Color.whiteness(): Float {
    return (red + green + blue) / 3
}

private fun Color.rippleColor(): Color {
    return if (whiteness() >= 0.5) Color.Black else Color.White
}
