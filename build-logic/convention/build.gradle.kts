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
    compileOnly("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.10")
    compileOnly("com.android.tools.build:gradle:8.3.0")
}
gradlePlugin {
    plugins {
        register("conventionName") {
            id = "foodipe.compose"
            implementationClass = "ComposeConventionPlugin"
        }
    }
}