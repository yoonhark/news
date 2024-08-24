package com.harkhark.core.network.di

import com.harkhark.core.network.api.SampleApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

/**
 * Api 정의
 */
@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Provides
    @Singleton
    fun provideSampleApi(retrofit: Retrofit): SampleApi = retrofit.create()
}