package me.sugimoto.sampleapp.ui.components

import androidx.compose.animation.*
import androidx.compose.animation.core.TweenSpec
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toComposeImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import me.sugimoto.sampleapp.ui.theme.JetsnackTheme
import java.net.URL
import javax.imageio.ImageIO

private val imagesCache = mutableMapOf<String, ImageBitmap>()

@OptIn(ExperimentalAnimationApi::class)
@Composable
actual fun AsyncImage(
    imageUri: String,
    contentDescription: String?,
    modifier: Modifier
) {
    var img: ImageBitmap? by remember(imageUri) { mutableStateOf(null)}
    
    AnimatedContent(
        img,
        transitionSpec = {
            fadeIn(TweenSpec()) with fadeOut(TweenSpec())
        }
    ) {
        if(img != null) {
            Image(
                img!!,
                contentDescription = contentDescription,
                modifier = modifier,
                contentScale = ContentScale.Crop
            )
        } else {
            Text(
                "No Content",
                color = JetsnackTheme.colors.textPrimary,
                textAlign = TextAlign.Center,
                modifier = modifier
                    .fillMaxSize()
                    .background(color = JetsnackTheme.colors.uiBackground)
            )
        }
    }
    
    LaunchedEffect(imageUri) {
        if(imagesCache.contains(imageUri)) {
            img = imagesCache[imageUri]
        } else {
            withContext(Dispatchers.IO) {
                img = try {
                    ImageIO.read(URL(imageUri)).toComposeImageBitmap().also {
                        imagesCache[imageUri] = it
                        img = it
                    }
                } catch (e: Throwable) {
                    e.printStackTrace()
                    null
                }
            }
        }
    }
}
