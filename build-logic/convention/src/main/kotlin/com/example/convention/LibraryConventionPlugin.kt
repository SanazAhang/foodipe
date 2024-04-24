package com.example.convention

import com.android.build.gradle.LibraryExtension
import com.example.convention.helper.ANDROID_LIBRARY_NAME
import com.example.convention.helper.ANDROID_TEST_RUNNER
import com.example.convention.helper.CONSUMER_RULES
import com.example.convention.helper.CORE_KTX
import com.example.convention.helper.DependencyType
import com.example.convention.helper.Dimensions
import com.example.convention.helper.JET_BRAIN_KOTLIN_ANDROID
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
        pluginManager.apply(JET_BRAIN_KOTLIN_ANDROID)
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
        testInstrumentationRunner = ANDROID_TEST_RUNNER
        vectorDrawables {
            useSupportLibrary = true
        }
        consumerProguardFiles(CONSUMER_RULES)
    }
}

private fun Project.addDependencies() {
    dependencies {
        add(
            DependencyType.IMPLEMENTATION.configurationName,
            libs.findLibrary(CORE_KTX).get()
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

