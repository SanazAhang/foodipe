package com.example.convention

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.CommonExtension
import com.example.convention.helper.ACTIVITY_COMPOSE
import com.example.convention.helper.ANDROID_APPLICATION_NAME
import com.example.convention.helper.COMPOSE_BOM
import com.example.convention.helper.DependencyType
import com.example.convention.helper.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.konan.util.visibleName


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
            kotlinCompilerExtensionVersion = "1.5.2"
        }

        dependencies {
            add(
                configurationName = DependencyType.IMPLEMENTATION.visibleName,
                libs.findLibrary(ACTIVITY_COMPOSE).get()
            )
            add(
                configurationName = DependencyType.IMPLEMENTATION.visibleName,
                platform(libs.findLibrary(COMPOSE_BOM).get())
            )
        }

    }
}
