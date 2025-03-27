package com.mx.kinedutest.presentation.view.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mx.kinedutest.domain.model.Article
import com.mx.kinedutest.domain.model.ArticleData

@Composable
fun ProductGrid(articles: List<Article>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(articles) { article ->
            ProductCard(product = article)
        }
    }
}

/**
 * este sample es para fines de diseño y poderlo ver en
 * Preview
 */
val sampleArticles = listOf(
    Article(
        id = "1",
        name = "Apple iPhone 12 Mini, 256GB, Blue",
        data = ArticleData(description = "Small but powerful, 256GB storage!")
    ),
    Article(
        id = "2",
        name = "Samsung Galaxy Z Fold2",
        data = ArticleData(description = "Innovative foldable screen, cutting-edge technology.")
    )
)

@Preview(showBackground = true)
@Composable
fun ProductGridPreview() {
    ProductGrid(articles = sampleArticles)
}