package com.harkhark.core.data.di

import com.harkhark.core.data.datasource.NewsLocalDataSource
import com.harkhark.core.data.datasource.NewsLocalDataSourceImpl
import com.harkhark.core.data.datasource.NewsRemoteDataSource
import com.harkhark.core.data.datasource.NewsRemoteDataSourceImpl
import com.harkhark.core.data.repository.NewsRepositoryImpl
import com.harkhark.core.database.dao.NewsDao
import com.harkhark.core.domain.repository.NewsRepository
import com.harkhark.core.network.api.NewsApi
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindNewsRepository(newsRepositoryImpl: NewsRepositoryImpl): NewsRepository
}

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideLocalDataSource(newsDao: NewsDao): NewsLocalDataSource {
        return NewsLocalDataSourceImpl(newsDao)
    }

    @Provides
    @Singleton
    fun provideRemoteDataSource(newsApi: NewsApi): NewsRemoteDataSource {
        return NewsRemoteDataSourceImpl(newsApi)
    }
}



