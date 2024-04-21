plugins {
    alias(libs.plugins.custom.library.common)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.example.network"
}

dependencies {

    implementation(libs.androidx.appcompat)
    implementation(libs.material)

     api(projects.core.common)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}