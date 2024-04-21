package com.example.convention.helper

/**
 * Created by Sanaz Ahang on 21,April,2024
 */
enum class DependencyType(val configurationName: String) {
    IMPLEMENTATION("implementation"),
    ANDROID_TEST("androidTestImplementation"),
    API("api"),
    KSP("ksp"),
    KAPT("kapt")
}