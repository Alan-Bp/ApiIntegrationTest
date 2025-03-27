package com.mx.kinedutest.presentation.view.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mx.kinedutest.presentation.viewmodel.HomeViewModel


@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {
    val products = viewModel.filteredProducts.collectAsState().value
    val isLoading = viewModel.isLoading.collectAsState().value
    val error = viewModel.error.collectAsState().value

    Scaffold(
        topBar = {
            TopAppBarCustom(viewModel)
        },
        content = { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)) {
                when {
                    isLoading -> LoadingIndicator()
                    error != null -> ErrorText(error)
                    else -> ProductGrid(articles = products)
                }
            }
        }
    )
}

@Composable
fun LoadingIndicator() {
    CircularProgressIndicator(modifier = Modifier.padding(16.dp))
}

@Composable
fun ErrorText(error: String?) {
    Text(
        text = error ?: "Unknown error",
        color = Color.Red,
        modifier = Modifier.padding(16.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
}