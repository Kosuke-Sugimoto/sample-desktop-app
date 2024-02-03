package me.sugimoto.sampleapp

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import me.sugimoto.sampleapp.ui.MyTopBar
import me.sugimoto.sampleapp.ui.theme.JetsnackTheme

@Composable
fun App() {
    JetsnackTheme(darkTheme = false) {
        val appState = rememberMppRolePlayAppState()

        // TODO：要検討
        // アカウント登録の画面にもTopBarが必要なら通常通りScaffoldContentをここに書く
        // が必要ないなら、この時点でwhenを使った分岐による画面遷移を入れるべき

        Scaffold(
            topBar = { MyTopBar() },
            scaffoldState = appState.scaffoldState,
            backgroundColor = JetsnackTheme.colors.uiBackground
        ) {
            Text("sample")
        }
    }
}
