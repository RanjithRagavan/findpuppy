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
package com.example.androiddevchallenge.model

import androidx.compose.runtime.Immutable

object PuppyRepo {
    val puppyCollection = listOf(
        puppy(
            id = 1,
            name = "Puppy1",
            imageUrl = "https://source.unsplash.com/9M0tSjb-cpA",
            address="Lorem ipsum dolor sit amet",
            tagLine="cuite pie"
        ),
        puppy(
            id = 2,
            name = "Puppy2",
            imageUrl = "https://source.unsplash.com/Z1-yorzKan8",
            address="Lorem ipsum dolor sit amet",
            tagLine="cuite pie"
        ),
        puppy(
            id = 3,
            name = "Puppy3",
            imageUrl = "https://source.unsplash.com/vRxRgiIZP4g",
            address="Lorem ipsum dolor sit amet",
            tagLine="cuite pie"
        ),
        puppy(
            id = 4,
            name = "Puppy4",
            imageUrl = "https://source.unsplash.com/rssC3bQr0x8",
            address="Lorem ipsum dolor sit amet",
            tagLine="cuite pie"
        ),
        puppy(
            id = 5,
            name = "Puppy5",
            imageUrl = "https://source.unsplash.com/qO-PIF84Vxg",
            address="Lorem ipsum dolor sit amet",
            tagLine="cuite pie"
        ),
        puppy(
            id = 6,
            name = "Puppy6",
            imageUrl = "https://source.unsplash.com/5yAhL8ViUVg",
            address="Lorem ipsum dolor sit amet",
            tagLine="cuite pie"
        ),
        puppy(
            id = 7,
            name = "Puppy7",
            imageUrl = "https://source.unsplash.com/tVdxF-6bu7c",
            address="Lorem ipsum dolor sit amet",
            tagLine="cuite pie"
        ),
        puppy(
            id = 8,
            name = "Puppy8",
            imageUrl = "https://source.unsplash.com/tFGtvNWtnMQ",
            address="Lorem ipsum dolor sit amet",
            tagLine="cuite pie"
        ),
        puppy(
            id = 9,
            name = "Puppy9",
            imageUrl = "https://source.unsplash.com/BrtCGcrZd10",
            address="Lorem ipsum dolor sit amet",
            tagLine="cuite pie"
        ),
        puppy(
            id = 10,
            name = "Puppy10",
            imageUrl = "https://source.unsplash.com/atOlntWcO4k",
            address="Lorem ipsum dolor sit amet",
            tagLine="cuite pie"
        ),
        puppy(
            id = 11,
            name = "Puppy11",
            imageUrl = "https://source.unsplash.com/9LkqymZFLrE",
            address="Lorem ipsum dolor sit amet",
            tagLine="cuite pie"
        ),
        puppy(
            id = 12,
            name = "Puppy12",
            imageUrl = "https://source.unsplash.com/sVtcRzphxbk",
            address="Lorem ipsum dolor sit amet",
            tagLine="cuite pie"
        ),
        puppy(
            id = 13,
            name = "Puppy13",
            imageUrl = "https://source.unsplash.com/rO7GI3z2rb8",
            address="Lorem ipsum dolor sit amet",
            tagLine="cuite pie"
        ),
        puppy(
            id = 14,
            name = "Puppy14",
            imageUrl = "https://source.unsplash.com/jJmbkcj7HXg",
            address="Lorem ipsum dolor sit amet",
            tagLine="cuite pie"
        ),
        puppy(
            id = 15,
            name = "Puppy15",
            imageUrl = "https://source.unsplash.com/XFwj5LEVvMI",
            address="Lorem ipsum dolor sit amet",
            tagLine="cuite pie"
        ),
        puppy(
            id = 16,
            name = "Puppy16",
            imageUrl = "https://source.unsplash.com/QAU0vNzlEOU",
            address="Lorem ipsum dolor sit amet",
            tagLine="cuite pie"
        ),
        puppy(
            id = 17,
            name = "Puppy17",
            imageUrl = "https://source.unsplash.com/6ADdVn9yK9U",
            address="Lorem ipsum dolor sit amet",
            tagLine="cuite pie"
        ),
        puppy(
            id = 18,
            name = "Puppy18",
            imageUrl = "https://source.unsplash.com/n4ZnguY391E",
            address="Lorem ipsum dolor sit amet",
            tagLine="cuite pie"

        ),
        puppy(
            id = 19,
            name = "Puppy19",
            imageUrl = "https://source.unsplash.com/U8pgck1dgtQ",
            address="Lorem ipsum dolor sit amet",
            tagLine="cuite pie"
        )
    )

    @Immutable
    data class puppy(
        val id: Long,
        val name: String,
        val imageUrl: String,
        val address:String,
        val tagLine:String

    )

    fun getPuppies(): List<puppy> = puppyCollection
    fun getPuppy(puppyId: Long) = puppyCollection.find { it.id == puppyId }!!
}
