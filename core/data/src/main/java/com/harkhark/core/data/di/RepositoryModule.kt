package com.harkhark.core.data.di

import com.harkhark.core.data.repository.NewsRepositoryImpl
import com.harkhark.core.domain.repository.NewsRepository
import dagger.Binds
import dagger.Module
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