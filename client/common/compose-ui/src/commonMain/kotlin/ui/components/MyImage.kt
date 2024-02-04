package me.sugimoto.sampleapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import me.sugimoto.sampleapp.ui.theme.JetsnackColors
import me.sugimoto.sampleapp.ui.theme.JetsnackTheme

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
        AsyncImage(imageUri, contentDescription, modifier.fillMaxSize())
    }
}

@Composable
expect fun AsyncImage(
    imageUri: String,
    contentDescription: String?,
    modifier: Modifier
)
