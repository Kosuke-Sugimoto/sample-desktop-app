package me.sugimoto.sampleapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun AppEntryPoint() {
    CompositionLocalProvider(
        strsLocal provides buildStringResources()
    ) {
        App()
    }
}
