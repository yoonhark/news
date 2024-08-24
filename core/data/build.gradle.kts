plugins {
    alias(libs.plugins.harkhark.android.library)
    alias(libs.plugins.harkhark.android.hilt)
}

android {
    namespace = "com.harkhark.core.data"
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:domain"))
    implementation(project(":core:database"))
    implementation(project(":core:datastore"))
}