package com.harkhark.core.network.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Qualifier
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val TIME_OUT = 10L

    @Provides
    @Singleton
    fun providesNetworkJson(): Json = Json {
        ignoreUnknownKeys = true
    }

    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val logger = HttpLoggingInterceptor.Logger { message -> Timber.tag("okHttp").d(message) }
        return HttpLoggingInterceptor(logger)
            .setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class DefaultInterceptorHttpClient
    @DefaultInterceptorHttpClient
    @Provides
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
            .readTimeout(TIME_OUT, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .addNetworkInterceptor {
                it.proceed(
                    it.request().newBuilder()
                        .addHeader("Accept", "application/json")
                        .build()
                )
            }
            .build()
    }
}
