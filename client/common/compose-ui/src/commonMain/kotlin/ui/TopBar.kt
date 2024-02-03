package me.sugimoto.sampleapp.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import me.sugimoto.sampleapp.MppResource
import me.sugimoto.sampleapp.mypage_button
import me.sugimoto.sampleapp.stringResource
import me.sugimoto.sampleapp.title
import me.sugimoto.sampleapp.ui.theme.JetsnackTheme
import me.sugimoto.sampleapp.ui.theme.Shapes

@Composable
fun MyTopBar(
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Text(
                stringResource(MppResource.string.title),
                color = JetsnackTheme.colors.textPrimary,
                // こだわるなら style 指定
            )
        },
        actions = {
            TopBarButtonBox(
                onClick = { println("hey") }
            ) { Text(stringResource(MppResource.string.mypage_button)) }
        },
        backgroundColor = JetsnackTheme.colors.uiFloated,
        contentColor = JetsnackTheme.colors.textPrimary,
        elevation = 0.dp
    )
}

@Composable
fun TopBarButtonBox(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxHeight(2f/3f)
            .clip(Shapes.medium)
            .background(
                color = JetsnackTheme.colors.iconPrimary,
                shape = Shapes.medium
            )
            .border(
                BorderStroke(
                    width = 2.dp,
                    color = JetsnackTheme.colors.uiBorder
                )
            )
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(
                    bounded = true,
                    color = Color.Magenta // for Debug
                ),
                onClick = { onClick() }
            )
            .padding(horizontal = 5.dp)
    ) {
        content()
    }
}
