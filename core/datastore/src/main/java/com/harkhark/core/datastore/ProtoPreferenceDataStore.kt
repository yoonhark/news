package com.harkhark.core.datastore

import androidx.datastore.core.DataStore
import javax.inject.Inject

class ProtoPreferenceDataStore @Inject constructor(
    private val protoDataStore: DataStore<ProtoPreferences>,
) {
    private val protoPrefData = protoDataStore.data
}