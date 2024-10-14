package com.drhe.mi.presupuesto.feature.home.ui

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.drhe.mi.presupuesto.feature.home.ui.components.HomeAppBar
import com.drhe.mi.presupuesto.feature.home.ui.components.HomeFab
import com.drhe.mi.presupuesto.feature.home.ui.components.content.HomeContent
import com.drhe.mi.presupuesto.ui.viewmodels.SharedViewModel

@Composable
fun HomeScreen(
    navigateToTransactionScreen: (transactionId: Int) -> Unit,
    sharedViewModel: SharedViewModel
) {
    LaunchedEffect(key1 = true) {
        sharedViewModel.getAllTransactions()
    }
    val transactions by sharedViewModel.allTransactions.collectAsState()

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
                    ),
                transactions = transactions,
                navigateToTransactionScreen = navigateToTransactionScreen
            )
        },
        floatingActionButton = {
            HomeFab(onFabClicked = navigateToTransactionScreen)
        }
    )
}