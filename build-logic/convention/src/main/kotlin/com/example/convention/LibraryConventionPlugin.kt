package com.example.convention

import com.android.build.gradle.LibraryExtension
import com.example.convention.helper.DependencyType
import com.example.convention.helper.Dimensions
import com.example.convention.helper.appConstant
import com.example.convention.helper.configureKotlin
import com.example.convention.helper.libs
import com.example.convention.helper.setCompileOption
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

/**
 * Created by Sanaz Ahang on 20,April,2024
 */
class LibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.applyPlugin()
        target.configureProject()
        target.addDependencies()
    }
}

private fun Project.applyPlugin() {
    this.apply() {
        pluginManager.apply(ANDROID_LIBRARY_NAME)
        pluginManager.apply("org.jetbrains.kotlin.android")
    }
}

private fun Project.configureProject() {
    android {
        compileSdk = appConstant.COMPILE_SDK
        configureDefaultConfig()
        configureBuildType()
        configureFlavors()
        setCompileOption()
        configureKotlin()

        buildFeatures {
            this.buildConfig = true
        }
    }
}

private fun Project.android(func: LibraryExtension.() -> Unit) {
    extensions.getByType(LibraryExtension::class.java).apply {
        func()
    }
}

private fun LibraryExtension.configureBuildType() {
    buildTypes { }
}

private fun LibraryExtension.configureDefaultConfig() {
    defaultConfig {
        minSdk = appConstant.MIN_SDK
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
        consumerProguardFiles("consumer-rules.pro")
    }
}

private fun Project.addDependencies() {
    dependencies {
        add(
            DependencyType.IMPLEMENTATION.configurationName,
            libs.findLibrary("androidx-core-ktx").get()
        )
    }
}

private fun LibraryExtension.configureFlavors() {
    val dimensionList = listOf(Dimensions.HOST)
    flavorDimensionList += dimensionList.map { it.value }

    productFlavors {
        dimensionList.forEach { dimen ->
            dimen.flavors.forEach { flavor ->
                create(flavor.value) {
                    dimension = dimen.value
                }
            }
        }
    }
}

