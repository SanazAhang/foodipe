package com.example.convention

import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Created by Sanaz Ahang on 20,April,2024
 */
class LibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        TODO("Not yet implemented")
    }
}

private fun Project.applyPlugin() {}

private fun Project.configureProject() {}

private fun Project.android() {}

private fun LibraryExtension.configureBuildType() {}

private fun LibraryExtension.configureDefaultConfig() {}

private fun Project.addDependencies() {}

private fun LibraryExtension.configureFlavors() {}

