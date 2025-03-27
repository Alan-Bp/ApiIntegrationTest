import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mx.kinedutest.R
import com.mx.kinedutest.domain.model.Article
import com.mx.kinedutest.domain.model.ArticleData
import com.mx.kinedutest.presentation.viewmodel.DetailViewModel
import kotlin.reflect.full.memberProperties


@Composable
fun DetailScreen(
    productId: String,
    navController: NavController,
    viewModel: DetailViewModel = hiltViewModel()
) {
    LaunchedEffect(productId) {
        viewModel.getArticleById(productId)
    }

    val article by viewModel.article.collectAsState()

    Scaffold { innerPadding ->
        article?.let { product ->
            DetailContent(product, innerPadding)
        }
    }
}

@Composable
fun DetailContent(product: Article, innerPadding: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.shoping_phone),
                contentDescription = product.name,
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp)
            )
            Text(
                text = product.name,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp)
                    .align(Alignment.CenterVertically)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = "Characteristics:",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(8.dp))

            product.data?.let { data ->
                val details = getArticleDataMap(data)
                details.forEach { (key, value) ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    ) {
                        Text(
                            text = "$key:",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Gray,
                            modifier = Modifier.weight(1f)
                        )
                        Text(
                            text = value,
                            fontSize = 16.sp,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            } ?: Text(
                text = "No hay información disponible.",
                fontSize = 16.sp,
                color = Color.Gray
            )
        }
    }
}

fun getArticleDataMap(articleData: ArticleData): Map<String, String> {
    return ArticleData::class.memberProperties
        .mapNotNull { prop ->
            val value = prop.get(articleData)?.toString()
            value?.let { prop.name to it }
        }
        .toMap()
}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    val navController = rememberNavController()
    val sampleProduct = Article(
        id = "1",
        name = "Google Pixel 6 Pro",
        data = ArticleData(
            color = "Cloudy White",
            capacity = "128 GB",
            price = 699.99
        )
    )

    Scaffold {
        DetailContent(sampleProduct, it)
    }
}