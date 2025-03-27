package com.mx.kinedutest.data.repository

import android.util.Log
import com.mx.kinedutest.data.local.model.ArticleEntity
import com.mx.kinedutest.data.remote.ApiService
import com.mx.kinedutest.domain.model.Article
import com.mx.kinedutest.domain.model.ArticleData
import kotlinx.coroutines.flow.firstOrNull
import javax.inject.Inject

class ArticleRepository @Inject constructor(
    private val apiService: ApiService,
    private val dbRepository: DBRepository
) {
    suspend fun getArticles(): Result<List<Article>> {
        val localArticles =
            dbRepository.getAllArticles().firstOrNull()
        if (localArticles.isNullOrEmpty()) {
            return try {
                val response = apiService.getArticles()
                if (response.isSuccessful) {
                    response.body()?.let {
                        dbRepository.saveArticles(it.map { article ->
                            ArticleEntity(
                                id = article.id,
                                name = article.name,
                                description = article.data?.description,
                                color = article.data?.color,
                                capacity = article.data?.capacity,
                                price = article.data?.price,
                                generation = article.data?.generation,
                                year = article.data?.year,
                                cpuModel = article.data?.cpuModel,
                                hardDiskSize = article.data?.hardDiskSize,
                                strapColour = article.data?.strapColour,
                                caseSize = article.data?.caseSize,
                                screenSize = article.data?.screenSize
                            )
                        })
                        Result.success(it)
                    } ?: Result.failure(Exception("Empty response body"))
                } else {
                    Result.failure(Exception("Error response: ${response.message()}"))
                }
            } catch (e: Exception) {
                Log.e("API_CALL", "Exception: ${e.message}", e)
                Result.failure(e)
            }
        }
        return Result.success(localArticles.map { article ->
            Article(
                id = article.id,
                name = article.name,
                data = ArticleData(
                    description = article.description,
                    color = article.color,
                    capacity = article.capacity,
                    price = article.price,
                    generation = article.generation,
                    year = article.year,
                    cpuModel = article.cpuModel,
                    hardDiskSize = article.hardDiskSize,
                    strapColour = article.strapColour,
                    caseSize = article.caseSize,
                    screenSize = article.screenSize
                )
            )
        })
    }
}