package me.sugimoto.sampleapp

fun buildStringResources(): Map<Int, String> {
    val strs = mutableMapOf<Int, String>()
    val rs = MppResource.string

    strs[rs.title] = "STORE MANAGER"
    strs[rs.mypage_button_dropdown1] = "マイページ"
    strs[rs.mypage_button_dropdown2] = "パスワード変更"
    strs[rs.mypage_button_dropdown3] = "利用規約"
    strs[rs.mypage_button_dropdown4] = "個人情報保護方針"
    strs[rs.mypage_button_dropdown5] = "ログアウト"
    strs[rs.view_mode_true] = "リスト"
    strs[rs.view_mode_false] = "地図"

    return strs
}
