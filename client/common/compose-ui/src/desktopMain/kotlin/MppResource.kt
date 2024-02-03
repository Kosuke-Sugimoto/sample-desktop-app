package me.sugimoto.sampleapp

import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember

@Stable
actual class MppRolePlayAppState(
    actual val scaffoldState: ScaffoldState
) {
    private val navigationStack = NavigationStack(Sections.HOME.route)

    actual val currentRoute: String?
        get() = navigationStack.lastWithIndex().value

    actual fun navigateToRoute(route: String) {
        navigationStack.replaceBy(route)
    }
}

@Composable
actual fun rememberMppRolePlayAppState(): MppRolePlayAppState {
    // 本来ならこれ以外にも
    // snackbarManagerやcoroutineScopeなどがあるが、簡単のため省略
    val scaffoldState = rememberScaffoldState()

    return remember(scaffoldState) {
        MppRolePlayAppState(scaffoldState)
    }
}
