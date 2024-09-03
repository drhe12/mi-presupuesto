package com.drhe.mi.presupuesto.feature.home.ui

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.drhe.mi.presupuesto.feature.home.ui.list.ListFab

@Composable
fun HomeScreen(
    navigateToTransactionScreen: (Int) -> Unit
) {
    Scaffold(
        content = {},
        floatingActionButton = {
            ListFab(onFabClicked = navigateToTransactionScreen)
        }
    )
}

@Preview
@Composable
private fun ListScreenPreview() {
    HomeScreen(navigateToTransactionScreen = {})
}