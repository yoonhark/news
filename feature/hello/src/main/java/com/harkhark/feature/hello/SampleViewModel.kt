package com.harkhark.feature.hello

import com.harkhark.core.domain.usecase.GetSampleUseCase
import com.harkhark.core.ui.BaseViewModel
import javax.inject.Inject

class SampleViewModel  @Inject constructor(
    private val getSampleUseCase: GetSampleUseCase
) : BaseViewModel() {

    var text:String? = null

    suspend fun initSample() {
        getSampleUseCase().collect{
            text = it
        }
    }
}