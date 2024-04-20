package com.example.convention

import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType


const val ANDROID_APPLICATION_NAME = "com.example.foodipe"

/**
 * Created by Sanaz Ahang on 17,April,2024
 */
class ComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply(ANDROID_APPLICATION_NAME)
            val extension = extensions.getByType<ApplicationExtension>()
        }
    }

}
