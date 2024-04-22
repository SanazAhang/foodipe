plugins {
    alias(libs.plugins.custom.library.common)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.custom.android.dagger.hilt)

}

android {
    namespace = "com.example.data"
}

dependencies {
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    api(projects.core.common)
    api(projects.core.network)
    api(projects.core.database)
}