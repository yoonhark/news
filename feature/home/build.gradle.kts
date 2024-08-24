plugins {
    alias(libs.plugins.harkhark.android.library.compose)
    alias(libs.plugins.harkhark.android.feature)
}

android {
    namespace = "com.harkhark.feature.home"
}

dependencies {
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
}