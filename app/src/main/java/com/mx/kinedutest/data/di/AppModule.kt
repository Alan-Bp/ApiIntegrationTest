package com.mx.kinedutest.data.di

import com.mx.kinedutest.data.remote.ApiService
import com.mx.kinedutest.data.remote.RetrofitClient
import com.mx.kinedutest.data.repository.ArticleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideArticleRepository(apiService: ApiService): ArticleRepository {
        return ArticleRepository(apiService)
    }

    @Provides
    fun provideApiService(): ApiService {
        return RetrofitClient.apiService
    }
}