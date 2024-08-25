plugins {
    alias(libs.plugins.harkhark.android.library)
    alias(libs.plugins.harkhark.android.hilt)
    id("kotlinx-serialization")
}

android {
    namespace = "com.harkhark.core.data"

    buildFeatures {
        buildConfig = true
    }

    defaultConfig {
        buildConfigField("String", "API_KEY", "\"0688b12abbc644ea883a2fba1a9e6960\"")
    }
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:domain"))
    implementation(project(":core:database"))
//    implementation(project(":core:datastore"))
    implementation(project(":core:network"))

}