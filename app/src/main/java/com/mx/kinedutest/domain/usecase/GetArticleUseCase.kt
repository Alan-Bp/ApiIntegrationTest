package com.mx.kinedutest.domain.usecase

import com.mx.kinedutest.data.repository.ArticleRepository
import com.mx.kinedutest.domain.model.Article
import javax.inject.Inject

class GetArticlesUseCase @Inject constructor(private val repository: ArticleRepository) {
    suspend fun execute(): Result<List<Article>> = repository.getArticles()
}