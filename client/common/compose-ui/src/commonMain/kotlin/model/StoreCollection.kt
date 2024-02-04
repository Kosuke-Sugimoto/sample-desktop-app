package me.sugimoto.sampleapp.model

import androidx.compose.runtime.Immutable

object StoreRepo {
    fun getStores(): List<StoreInfo> = listOf(
        template.copy(),
        template.copy(
            id = 1,
            name="安藤の家",
            category = CategoryRepo.getCategories(listOf(1)).single()
        ),
        template.copy(
            id = 2,
            name = "新見宅",
            category = CategoryRepo.getCategories(listOf(2)).single()
        ),
        template.copy(
            id = 3,
            name = "東京理科大学"
        ),
        template.copy(
            id = 4,
            name = "桂田亭"
        )
    )
}

private val template = StoreInfo(
    id = 0,
    name = "流山のカフェ",
    address = "千葉県流山市",
    budget = Pair(1000, 2000),
    category = CategoryRepo.getCategories(listOf(0)).single(),
    imageUri = "/path/to/img(URLでも可能)",
    memo = ""
)

@Immutable
data class StoreInfo(
    val id: Long,
    val name: String,
    val address: String,
    val budget: Pair<Int, Int>, // first: min, second: max
    val category: StoreCategory,
    val imageUri: String,
    val memo: String
)