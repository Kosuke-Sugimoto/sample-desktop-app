package me.sugimoto.sampleapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import org.jetbrains.skiko.currentNanoTime
import me.sugimoto.sampleapp.MppResource as MppR

// compositionLocalOfは初期値を必要とするため、emptyMapにて仮に与える
// 後々、providesによってちゃんとした初期値を与える
// これによりプロジェクトの柔軟性が上がる
// compositionLocalOfでの宣言で参照可能なのは同階層ディレクトリにあるスクリプトのみ
// ⇒ つまり、commonMainでは読み取れない
val strsLocal = compositionLocalOf { emptyMap<Int, String>() }

@Composable
actual fun stringResource(id: Int): String {
    return strsLocal.current[id] ?: "TODO"
}

// %1s, %1dはそれぞれフォーマット指定子(プレースホルダー)
// '1'は最初の引数を表す
// 例："sample %1s, %2d".format("foo", 2)

// Usage
// pluralsにする必要がないが、表示される文字列を状況によって「少し」変えたいとき
@Composable
actual fun stringResource(id: Int, part: String): String {
    return strsLocal.current[id]?.replace("%1s", part) ?: "TODO"
}

// Usage
// pluralsにする必要はないが、表示される数字を変えたいとき
// 例："~個買いました"という文章は固定だが、個数は状況によって変わる
@Composable
actual fun stringResource(id: Int, count: Int): String {
    return strsLocal.current[id]?.replace("%1d", count.toString()) ?: "TODO"
}

// 実行ごとに可変で一意なIDを定義
private var lastId = currentNanoTime().toInt()

private var _title = lastId++
actual val MppR.string.title: Int get() = _title

private val _mypage_button = lastId++
actual val MppR.string.mypage_button: Int get() = _mypage_button
