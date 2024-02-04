package me.sugimoto.sampleapp.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.sugimoto.sampleapp.*
import me.sugimoto.sampleapp.ui.theme.JetsnackTheme
import me.sugimoto.sampleapp.ui.theme.Shapes
import me.sugimoto.sampleapp.ui.theme.Typography

@Composable
fun MyTopBar(
    onTransition: (String) -> Unit,
    isProfileExpand: Boolean,
    onProfileExpand: (Boolean) -> Unit,
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
            TransitionButton(
                onTransition = onTransition
            )
            ProfileButton(
                isProfileExpand = isProfileExpand,
                onProfileExpand = onProfileExpand
            )
        },
        backgroundColor = JetsnackTheme.colors.uiFloated,
        contentColor = JetsnackTheme.colors.textPrimary,
        elevation = 0.dp
    )
}

// For Debug -> TransitionButton
@Composable
fun TransitionButton(
    onTransition: (String) -> Unit
) {
    var isPushed by remember { mutableStateOf(false) }

    TopBarButtonBox(
        onClick = { isPushed = true }
    ) {
        Text("画面遷移")
    }

    DropdownMenu(
        expanded = isPushed,
        onDismissRequest = { isPushed = false },
        modifier = Modifier
            .background(color = JetsnackTheme.colors.uiBackground)
    ) {
        DropdownMenuItem(onClick = { onTransition(Sections.HOME.route) }) {
            DropdownMenuText("HOME")
        }

        DropdownMenuItem(onClick = { onTransition(Sections.LOGIN.route) }) {
            DropdownMenuText("LOGIN")
        }

        DropdownMenuItem(onClick = { onTransition(Sections.REGISTER.route) }) {
            DropdownMenuText("REGISTER")
        }
    }
}

@Composable
fun ProfileButton(
    isProfileExpand: Boolean,
    onProfileExpand: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    // TODO
    // かなり若干ではあるが、カーブ部分にDebug用のMagentaの色が確認される
    // ⇒ 色を揃えて見えなくさせるか、見えないようにカーブを揃えるか
    TopBarButtonBox(
        onClick = { onProfileExpand(true) }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = modifier.fillMaxHeight()
        ) {
            Box {
                Icon(
                    Icons.Outlined.Person,
                    tint = JetsnackTheme.colors.textPrimary, // 本来ならiconPrimaryが良いが色が被っているので応急処置
                    contentDescription = "UserInformation",
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            Box {
                Text(
                    "UserName", // ここのユーザー名はユーザー情報からgetメソッドで取得したい
//                    style = Typography.button ここもこだわりたければ調整からの指定
                    lineHeight = 0.sp,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }

    // 何故かは覚えていないが、前の実装は下のものをBoxに入れていた
    // 恐らくDropdownMenuが全てTopBarのactionsの端に合わせて表示されることに対する対策
    // が、もう少し良い方法があるはずなので考えておく
    DropdownMenu(
        expanded = isProfileExpand,
        onDismissRequest = { onProfileExpand(false) },
        modifier = Modifier
            .background(color = JetsnackTheme.colors.uiBackground)
    ) {
        DropdownMenuItem(onClick = {}) {
            DropdownMenuText(stringResource(MppResource.string.mypage_button_dropdown1))
        }

        DropdownMenuItem(onClick = {}) {
            DropdownMenuText(stringResource(MppResource.string.mypage_button_dropdown2))
        }

        DropdownMenuItem(onClick = {}) {
            DropdownMenuText(stringResource(MppResource.string.mypage_button_dropdown3))
        }

        DropdownMenuItem(onClick = {}) {
            DropdownMenuText(stringResource(MppResource.string.mypage_button_dropdown4))
        }

        DropdownMenuItem(onClick = {}) {
            DropdownMenuText(stringResource(MppResource.string.mypage_button_dropdown5))
        }
    }
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

@Composable
fun DropdownMenuText(
    text: String,
    color: Color = JetsnackTheme.colors.textPrimary,
//    style: TextStyle = Typography.h5 こだわるなら調整したうえでこれを指定
    maxLines: Int = 1,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    modifier: Modifier = Modifier
) {
    Text(
        text,
        modifier = modifier,
        color = color,
//        style = style,
        maxLines = maxLines,
        overflow = overflow
    )
}
