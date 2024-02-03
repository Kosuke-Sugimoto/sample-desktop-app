package me.sugimoto.sampleapp

import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable

// Mpp == Multi Platform Project
object MppResource {
    // string == string リソース
    // プロジェクト全体で利用する文字列リソースをここで管理
    // 例：ボタンに表示する文字
    object string {}

    // drawable == drawable リソース
    // プロジェクト内のグラフィック要素を管理するために利用
    // 例：ボタンの背景、アイコン
    object drawable {}

    // plurals == 複数形リソース
    // 特に数字に基づいて文字列が変化する場合に重宝
    // 例：カートの中身
    // 商品数 0 -> なにもありません
    // 商品数 1 -> 商品が1つあります
    // 商品数 2 -> 商品が2つあります
    // 商品数 3..4 -> 商品がいくつかあります
    // 商品数 5.. -> 商品が$NUM個あります
    // みたいに数字(個数)によって文字列表示を変えたい場合とかに便利
    object plurals {}
}

@Composable
expect fun rememberMppRolePlayAppState(): MppRolePlayAppState

@Stable
expect class MppRolePlayAppState {
    val scaffoldState: ScaffoldState
    val currentRoute: String?

    fun navigateToRoute(route: String)
}
