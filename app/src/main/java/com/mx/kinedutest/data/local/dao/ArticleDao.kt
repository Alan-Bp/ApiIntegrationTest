package com.mx.kinedutest.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mx.kinedutest.data.local.model.ArticleEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDao {
    @Insert
    suspend fun insertArticles(articles: List<ArticleEntity>)

    @Query("SELECT * FROM articles WHERE id = :id")
    fun getArticleById(id: String): Flow<ArticleEntity>

    @Query("SELECT * FROM articles")
    fun getAllArticles(): Flow<List<ArticleEntity>>
}