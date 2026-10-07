/*
 * Copyright 2026 TwedMediaInfo Contributors
 */

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.maven.publish)
}

android {
    namespace = "com.twedmediainfo.android"
    compileSdk = 37

    defaultConfig {
        minSdk = 24

        consumerProguardFiles("consumer-rules.pro")

        ndk {
            abiFilters += listOf("arm64-v8a", "armeabi-v7a")
        }

        externalNativeBuild {
            cmake {
                cppFlags += "-std=c++17"
                arguments += listOf(
                    "-DANDROID_STL=c++_static",
                    "-DANDROID_ARM_MODE=arm"
                )
            }
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    externalNativeBuild {
        cmake {
            path = file("src/main/cpp/CMakeLists.txt")
            version = "3.22.1"
        }
    }

    ndkVersion = "28.2.13676358"

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

mavenPublishing {
    publishToMavenCentral(automaticRelease = false)

    signAllPublications()

    coordinates(
        "io.github.boludohh",
        "twedmediainfo",
        "0.1.0"
    )

    pom {
        name = "TwedMediaInfo"
        description = "Biblioteca Android para analizar archivos multimedia y acceder a sus metadatos e información técnica mediante MediaInfoLib."
        inceptionYear = "2026"
        url = "https://github.com/TwedProjects/TwedMediaInfo"

        licenses {
            license {
                name = "Apache License 2.0"
                url = "https://www.apache.org/licenses/LICENSE-2.0"
                distribution = "repo"
            }
        }

        developers {
            developer {
                id = "boludohh"
                name = "boludohh"
                email = "lautyryal@gmail.com"
                url = "https://github.com/boludohh"
            }
        }

        scm {
            url = "https://github.com/TwedProjects/TwedMediaInfo"
            connection = "scm:git:git://github.com/TwedProjects/TwedMediaInfo.git"
            developerConnection = "scm:git:ssh://git@github.com/TwedProjects/TwedMediaInfo.git"
        }
    }
}