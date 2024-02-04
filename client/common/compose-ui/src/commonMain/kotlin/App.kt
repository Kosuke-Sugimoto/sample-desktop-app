package me.sugimoto.sampleapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import me.sugimoto.sampleapp.ui.MyTopBar
import me.sugimoto.sampleapp.ui.ScaffoldContent
import me.sugimoto.sampleapp.ui.rememberMppAppState
import me.sugimoto.sampleapp.ui.theme.JetsnackTheme

@Composable
fun App() {
    JetsnackTheme(darkTheme = false) {
        val appState = rememberMppAppState()

        // 画面全体でのクリックイベント監視
        // ここに置かないとScaffoldの中のみの判定になる気がする(多分)
        var isProfileExpand by remember { mutableStateOf(false) }
        if(isProfileExpand) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable(onClick = { isProfileExpand = false })
            )
        }

        // TODO：要検討
        // アカウント登録の画面にもTopBarが必要なら通常通りScaffoldContentをここに書く
        // が必要ないなら、この時点でwhenを使った分岐による画面遷移を入れるべき

        Scaffold(
            topBar = {
                 MyTopBar(
                     onTransition = { appState.navigateToRoute(it) },
                     isProfileExpand = isProfileExpand,
                     onProfileExpand = { isProfileExpand = it }
                 )
            },
            scaffoldState = appState.scaffoldState,
            backgroundColor = JetsnackTheme.colors.uiBackground
        ) {
            ScaffoldContent(
                appState = appState
            )
        }
    }
}
