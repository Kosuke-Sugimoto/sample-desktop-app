package me.sugimoto.sampleapp.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import me.sugimoto.sampleapp.MppResource
import me.sugimoto.sampleapp.stringResource
import me.sugimoto.sampleapp.ui.theme.JetsnackTheme
import me.sugimoto.sampleapp.view_mode_false
import me.sugimoto.sampleapp.view_mode_true

@Composable
fun ViewModeChanger(
    isListMode: Boolean,
    onListMode: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    val listModeColor = if(isListMode) JetsnackTheme.colors.textLink else JetsnackTheme.colors.brandSecondary
    val mapModeColor = if(!isListMode) JetsnackTheme.colors.textLink else JetsnackTheme.colors.brandSecondary

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .background(color = listModeColor)
                .clickable(onClick = { onListMode(true) })
        ) {
            Text(
                stringResource(MppResource.string.view_mode_true)
            )
        }

        Box(
            modifier = Modifier
                .background(color = mapModeColor)
                .clickable(onClick = { onListMode(false) })
        ) {
            Text(
                stringResource(MppResource.string.view_mode_false)
            )
        }
    }
}
