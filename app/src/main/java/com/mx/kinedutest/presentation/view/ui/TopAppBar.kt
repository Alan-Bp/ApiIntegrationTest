package com.mx.kinedutest.presentation.view.ui

import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mx.kinedutest.R
import com.mx.kinedutest.presentation.viewmodel.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarCustom(viewModel: HomeViewModel) {
    MediumTopAppBar(
        title = { },
        actions = {
            SearchBar(viewModel = viewModel)
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = colorResource(id = R.color.kin_blue),
            scrolledContainerColor = MaterialTheme.colorScheme.surface
        ),
        modifier = Modifier
            .height(115.dp)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun TopAppBarPreview() {
    MediumTopAppBar(
        title = { },
        actions = { SearchBar(viewModel = viewModel()) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = colorResource(id = R.color.kin_blue),
            scrolledContainerColor = MaterialTheme.colorScheme.surface
        ),
        modifier = Modifier.height(90.dp)
    )
}