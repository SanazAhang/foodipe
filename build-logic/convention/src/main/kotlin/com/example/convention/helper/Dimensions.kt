package com.example.convention.helper

/**
 * Created by Sanaz Ahang on 21,April,2024
 */
enum class Dimensions(val value: String, val flavors: List<Flavors>) {
    HOST(
        "host",
        listOf(Flavors.DEVELOPMENT_HOST)
    )
}