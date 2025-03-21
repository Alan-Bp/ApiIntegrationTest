package com.mx.kinedutest.presentation.view.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mx.kinedutest.R


@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            TopAppBarCustom()
        },
        content = { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)) {
                ProductGrid(products = sampleProducts)
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}

data class Product(val name: String, val description: String, val imageRes: Int)

// TODO: Remover mock!!
val sampleProducts = List(10) {
    Product(
        "Producto ${it + 1}",
        "Descripción corta del producto",
        R.drawable.shoping_phone
    )
}