import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}


// Configure the build-logic plugins to target JDK 17
// This matches the JDK used to build the project, and is not related to what is running on device.
java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.android.tools.common)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.room.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "harkhark.android.application"
            implementationClass = "com.harkhark.AndroidApplicationConventionPlugin"
        }
        register("androidApplicationCompose") {
            id = "harkhark.android.application.compose"
            implementationClass = "com.harkhark.AndroidApplicationComposeConventionPlugin"
        }
        register("androidLibrary") {
            id = "harkhark.android.library"
            implementationClass = "com.harkhark.AndroidLibraryConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "harkhark.android.library.compose"
            implementationClass = "com.harkhark.AndroidLibraryComposeConventionPlugin"
        }
        register("androidFeature") {
            id = "harkhark.android.feature"
            implementationClass = "com.harkhark.AndroidFeatureConventionPlugin"
        }
        register("androidHilt") {
            id = "harkhark.android.hilt"
            implementationClass = "com.harkhark.AndroidHiltConventionPlugin"
        }
        register("androidRoom") {
            id = "harkhark.android.room"
            implementationClass = "com.harkhark.AndroidRoomConventionPlugin"
        }
    }
}
