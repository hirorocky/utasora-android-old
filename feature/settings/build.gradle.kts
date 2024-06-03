plugins {
    id("kotlin-kapt")
    alias(libs.plugins.hilt)
    id(libs.plugins.androidLibrary.get().pluginId)
    id(libs.plugins.kotlin.android.get().pluginId)
}

android {
    namespace = "io.github.hirorocky.utasora.introspection"

    buildFeatures {
        compose = true
    }
}

dependencies {
    //Module
    implementation(projects.core)

    // UI
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.material3)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    // Hilt
    implementation(libs.androidx.hilt.compose.navigation)
    annotationProcessor(libs.hilt.compiler)
    kapt(libs.hilt.android.compiler)
    implementation(libs.hilt.android)
}

kapt {
    correctErrorTypes = true
}
