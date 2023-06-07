plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-parcelize")
    kotlin("kapt")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.nora.cinemoapp"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.nora.cinemoapp"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
    buildTypes {
        getByName("release") {
            isDebuggable = false
            isMinifyEnabled = true
            setProguardFiles(listOf(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro"))
            buildConfigField("String", "BASE_ENDPOINT", "\"https://www.majorcineplex.com/apis/\"")
        }
        getByName("debug") {
            isDebuggable = true
            isMinifyEnabled = false
            setProguardFiles(listOf(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro"))
            buildConfigField("String", "BASE_ENDPOINT", "\"https://www.majorcineplex.com/apis/\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kapt {
        correctErrorTypes = true
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(libs.androidxAppcompat)
    implementation(libs.androidxCard)
    implementation(libs.androidxConstraintlayout)
    implementation(libs.androidxCoreKtx)
    implementation(libs.androidxLifecycleLivedataKtx)
    implementation(libs.androidxLifecycleViewmodelKtx)
    kapt(libs.androidxLifecycleCompiler)
    implementation(libs.androidxNavigationFragmentKtx)
    implementation(libs.androidxNavigationUiKtx)
    implementation(libs.androidxRecyclerView)
    implementation(libs.androidxRoomKtx)
    implementation(libs.androidxRoomRuntime)
    kapt(libs.androidxRoomCompiler)
    implementation(libs.androidxSwipe)

    implementation(libs.coil)

    implementation(libs.kotlinxCoroutinesAndroid)
    implementation(libs.kotlinxCoroutinesCore)
    implementation(libs.kotlinTime)

    implementation(libs.koinCore)
    implementation(libs.koinAndroid)

    implementation(libs.material)

    implementation(libs.okhttp)
    implementation(libs.loggingInterceptor)

    implementation(libs.retrofit)
    implementation(libs.converterMoshi)

    implementation(libs.moshiCore)
    implementation(libs.moshiCodegen)

    androidTestImplementation(libs.androidxEspresso)
    androidTestImplementation(libs.androidxTest)
    testImplementation(libs.junit)
}
