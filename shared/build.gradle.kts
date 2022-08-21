/**
 * Config third-party dependency versions here 😋
 */
val kotlinDateTime = "0.3.3"
val kotlinCoroutines = "1.6.2"
val ktor = "2.0.2"
val realm = "1.0.1"
val koin = "3.2.0"

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization") version "1.6.21"
    id("io.realm.kotlin")
}

kotlin {
    android()
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            /**
             * Add multiplatform dependencies here
             */
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:$kotlinDateTime")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinCoroutines")
                implementation("io.ktor:ktor-client-core:$ktor")
                implementation("io.ktor:ktor-client-content-negotiation:$ktor")
                implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor")
                api("io.realm.kotlin:library-base:$realm")
                api("io.insert-koin:koin-core:$koin")
                api("io.insert-koin:koin-test:$koin")
                api(project(":kmm_arch"))
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            /**
             * Add Android specific dependencies here
             */
            dependencies {
                implementation("io.ktor:ktor-client-okhttp:$ktor")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$kotlinCoroutines")
                api("io.insert-koin:koin-android:$koin")
            }
        }
        val androidTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            /**
             * Add iOS specific dependencies here
             */
            dependencies {
                implementation("io.ktor:ktor-client-darwin:$ktor")
            }
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    compileSdk = 32
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 26
        targetSdk = 32
    }
}

kotlin.targets.withType(org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget::class.java) {
    binaries.all {
        binaryOptions["memoryModel"] = "experimental"
    }
}