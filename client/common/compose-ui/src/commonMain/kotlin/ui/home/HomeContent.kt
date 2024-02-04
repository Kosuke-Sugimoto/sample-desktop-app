package me.sugimoto.sampleapp.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import javax.swing.text.View

@Composable
fun HomeContent(
) {
    var isListMode by remember { mutableStateOf(true) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.weight(1f)
        ) {
            // MyTextFieldがRowの範囲内にもつ自身の範囲はCenterVerticallyによって中央になっている
            // そのため、画面端とTextField、TopBarとTextFieldの幅を揃えたいならalignmentは消して手動でpaddingしなきゃ
            MyTextField(
                Modifier
                    .fillMaxHeight(3f/4f)
                    .fillMaxWidth(1f/4f)
            )
            Spacer(Modifier.weight(1f))
            ViewModeChanger(
                isListMode = isListMode,
                onListMode = { isListMode = it }
            )
            Spacer(Modifier.weight(8f))
        }

        Row(
            modifier = Modifier.weight(10f)
        ) {
            Spacer(Modifier.weight(3f))
            StoreInfoColumn()
            Spacer(Modifier.weight(2f))
            CategoryColumn()
            Spacer(Modifier.weight(1f))
        }
    }
}
