package com.mx.kinedutest.presentation.view.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mx.kinedutest.R
import com.mx.kinedutest.domain.model.Article


@Composable
fun ProductCard(product: Article, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)
            .padding(8.dp)
            .clickable { navController.navigate("details/${product.id}") },
        elevation = CardDefaults.elevatedCardElevation(4.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.kin_yellow)
        ),
        border = BorderStroke(4.dp, colorResource(id = R.color.kin_green))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(id = R.drawable.shoping_phone),
                contentDescription = product.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(110.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = product.name, style = MaterialTheme.typography.titleMedium,
                maxLines = 2
            )
            Spacer(modifier = Modifier.height(2.dp))
            product.data?.description?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductCardPreview() {
}