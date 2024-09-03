package com.drhe.mi.presupuesto.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.drhe.mi.presupuesto.util.Action
import com.drhe.mi.presupuesto.util.Constants.TRANSACTION_ARGUMENT_KEY
import com.drhe.mi.presupuesto.util.Constants.TRANSACTION_SCREEN

fun NavGraphBuilder.transactionComposable(
    navigateToListScreen: (Action) -> Unit
) {
    composable(
        route = TRANSACTION_SCREEN,
        arguments = listOf(
            navArgument(TRANSACTION_ARGUMENT_KEY) {
                type = NavType.IntType
            }
        )
    ) {

    }
}