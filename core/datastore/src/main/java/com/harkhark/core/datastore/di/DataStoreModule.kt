package com.harkhark.core.datastore.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.harkhark.core.common.network.di.ApplicationScope
import com.harkhark.core.common.network.di.IoDispatcher
import com.harkhark.core.datastore.ProtoPreferences
import com.harkhark.core.datastore.serializer.UserPreferencesSerializer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {
    private const val PROTO_DATASTORE = "proto_datastore.pb"
    private const val PREFERENCES_DATASTORE = "preferences_datastore"

    @Provides
    @Singleton
    internal fun providesProtoPreferencesDataStore(
        @ApplicationContext context: Context,
        @IoDispatcher ioDispatcher: CoroutineDispatcher,
        @ApplicationScope scope: CoroutineScope,
        userPreferencesSerializer: UserPreferencesSerializer,
    ): DataStore<ProtoPreferences> =
        DataStoreFactory.create(
            serializer = userPreferencesSerializer,
            scope = CoroutineScope(scope.coroutineContext + ioDispatcher),
            migrations = listOf(
                //TODO migration
//                IntToStringIdsMigration,
            ),
        ) {
            context.dataStoreFile(PROTO_DATASTORE)
        }


    /**
     * Preference Datastore 사용
     */
    @Provides
    @Singleton
    fun providePreferenceDataStore(@ApplicationContext context: Context): DataStore<Preferences> {
        return PreferenceDataStoreFactory.create(
            produceFile = { context.preferencesDataStoreFile(PREFERENCES_DATASTORE) }
        )
    }
}