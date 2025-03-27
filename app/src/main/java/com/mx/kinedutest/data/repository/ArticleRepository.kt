package com.mx.kinedutest.data.repository

import android.util.Log
import com.mx.kinedutest.data.remote.ApiService
import com.mx.kinedutest.domain.model.Article
import javax.inject.Inject

class ArticleRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getArticles(): Result<List<Article>> {
        return try {
            val response = apiService.getArticles()
            Log.d("API_CALL", "URL: ${response.raw()}")
            Log.d("API_CALL", "Response Code: ${response.code()}")
            Log.d("API_CALL", "Response Body: ${response.body()}")
            if (response.isSuccessful) {
                response.body()?.let {
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
}