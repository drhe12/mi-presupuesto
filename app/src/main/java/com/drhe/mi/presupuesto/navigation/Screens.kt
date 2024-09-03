package com.drhe.mi.presupuesto.navigation

import androidx.navigation.NavHostController
import com.drhe.mi.presupuesto.util.Action
import com.drhe.mi.presupuesto.util.Constants.HOME_SCREEN

class Screens(navController: NavHostController) {
    val home: (Action) -> Unit = { action ->
        navController.navigate("home/${action.name}") {
            popUpTo(HOME_SCREEN) { inclusive = true }
        }
    }

    val transaction: (Int) -> Unit = { transactionId ->
        navController.navigate("transaction/$transactionId")
    }
}