package com.mx.kinedutest.data.di

import android.content.Context
import com.mx.kinedutest.data.core.Constants
import com.mx.kinedutest.data.local.dao.ArticleDao
import com.mx.kinedutest.data.local.database.AppDatabase
import com.mx.kinedutest.data.remote.ApiService
import com.mx.kinedutest.data.repository.ArticleRepository
import com.mx.kinedutest.data.repository.DBRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideArticleRepository(
        apiService: ApiService,
        dbRepository: DBRepository
    ): ArticleRepository {
        return ArticleRepository(apiService, dbRepository)
    }

    @Provides
    fun provideDBRepository(articleDao: ArticleDao): DBRepository {
        return DBRepository(articleDao)
    }

    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideArticleDao(database: AppDatabase): ArticleDao {
        return database.articleDao()
    }

    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }

    @Provides
    fun provideContext(@ApplicationContext context: Context): Context {
        return context
    }
}

