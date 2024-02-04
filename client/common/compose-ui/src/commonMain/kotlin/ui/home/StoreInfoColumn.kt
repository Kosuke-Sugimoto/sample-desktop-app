package me.sugimoto.sampleapp.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import me.sugimoto.sampleapp.MppResource
import me.sugimoto.sampleapp.detail_button
import me.sugimoto.sampleapp.model.StoreInfo
import me.sugimoto.sampleapp.model.StoreRepo
import me.sugimoto.sampleapp.stringResource
import me.sugimoto.sampleapp.ui.components.MyImage
import me.sugimoto.sampleapp.ui.theme.JetsnackTheme

@Composable
fun ModeListStoreInfoColumn(

) {
    val stores = StoreRepo.getStores()

    LazyColumn(
        modifier = Modifier.fillMaxWidth(6f/11f),
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        itemsIndexed(stores) {_, store ->
            StoreInfoCard(
                storeInfo = store
            )
        }
    }
}

@Composable
fun ModeMapStoreInfoColumn(

) {
    Text("For Debug StoreInfo Column Map")
}

@Composable
fun StoreInfoCard(
    storeInfo: StoreInfo,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = Color.Cyan // JetsnackTheme.colors.brand
        // ここで modifier を指定し、paddingをしてもカード自体が持っていた範囲が狭まるのみ
        // カードの外形と中身の間に padding を入れたいなら下の Row で指定する必要アリ
    ) {
        Row(
            Modifier.padding(15.dp)
        ) {
            StoreInfoCardContent(
                storeInfo.name,
                storeInfo.address,
                storeInfo.memo
            )
            Spacer(Modifier.weight(1f))// .padding(horizontal = 20.dp))
            MyImage(
                storeInfo.imageUri,
                storeInfo.name,
                Modifier
                    // StoreInfoCardContent を描画した時点での残りのうち1/2みたいな意味合いのハズ
                    .fillMaxWidth(1f/2f)
                    .fillMaxHeight()
            )
        }
    }
}

@Composable
fun StoreInfoCardContent(
    name: String,
    address: String,
    memo: String
) {
    Column(
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            name,
            color = JetsnackTheme.colors.textPrimary
        )

        Text(
            "　　住所：${address}",
            color = JetsnackTheme.colors.textPrimary
        )

        Spacer(Modifier.padding(10.dp))

        Row {
            Text(
                stringResource(MppResource.string.detail_button),
                color = JetsnackTheme.colors.textPrimary,
                modifier = Modifier
                    .background(color = JetsnackTheme.colors.brand)
                    .padding(horizontal = 15.dp, vertical = 5.dp)
            )

            Spacer(Modifier.padding(horizontal = 10.dp))

            Text(
                "メモ：${memo}",
                color = JetsnackTheme.colors.textPrimary
            )
        }
    }
}
