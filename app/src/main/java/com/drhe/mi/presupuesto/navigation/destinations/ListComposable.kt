package com.drhe.mi.presupuesto.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.drhe.mi.presupuesto.feature.home.ui.HomeScreen
import com.drhe.mi.presupuesto.util.Constants.LIST_ARGUMENT_KEY
import com.drhe.mi.presupuesto.util.Constants.HOME_SCREEN

fun NavGraphBuilder.homeComposable(
    navigateToTransactionScreen: (Int) -> Unit
) {
    composable(
        route = HOME_SCREEN,
        arguments = listOf(
            navArgument(LIST_ARGUMENT_KEY) {
                type = NavType.StringType
            }
        )
    ) {
        HomeScreen(navigateToTransactionScreen = navigateToTransactionScreen)
    }
}