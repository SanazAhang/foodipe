package com.example.convention

import com.example.convention.helper.DAGGER_HILT
import com.example.convention.helper.DAGGER_HILT_COMPILER
import com.example.convention.helper.DAGGER_HILT_PLUGIN
import com.example.convention.helper.DEV_TOOLS_KSP
import com.example.convention.helper.DependencyType
import com.example.convention.helper.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

/**
 * Created by Sanaz Ahang on 22,April,2024
 */
class HiltConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply(DAGGER_HILT_PLUGIN)
            pluginManager.apply(DEV_TOOLS_KSP)



            dependencies {
                add(
                    configurationName = DependencyType.IMPLEMENTATION.configurationName,
                    libs.findLibrary(DAGGER_HILT).get()
                )

                add(
                    configurationName = DependencyType.IMPLEMENTATION.configurationName,
                    libs.findLibrary(DAGGER_HILT_COMPILER).get()
                )
            }
        }

    }
}