import org.gradle.api.initialization.resolve.RepositoriesMode

rootProject.name = "labymod4-addon-template"

pluginManagement {
    val labyGradlePluginVersion = "0.6.2"
    buildscript {
        repositories {
            maven("https://dist.labymod.net/api/v1/maven/release/")
            maven("https://maven.neoforged.net/releases/")
            maven("https://maven.fabricmc.net/")
            gradlePluginPortal()
            mavenCentral()
        }

        dependencies {
            classpath("net.labymod.gradle", "common", labyGradlePluginVersion)
        }
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        mavenCentral()

        exclusiveContent {
            forRepository {
                maven("https://dist.labymod.net/api/v1/maven/release/")
            }
            filter {
                includeGroupByRegex("net\\.labymod(\\..*)?")
            }
        }

        maven("https://maven.neoforged.net/releases/") {
            content {
                includeGroupByRegex("net\\.neoforged(\\..*)?")
                includeGroupByRegex("com\\.mojang(\\..*)?")
            }
        }

        maven("https://maven.fabricmc.net/") {
            content {
                includeGroupByRegex("net\\.fabricmc(\\..*)?")
            }
        }
    }
}

plugins.apply("net.labymod.labygradle.settings")

include(":api")
include(":core")
