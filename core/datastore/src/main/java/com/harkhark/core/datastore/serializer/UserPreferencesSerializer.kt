package com.harkhark.core.datastore.serializer

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.google.protobuf.InvalidProtocolBufferException
import com.harkhark.core.datastore.ProtoPreferences
import java.io.InputStream
import java.io.OutputStream
import javax.inject.Inject

class UserPreferencesSerializer @Inject constructor() : Serializer<ProtoPreferences> {
    override val defaultValue: ProtoPreferences = ProtoPreferences.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): ProtoPreferences =
        try {
            // readFrom is already called on the data store background thread
            ProtoPreferences.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }

    override suspend fun writeTo(t: ProtoPreferences, output: OutputStream) {
        // writeTo is already called on the data store background thread
        t.writeTo(output)
    }
}
