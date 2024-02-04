package me.sugimoto.sampleapp.model

import androidx.compose.runtime.Immutable

object CategoryRepo {
    fun getCategories(): List<StoreCategory> = listOf(
        template, template1, template2
    )

    fun getCategories(ids: List<Long>): List<StoreCategory> = listOf(
        template, template1, template2
    ).filter { it.id in ids }
}

private val template = StoreCategory(
    id = 0,
    category = "喫茶店",
    subCategories = listOf("プリン", "コーヒー")
)

@Immutable
data class StoreCategory(
    val id: Long,
    val category: String,
    val subCategories: List<String>
)

private val template1 = template.copy(
    id = 1,
    category = "自宅",
    subCategories = listOf("家庭の味", "カルボナーラ")
)

private val template2 = template.copy(
    id = 2,
    category = "休憩所",
    subCategories = listOf("コスパ", "創作料理")
)
