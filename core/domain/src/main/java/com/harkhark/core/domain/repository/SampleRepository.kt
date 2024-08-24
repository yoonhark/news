package com.harkhark.core.domain.repository

import kotlinx.coroutines.flow.Flow

interface SampleRepository {
   suspend fun getSample():Flow<String>
}