package me.sugimoto.sampleapp.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun MyImage(
    imageUri: String,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    elevation: Dp = 0.dp
) {
    Surface(
        elevation = elevation
    ) {
        AsyncImage(imageUri, contentDescription, Modifier.fillMaxSize())
    }
}

@Composable
expect fun AsyncImage(
    imageUri: String,
    contentDescription: String?,
    modifier: Modifier
)
