package com.drhe.mi.presupuesto.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.drhe.mi.presupuesto.navigation.destinations.homeComposable
import com.drhe.mi.presupuesto.navigation.destinations.transactionComposable
import com.drhe.mi.presupuesto.ui.viewmodels.SharedViewModel
import com.drhe.mi.presupuesto.util.Constants.HOME_SCREEN

@Composable
fun SetupNavigation(
    navController: NavHostController,
    sharedViewModel: SharedViewModel
) {
    val screen = remember(navController) {
        Screens(navController = navController)
    }

    NavHost(
        navController = navController,
        startDestination = HOME_SCREEN
    ) {
        homeComposable(
            navigateToTransactionScreen = screen.transaction,
            sharedViewModel = sharedViewModel
        )
        transactionComposable(
            navigateToListScreen = screen.home
        )
    }
}