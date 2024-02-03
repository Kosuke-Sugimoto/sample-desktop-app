package me.sugimoto.sampleapp

import androidx.compose.runtime.Composable
import me.sugimoto.sampleapp.MppResource as MppR

// 基本的にこいつらが真のゲッターの役割を果たす
// プロパティに直接アクセスしても得られるのはIDのみ
// こいつらはそのIDを使って値を取得する
@Composable
expect fun stringResource(id: Int): String

@Composable
expect fun stringResource(id: Int, part: String): String

@Composable
expect fun stringResource(id: Int, count: Int): String

expect val MppR.string.title: Int

expect val MppR.string.mypage_button: Int
