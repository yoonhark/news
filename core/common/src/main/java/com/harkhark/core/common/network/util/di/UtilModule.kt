package com.harkhark.core.common.network.util.di

import com.harkhark.core.common.network.util.ConnectivityManagerNetworkMonitor
import com.harkhark.core.common.network.util.NetworkMonitor
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface UtilModule {
    @Binds
    @Singleton
    fun bindsNetworkMonitor(
        networkMonitor: ConnectivityManagerNetworkMonitor,
    ): NetworkMonitor
}