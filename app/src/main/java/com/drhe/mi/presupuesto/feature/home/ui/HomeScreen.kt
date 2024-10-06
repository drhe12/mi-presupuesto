package com.drhe.mi.presupuesto.feature.home.ui

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.drhe.mi.presupuesto.feature.home.ui.components.HomeAppBar
import com.drhe.mi.presupuesto.feature.home.ui.components.HomeFab
import com.drhe.mi.presupuesto.feature.home.ui.components.content.HomeContent

@Composable
fun HomeScreen(
    navigateToTransactionScreen: (transactionId: Int) -> Unit
) {
    Scaffold(
        topBar = {
            HomeAppBar()
        },
        content = {
            HomeContent(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(
                        top = it.calculateTopPadding()
                    )
            )
        },
        floatingActionButton = {
            HomeFab(onFabClicked = navigateToTransactionScreen)
        }
    )
}

@Preview
@Composable
private fun ListScreenPreview() {
    HomeScreen(navigateToTransactionScreen = {})
}