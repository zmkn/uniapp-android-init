val releaseAbis: Array<String> = arrayOf("arm64-v8a", "armeabi-v7a", "x86", "x86_64")

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.kapt)
}

android {
    namespace = "com.ailingqi.uniapp"
    compileSdk = 35
    ndkVersion = "27.1.12297006"

    signingConfigs {
        getByName("debug") {
            storeFile = file("..\\key\\release.jks")
            storePassword = "123456"
            keyPassword = "123456"
            keyAlias = "uniapp-android"
        }
        create("release") {
            storeFile = file("..\\key\\release.jks")
            storePassword = "123456"
            keyPassword = "123456"
            keyAlias = "uniapp-android"
        }
    }

    defaultConfig {
        applicationId = "com.ailingqi.uniapp"
        minSdk = 21
        targetSdk = 35
        versionCode = 100000
        versionName = "1.0.0"
        signingConfig = signingConfigs.getByName("release")
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        multiDexEnabled = true

        vectorDrawables {
            useSupportLibrary = true
        }

        ndk {
            // 指定要包含的 ABI 架构
            abiFilters.addAll(releaseAbis)
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isDebuggable = false
            isJniDebuggable = false
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            ndk {
                // 指定要包含的 ABI 架构
                abiFilters.addAll(releaseAbis)
            }
        }

        debug {
            isMinifyEnabled = false
            isDebuggable = true
            isJniDebuggable = false
            isShrinkResources = false
            signingConfig = signingConfigs.getByName("debug")
        }
    }

    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(22))
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_22
        targetCompatibility = JavaVersion.VERSION_22
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "2.0.20"
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_22.toString()
    }

    buildFeatures {
        compose = true
        buildConfig = true
        viewBinding = true
        dataBinding = true
        buildConfig = true
    }

    androidResources {
        ignoreAssetsPattern = "!.svn:!.git:.*:!CVS:!thumbs.db:!picasa.ini:!*.scc:*~"
        additionalParameters.add("--auto-add-overlay")
    }

    dependenciesInfo {
        includeInApk = true
        includeInBundle = true
    }

    packaging {
        resources {
            excludes += listOf(
                "/META-INF/{AL2.0,LGPL2.1}",
                "META-INF/INDEX.LIST",
                "META-INF/io.netty.versions.properties"
            )
        }
    }

    sourceSets {
        getByName("main") {
            // 指定自定义的 jniLibs 目录
            jniLibs.srcDirs("jniLibs")
        }
    }
}

dependencies {
    // 导入uni-app插件
    implementation(project(":uniplugin_modules"))
    // 导入SDK相关依赖jar、aar
    implementation(
        fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar", "*.aar")))
    )
    // uniapp 必须库
    implementation(libs.androidx.recyclerview)
    implementation(libs.facebook.fresco)
    implementation(libs.facebook.animated.gif)
    // uniapp 基座必须库
    implementation(libs.glide)
    implementation(libs.fastjson)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.webkit)
    implementation(libs.androidx.localbroadcastmanager)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.fragment.ktx)
    // 项目依赖
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.compose.runtime)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit.ktx)
    androidTestImplementation(libs.androidx.espresso.core)
}