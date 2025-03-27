package com.mx.kinedutest.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mx.kinedutest.data.repository.ArticleRepository
import com.mx.kinedutest.domain.model.Article
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: ArticleRepository
) : ViewModel() {

    private val _products = MutableStateFlow<List<Article>>(emptyList())
    val products: StateFlow<List<Article>> = _products

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    private val _filteredProducts = MutableStateFlow<List<Article>>(emptyList())
    val filteredProducts: StateFlow<List<Article>> = _filteredProducts

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery

    init {
        fetchProducts()
    }

    private fun fetchProducts() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            try {
                val result = repository.getArticles()
                if (result.isSuccess) {
                    _products.value = result.getOrNull() ?: emptyList()
                    _filteredProducts.value = _products.value
                } else {
                    _error.value = result.exceptionOrNull()?.message ?: "Unknown error"
                }
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
        filterProducts(query)
    }

    private fun filterProducts(query: String) {
        _filteredProducts.value = if (query.isEmpty()) {
            _products.value
        } else {
            _products.value.filter {
                it.name.contains(query, ignoreCase = true) || (it.data?.description?.contains(
                    query,
                    ignoreCase = true
                ) ?: false)
            }
        }
    }
}