package com.harkhark.core.network.api

import com.harkhark.core.network.model.SampleResponse
import retrofit2.http.GET

interface SampleApi {
    @GET("domain/sample")
    suspend fun getSample(): SampleResponse
}