package me.sugimoto.sampleapp.ui.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import me.sugimoto.sampleapp.ui.theme.JetsnackTheme

@Composable
fun MyTextField(
    modifier: Modifier = Modifier
) {
    // 日本語を入力したとき、高さが足りずに描画されていない
    // TODO：後々修正
    // TODO：textはここでrememberしているが上の階層(入力されたテキストを使う階層)で定義した方が良い

    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        modifier = modifier.padding(start = 5.dp),
        leadingIcon = {
            Icon(
                Icons.Outlined.Search,
                tint = JetsnackTheme.colors.textPrimary, // 本来ならiconPrimaryが良いが色が被っているので応急処置
                contentDescription = "Search"
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = JetsnackTheme.colors.textPrimary,
            backgroundColor = JetsnackTheme.colors.uiBackground,
            cursorColor = JetsnackTheme.colors.textPrimary,
            leadingIconColor = JetsnackTheme.colors.textPrimary,
            focusedBorderColor = JetsnackTheme.colors.textPrimary,
            unfocusedBorderColor = JetsnackTheme.colors.uiFloated
        )
    )
}
