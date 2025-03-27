package com.mx.kinedutest.data.remote

import com.mx.kinedutest.domain.model.Article
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    // TODO: integrar mas funciones
    @GET("objects")
    suspend fun getArticles(): Response<List<Article>>
}