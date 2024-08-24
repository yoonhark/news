plugins {
    alias(libs.plugins.harkhark.android.library)
    alias(libs.plugins.harkhark.android.hilt)
    alias(libs.plugins.harkhark.android.room)
}

android {
    namespace = "com.harkhark.core.database"
}

dependencies {
    implementation(libs.kotlinx.datetime)
}