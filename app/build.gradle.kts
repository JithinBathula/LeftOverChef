plugins {
    alias(libs.plugins.androidApplication)
    id("com.google.gms.google-services") //Firebase
}

android {
    namespace = "com.example.aninterface"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.aninterface"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.firebase.database) //Firebase
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // For GenAI
    implementation ("com.squareup.okhttp3:okhttp:4.10.0")
    implementation ("com.fasterxml.jackson.core:jackson-databind:2.16.1")



}