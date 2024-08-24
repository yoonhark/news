package com.harkhark.core.domain.usecase

import com.harkhark.core.domain.repository.SampleRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSampleUseCase @Inject constructor(
    private val sampleRepository: SampleRepository
){
    suspend operator fun invoke(): Flow<String> {
        return sampleRepository.getSample()
    }
}