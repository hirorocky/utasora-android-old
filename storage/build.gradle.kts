plugins {
    id(libs.plugins.androidLibrary.get().pluginId)
    id(libs.plugins.kotlin.android.get().pluginId)
}

android {
    namespace = "io.github.hirorocky.utasora.storage"

    buildFeatures {
        compose = true
    }
}

  dependencies {
      implementation(projects.core)
      implementation(libs.kotlin.coroutines)

  }
