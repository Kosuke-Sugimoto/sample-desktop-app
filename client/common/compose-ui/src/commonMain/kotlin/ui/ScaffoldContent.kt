package me.sugimoto.sampleapp.ui

import androidx.compose.runtime.Composable
import me.sugimoto.sampleapp.Sections
import me.sugimoto.sampleapp.ui.home.HomeContent
import me.sugimoto.sampleapp.ui.login.LoginContent
import me.sugimoto.sampleapp.ui.register.RegisterContent

@Composable
fun ScaffoldContent(
    appState: MppAppState
) {
    when(appState.currentRoute) {
        Sections.HOME.route -> {
            HomeContent()
        }

        Sections.LOGIN.route -> {
            LoginContent()
        }

        Sections.REGISTER.route -> {
            RegisterContent()
        }
    }
}
