package com.harkhark.news.config.di

import com.harkhark.core.common.config.AppConfigProvider
import com.harkhark.news.config.ApplicationConfigProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppConfigModule {
    @Provides
    @Singleton
    fun provideApplicationConfig(appConfigProvider: ApplicationConfigProvider): AppConfigProvider = appConfigProvider
}