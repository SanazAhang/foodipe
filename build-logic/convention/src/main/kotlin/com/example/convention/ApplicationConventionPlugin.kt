package com.example.convention

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.variant.AndroidComponentsExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import com.example.convention.helper.BuildType
import com.example.convention.helper.DependencyType
import com.example.convention.helper.appConstant
import com.example.convention.helper.configureKotlin
import com.example.convention.helper.libs
import com.example.convention.helper.setCompileOption
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

/**
 * Created by Sanaz Ahang on 21,April,2024
 */
class ApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {

        with(target) {
            pluginManager.apply(ANDROID_APPLICATION_NAME)
            pluginManager.apply("org.jetbrains.kotlin.android")
            configureProject()

            dependencies {
                add(
                    DependencyType.IMPLEMENTATION.configurationName,
                    libs.findLibrary("androidx-core-ktx").get()
                )
            }
        }
    }
}

private fun Project.configureProject() {
    android {
        compileSdk = appConstant.COMPILE_SDK
        configureDefaultConfig()
        configureBuildType()
        configureFlavor()
        setCompileOption()
        configureKotlin()
        val extension = extensions.getByType<ApplicationExtension>()
        configureAndroidCompose(extension)
        packaging {
            resources {
                excludes += "/META-INF/{AL2.0,LGPL2.1}"
            }
        }

        buildFeatures {
            this.buildConfig = true
        }

        val androidComponentsExtension =
            extensions.getByType(AndroidComponentsExtension::class.java)
    }
}

private fun BaseAppModuleExtension.configureFlavor() {}
private fun BaseAppModuleExtension.configureDefaultConfig() {
    defaultConfig {
        applicationId = appConstant.applicationId
        minSdk = appConstant.MIN_SDK
        targetSdk = appConstant.TARGET_SDK
        versionCode = appConstant.VERSION_CODE
        versionName = appConstant.VERSION_NAME

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }
}

private fun Project.android(func: BaseAppModuleExtension.() -> Unit) {
    extensions.getByType(BaseAppModuleExtension::class.java).apply(func)
}

fun BaseAppModuleExtension.configureBuildType() {
    buildTypes {
        getByName(BuildType.DEBUG.value) {
            versionNameSuffix = BuildType.DEBUG.versionNameSuffix
            isDebuggable = BuildType.DEBUG.isDebuggable
        }

        getByName(BuildType.RELEASE.value) {
            versionNameSuffix = BuildType.RELEASE.versionNameSuffix
            isDebuggable = BuildType.RELEASE.isDebuggable
        }
    }
}
