plugins {
    alias(libs.plugins.harkhark.android.library)
    alias(libs.plugins.harkhark.android.hilt)
    alias(libs.plugins.protobuf)
}

android {
    namespace = "com.harkhark.core.datastore"
}

protobuf {
    protoc {
        artifact = libs.protobuf.protoc.get().toString()
    }
    generateProtoTasks {
        all().forEach { task ->
            task.builtins {
                register("kotlin") {
                    option("lite")
                }
            }
        }
    }
}

dependencies {
    implementation(project(":core:common"))

    implementation(libs.protobuf.kotlin.lite)
    implementation(libs.datastore.preferences)
}