package me.sugimoto.sampleapp.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import me.sugimoto.sampleapp.MppResource
import me.sugimoto.sampleapp.category_tab
import me.sugimoto.sampleapp.model.CategoryRepo
import me.sugimoto.sampleapp.stringResource
import me.sugimoto.sampleapp.ui.DropdownMenuText
import me.sugimoto.sampleapp.ui.theme.JetsnackColors
import me.sugimoto.sampleapp.ui.theme.JetsnackTheme

@Composable
fun CategoryColumn(

) {
    val categories = CategoryRepo.getCategories()

    Column(
        modifier = Modifier
            .border(width = 1.dp, color = JetsnackTheme.colors.textPrimary)
//            .padding(horizontal = 20.dp, vertical = 10.dp)
    ) {
        Text(
            stringResource(MppResource.string.category_tab)
        )
        Divider(
            thickness = 1.dp,
            color = JetsnackTheme.colors.textPrimary,
            modifier = Modifier.widthIn(max = 150.dp)
        )

        LazyColumn(
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp)
//            modifier = Modifier
//                .border(width = 1.dp, color = JetsnackTheme.colors.textPrimary)
//                .padding(horizontal = 20.dp, vertical = 10.dp)
        ) {
            itemsIndexed(categories) { _, category ->
                var isClick by remember { mutableStateOf(false) }

                Text(
                    "${category.category}　${category.subCategories.size}",
                    color = JetsnackTheme.colors.textPrimary,
                    modifier = Modifier.clickable(onClick = { isClick = !isClick })
                )

                if(isClick) {
                    category.subCategories.forEach {
                        Text("　${it}", color = JetsnackTheme.colors.textPrimary)
                    }
                }
            }
        }
    }
}
