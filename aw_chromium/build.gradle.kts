plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "org.chromium.android_webview"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
        multiDexEnabled = false
        consumerProguardFiles("consumer-rules.pro")
        ndk {
            abiFilters += listOf("x86", "x86_64", "armeabi-v7a", "arm64-v8a")
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

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        aidl = true
        buildConfig = true
    }
}

dependencies {

    implementation("androidx.annotation:annotation:1.7.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.asynclayoutinflater:asynclayoutinflater:1.0.0")
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.multidex:multidex:2.0.1")
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation("com.google.android.gms:play-services-gcm:17.0.0")
    implementation("com.google.android.gms:play-services-location:21.0.1")
    implementation("com.google.android.gms:play-services-vision:20.1.3")
    implementation("com.google.code.findbugs:jsr305:3.0.2")
    implementation("com.google.protobuf:protobuf-javalite:3.22.3")
    implementation("org.glassfish:javax.annotation:10.0-b28")
    implementation("com.google.firebase:firebase-crashlytics-buildtools:2.9.9")
    implementation("com.google.android.gms:play-services-auth-api-phone:18.0.1")
    implementation("androidx.privacysandbox.ads:ads-adservices-java:1.1.0-beta03")
    implementation("androidx.privacysandbox.ads:ads-adservices:1.1.0-beta03")
    implementation("com.google.android.material:material:1.10.0")
    implementation("com.google.errorprone:error_prone_annotations:2.23.0")
    implementation("com.google.guava:guava:32.1.3-jre")
    implementation("androidx.concurrent:concurrent-futures:1.1.0")
}
