package com.drhe.mi.presupuesto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.drhe.mi.presupuesto.navigation.SetupNavigation
import com.drhe.mi.presupuesto.ui.theme.MiPresupuestoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiPresupuestoTheme {
                navController = rememberNavController()
                SetupNavigation(navController = navController)
            }
        }
    }
}