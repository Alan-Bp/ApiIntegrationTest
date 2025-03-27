package com.mx.kinedutest.presentation.view.navigation

import DetailScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mx.kinedutest.presentation.view.ui.HomeScreen
import com.mx.kinedutest.presentation.viewmodel.HomeViewModel

@Composable
fun NavigationGraph(navController: NavHostController, homeViewModel: HomeViewModel) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController, homeViewModel)
        }
        composable("details/{productId}") { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId") ?: ""
            DetailScreen(productId, navController)
        }
    }
}
