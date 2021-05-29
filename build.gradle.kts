plugins {
    kotlin("js") version "1.5.10"
}

group = "ru.psu"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
}

val kotlinReduxVersion = "4.0.5"
val kotlintSyledVersion = "5.3.0"
val reactReduxVersion = "7.2.3"
val reactRouterVersion = "5.2.0"
val reactVersion = "17.0.2"

val kotlinWrappersGroudId = "org.jetbrains.kotlin-wrappers"
val kotlinWrappersVersion = "-pre.204-kotlin-1.5.0"

dependencies {
    implementation("$kotlinWrappersGroudId:kotlin-react:$reactVersion$kotlinWrappersVersion")
    implementation("$kotlinWrappersGroudId:kotlin-react-dom:$reactVersion$kotlinWrappersVersion")
    implementation("$kotlinWrappersGroudId:kotlin-styled:$kotlintSyledVersion$kotlinWrappersVersion")
    implementation("$kotlinWrappersGroudId:kotlin-react-router-dom:$reactRouterVersion$kotlinWrappersVersion")
    implementation("$kotlinWrappersGroudId:kotlin-redux:$kotlinReduxVersion$kotlinWrappersVersion")
    implementation("$kotlinWrappersGroudId:kotlin-react-redux:$reactReduxVersion$kotlinWrappersVersion")

    implementation("ru.psu:deezer-sdk-kotlin:1.0-SNAPSHOT")

    implementation(npm("buffer", "6.0.3"))
    implementation(npm("crypto-browserify", "3.12.0"))
    implementation(npm("stream-browserify", "3.0.0"))
}

kotlin {
    js(IR) {
        binaries.executable()
        browser {
            commonWebpackConfig {
                cssSupport.enabled = true
            }
            webpackTask {
                cssSupport.enabled = true
            }
            runTask {
                cssSupport.enabled = true
            }
        }
    }
}