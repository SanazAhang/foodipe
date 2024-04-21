package com.example.convention

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.CommonExtension
import com.example.convention.helper.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType


const val ANDROID_APPLICATION_NAME = "com.android.application"

/**
 * Created by Sanaz Ahang on 17,April,2024
 */
class ComposeApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply(ANDROID_APPLICATION_NAME)
            val extension = extensions.getByType<ApplicationExtension>()
            configureAndroidCompose(extension)
        }
    }

}

fun Project.configureAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *, *, *>
) {
    commonExtension.apply {
        buildFeatures {
            compose = true

        }
        composeOptions {
            kotlinCompilerExtensionVersion = "1.5.1"
        }

        dependencies {
            add(
                configurationName = "implementation",
                libs.findLibrary("androidx-activity-compose").get()
            )
            add(
                configurationName = "implementation",
                platform(libs.findLibrary("androidx-compose-bom").get())
            )
        }

    }
}
