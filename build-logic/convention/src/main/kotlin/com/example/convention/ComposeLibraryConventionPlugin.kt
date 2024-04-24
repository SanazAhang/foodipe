package com.example.convention

import com.android.build.gradle.LibraryExtension
import com.example.convention.helper.ANDROID_LIBRARY_NAME
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

/**
 * Created by Sanaz Ahang on 20,April,2024
 */


class ComposeLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply(ANDROID_LIBRARY_NAME)
            val extension = extensions.getByType<LibraryExtension>()
            configureAndroidCompose(extension)
        }
    }
}

