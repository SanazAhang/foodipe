import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
}


dependencies {
    compileOnly(libs.kotlin.gradle)
    compileOnly(libs.android.gradle)
}
gradlePlugin {
    plugins {
        register("applicationCompose") {
            id = "foodipe.application.compose"
            implementationClass = "com.example.convention.ComposeApplicationConventionPlugin"
        }
        register("libraryCompose") {
            id = "foodipe.library.compose"
            implementationClass = "com.example.convention.ComposeLibraryConventionPlugin"
        }
    }
}