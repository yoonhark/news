package com.harkhark.core.common.config

import com.harkhark.core.common.config.ApplicationConfig

interface AppConfigProvider {
    fun get(): ApplicationConfig
}

