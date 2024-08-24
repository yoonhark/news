pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "News"
include(":app")
include(":core:data")
include(":core:common")
include(":core:domain")
include(":core:designsystem")
include(":core:database")
include(":core:network")
include(":core:ui")
include(":core:datastore")
include(":feature:splash")
include(":feature:home")
include(":feature:detail")
