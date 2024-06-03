dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "Utasora"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":app")
include(":theme")
include(":navigation")
include(":storage")
include(":core")
include(":feature:introspection")
include(":feature:phrases")
include(":feature:poems")
include(":feature:settings")
include(":feature:signin")
include(":feature:signup")
include(":feature:splash")
include(":feature:title")
