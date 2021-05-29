plugins {
    kotlin("js") version "1.5.10"
}

group = "ru.psu"
version = "1.0-SNAPSHOT"

repositories {
    jcenter()
    mavenCentral()
    mavenLocal()
    maven { url = uri("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/kotlin-js-wrappers") }
}

dependencies {
    implementation("org.jetbrains:kotlin-react:17.0.1-pre.148-kotlin-1.4.30")
    implementation("org.jetbrains:kotlin-react-dom:17.0.1-pre.148-kotlin-1.4.30")
    implementation("org.jetbrains:kotlin-styled:5.2.1-pre.148-kotlin-1.4.30")
    implementation("org.jetbrains:kotlin-react-router-dom:5.2.0-pre.148-kotlin-1.4.30")
    implementation("org.jetbrains:kotlin-redux:4.0.5-pre.148-kotlin-1.4.30")
    implementation("org.jetbrains:kotlin-react-redux:7.2.2-pre.148-kotlin-1.4.30")

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
        }
    }
}