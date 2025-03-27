package com.mx.kinedutest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.mx.kinedutest.presentation.view.navigation.NavigationGraph
import com.mx.kinedutest.presentation.viewmodel.HomeViewModel
import com.mx.kinedutest.ui.theme.KineduTestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KineduTestTheme {
                val navController = rememberNavController()
                NavigationGraph(navController = navController, homeViewModel = homeViewModel)

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainActivityPreview() {
    val homeViewModel: HomeViewModel = viewModel()
    KineduTestTheme {
        val navController = rememberNavController()
        NavigationGraph(navController = navController, homeViewModel = homeViewModel)
    }
}
