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
class DetailViewModel @Inject constructor(
    private val repository: ArticleRepository
) : ViewModel() {

    private val _article = MutableStateFlow<Article?>(null)
    val article: StateFlow<Article?> = _article

    fun getArticleById(articleId: String) {
        viewModelScope.launch {
            val result = repository.getArticles()
            if (result.isSuccess) {
                _article.value = result.getOrNull()?.find { it.id == articleId }
            }
        }
    }
}
