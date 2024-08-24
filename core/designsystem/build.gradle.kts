plugins {
    alias(libs.plugins.harkhark.android.library)
    alias(libs.plugins.harkhark.android.library.compose)
}

android {
    namespace = "com.harkhark.core.designsystem"
}

dependencies {

    api(libs.androidx.compose.foundation)
    api(libs.androidx.compose.foundation.layout)
    api(libs.androidx.compose.material.iconsExtended)
    api(libs.androidx.compose.material3)
    api(libs.androidx.compose.runtime)
    api(libs.androidx.compose.ui.util)
    implementation(libs.androidx.core)

}