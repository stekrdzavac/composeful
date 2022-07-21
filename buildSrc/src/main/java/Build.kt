package com.stekrdzavac.android.bgparking.buildSrc

object Versions {
    const val composeVersion = "1.2.0-beta02"
    const val composeCompilerVersion = "1.2.0-beta03"
    const val lifecycleVersion = "2.5.0-rc01"
    const val testVersion = "1.4.0"
    const val jvmTarget = "1.8"
    const val hiltVersion = "2.38.1"
    const val hiltComposeVersion = "1.0.0"
    const val roomVersion = "2.4.2"
}

object Dependencies {
    const val coreKtx = "androidx.core:core-ktx:1.7.0"

    object Kotlin {
        const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.4.0"

    }

    object Activity {
        const val activityCompose = "androidx.activity:activity-compose:1.4.0"
    }

    object Constraint {
        const val constraintLayoutCompose =
            "androidx.constraintlayout:constraintlayout-compose:1.0.0"
    }

    object Compose {
        const val UI = "androidx.compose.ui:ui:${Versions.composeVersion}"
        const val material = "androidx.compose.material:material:${Versions.composeVersion}"
        const val preview = "androidx.compose.ui:ui-tooling-preview:${Versions.composeVersion}"
        const val runtime = "androidx.compose.runtime:runtime:${Versions.composeVersion}"
        const val foundation = "androidx.compose.foundation:foundation:${Versions.composeVersion}"
        const val layout =
            "androidx.compose.foundation:foundation-layout:${Versions.composeVersion}"
        const val materialIconsExtended =
            "androidx.compose.material:material-icons-extended:${Versions.composeVersion}"
        const val tooling = "androidx.compose.ui:ui-tooling:${Versions.composeVersion}"
    }

    object Lifecycle {
        const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleVersion}"
        const val viewModelCompose =
            "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.lifecycleVersion}"
        const val viewModel =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleVersion}"
    }

    object Navigation {
        const val navigationCompose = "androidx.navigation:navigation-compose:2.4.1"
    }

    object Test {
        const val core = "androidx.test:core:${Versions.testVersion}"
        const val rules = "androidx.test:rules:${Versions.testVersion}"
        const val junit = "junit:junit:4.13.2"

        object Ext {
            const val junit = "androidx.test.ext:junit-ktx:1.1.3"
        }

        const val composeUiTestJunit =
            "androidx.compose.ui:ui-test-junit4:${Versions.composeVersion}"

        const val espressoCore = "androidx.test.espresso:espresso-core:3.4.0"
    }

    object Jsoup {
        const val jsoup = "org.jsoup:jsoup:1.11.2"
    }

    object Hilt {
        const val hilt = "com.google.dagger:hilt-android:${Versions.hiltVersion}"
        const val compiler = "com.google.dagger:hilt-android-compiler:${Versions.hiltVersion}"
        const val hiltCompose = "androidx.hilt:hilt-navigation-compose:${Versions.hiltComposeVersion}"
    }

    object Room {
        const val room = "androidx.room:room-runtime:${Versions.roomVersion}"
        const val compiler = "androidx.room:room-compiler:${Versions.roomVersion}"
        const val ext = "androidx.room:room-ktx:${Versions.roomVersion}"
    }
}
