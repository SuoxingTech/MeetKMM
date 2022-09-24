pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "MeetKMM"
include(":androidApp")
include(":shared")
include(":kmm_arch")
include(":kmm_analytics")
