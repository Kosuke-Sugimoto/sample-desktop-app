package me.sugimoto.sampleapp

fun buildStringResources(): Map<Int, String> {
    val strs = mutableMapOf<Int, String>()
    val rs = MppResource.string

    strs[rs.title] = "STORE MANAGER"
    strs[rs.mypage_button] = "My Page"

    return strs
}
