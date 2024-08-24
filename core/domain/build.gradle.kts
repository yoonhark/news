plugins {
    alias(libs.plugins.harkhark.android.library)
    alias(libs.plugins.harkhark.android.hilt)
}

android {
    namespace = "com.harkhark.core.domain"
}

dependencies {
    implementation(project(":core:common"))
}