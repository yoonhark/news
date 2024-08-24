plugins {
    alias(libs.plugins.harkhark.android.library)
    alias(libs.plugins.harkhark.android.hilt)
}

android {
    namespace = "com.harkhark.core.network"
}

dependencies {
    api(libs.kotlinx.datetime)
    api(project(":core:common"))

    api(libs.retrofit.core)
    api(libs.retrofit.kotlin.serialization)


    implementation(libs.coil.kt)
    implementation(libs.coil.kt.svg)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.okhttp.logging)
    implementation(libs.converter.gson)
}