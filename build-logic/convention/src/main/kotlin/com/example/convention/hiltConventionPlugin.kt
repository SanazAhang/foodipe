package com.example.convention

import com.example.convention.helper.DependencyType
import com.example.convention.helper.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

/**
 * Created by Sanaz Ahang on 22,April,2024
 */
class hiltConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("dagger.hilt.android.plugin")
            pluginManager.apply("com.google.devtools.ksp")



            dependencies {
                add(
                    configurationName = DependencyType.IMPLEMENTATION.configurationName,
                    libs.findLibrary("dagger-hilt").get()
                )

                add(
                    configurationName = DependencyType.IMPLEMENTATION.configurationName,
                    libs.findLibrary("dagger-hilt-compiler").get()
                )
            }
        }

    }
}