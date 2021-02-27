package com.example.androiddevchallenge

import android.os.Parcelable
import androidx.compose.runtime.Immutable
import kotlinx.parcelize.Parcelize

/**
 * Models the screens in the app and any arguments they require.
 */
sealed class Destination : Parcelable {
    @Parcelize
    object Home : Destination()

    @Immutable
    @Parcelize
    data class PuppyDetail(val puppyId: Long) : Destination()
}

/**
 * Models the navigation actions in the app.
 */
class Actions(navigator: Navigator<Destination>) {
    val selectPuppy: (Long) -> Unit = { puppyId: Long ->
        navigator.navigate(Destination.PuppyDetail(puppyId))
    }
    val upPress: () -> Unit = {
        navigator.back()
    }
}
