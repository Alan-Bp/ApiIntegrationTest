package com.mx.kinedutest.data.repository

import com.mx.kinedutest.data.local.dao.ArticleDao
import com.mx.kinedutest.data.local.model.ArticleEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DBRepository @Inject constructor(private val articleDao: ArticleDao) {
    fun getAllArticles(): Flow<List<ArticleEntity>> = articleDao.getAllArticles()
    suspend fun saveArticles(articles: List<ArticleEntity>) {
        articleDao.insertArticles(articles)
    }
}