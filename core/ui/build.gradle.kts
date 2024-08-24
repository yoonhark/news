plugins {
    alias(libs.plugins.harkhark.android.library)
    alias(libs.plugins.harkhark.android.library.compose)
}

android {
    namespace = "com.harkhark.core.ui"

    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    api(project(":core:designsystem"))
    api(libs.androidx.navigation.fragment.ktx)
    api(libs.androidx.navigation.ui.ktx)

    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
}