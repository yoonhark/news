package com.harkhark.core.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PreferenceDataSource @Inject constructor(
    private val prefDataStore: DataStore<Preferences>,
) {
    private val nameKey = stringPreferencesKey("name")
    private val ageKey = intPreferencesKey("age")

    suspend fun setName(name: String) {
        prefDataStore.edit { pref -> pref[nameKey] = name }
    }

    suspend fun setAge(age: Int) {
        prefDataStore.edit { pref -> pref[ageKey] = age }
    }

    suspend fun getName(): String = prefDataStore.data.map { pref -> pref[nameKey] ?: "" }.first()

    suspend fun getInt(): Int = prefDataStore.data.map { pref -> pref[ageKey] ?: 0 }.first()
}