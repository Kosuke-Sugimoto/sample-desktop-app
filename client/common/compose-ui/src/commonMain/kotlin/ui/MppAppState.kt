package me.sugimoto.sampleapp.ui

import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable

@Composable
expect fun rememberMppAppState(): MppAppState

@Stable
expect class MppAppState {
    val scaffoldState: ScaffoldState
    val currentRoute: String?

    fun navigateToRoute(route: String)
}
