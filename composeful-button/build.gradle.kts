import com.stekrdzavac.android.bgparking.buildSrc.Dependencies
import com.stekrdzavac.android.bgparking.buildSrc.Versions

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = 32

    defaultConfig {
        minSdk = 23
        targetSdk = 32

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeVersion
    }
    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {
    implementation(Dependencies.coreKtx)
    implementation(Dependencies.Compose.UI)
    implementation(Dependencies.Compose.foundation)
    implementation(Dependencies.Compose.layout)
    implementation(Dependencies.Compose.material)
    implementation(Dependencies.Compose.preview)
    implementation(Dependencies.Compose.tooling)
    implementation(Dependencies.Compose.materialIconsExtended)
    implementation(Dependencies.Test.junit)
    implementation(Dependencies.Test.Ext.junit)
    implementation(Dependencies.Test.espressoCore)
    implementation(Dependencies.Test.composeUiTestJunit)
    debugImplementation("androidx.compose.ui:ui-tooling:${Versions.composeVersion}")
    debugImplementation("androidx.compose.ui:ui-test-manifest:${Versions.composeVersion}")
}