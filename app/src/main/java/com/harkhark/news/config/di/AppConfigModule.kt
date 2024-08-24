package com.harkhark.news.config.di

import com.harkhark.core.common.config.AppConfigProvider
import com.harkhark.news.config.ApplicationConfigProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppConfigModule {
    @Provides
    fun provideApplicationConfig(appConfigProvider: ApplicationConfigProvider): AppConfigProvider = appConfigProvider
}