package com.example.convention.helper

/**
 * Created by Sanaz Ahang on 21,April,2024
 */
enum class BuildType(val value: String, val versionNameSuffix: String, val isDebuggable: Boolean) {
    DEBUG("debug", "-debug", true),
    RELEASE("release", "-release", false)
}