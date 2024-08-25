package com.harkhark.core.common.config

/**
 * 각 포듈에서 사용할 수 있도록 정의
 */
data class ApplicationConfig(
    val buildType: String,
    val versionCode: Int,
    val versionName: String,
)
