plugins {
    id("kotlin-kapt")
    alias(libs.plugins.hilt)
    id(libs.plugins.androidLibrary.get().pluginId)
    id(libs.plugins.kotlin.android.get().pluginId)
}

android {
    namespace = "io.github.hirorocky.utasora.core"

    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(projects.theme)

    // UI
    implementation(platform(libs.compose.bom))
    implementation(libs.accompanist.systemuicontroller)
    implementation(libs.android.material)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.appcompat)
    implementation(libs.compose.material3)
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.hilt.compose.navigation)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    // Hilt
    implementation(libs.androidx.hilt.compose.navigation)
    annotationProcessor(libs.hilt.compiler)
    kapt(libs.hilt.android.compiler)
    implementation(libs.hilt.android)

    // Firebase
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.auth)
    implementation(libs.firebase.firestore)
    implementation(libs.firebase.analytics)

    // Log
    implementation(libs.timber)
}
