package com.harkhark.news

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class NewsApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        Timber.plant(TimberTagRule())
    }
}

/**
 * Tag 생성 규칙
 * {className}:{methodName}
 */
class TimberTagRule : Timber.DebugTree() {
    override fun createStackElementTag(element: StackTraceElement): String {
        val simpleName = element.className.split(".").last()
        val methodName = element.methodName.split("$").first()
        return "${simpleName}:${methodName}"
    }
}