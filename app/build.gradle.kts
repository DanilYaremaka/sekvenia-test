plugins {
	alias(libs.plugins.android.application)
	alias(libs.plugins.jetbrains.kotlin.android)
}

android {
	namespace = "com.example.sequenia"
	compileSdk = 34

	defaultConfig {
		applicationId = "com.example.sequenia"
		minSdk = 26
		targetSdk = 34
		versionCode = 1
		versionName = "1.0"

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
	}

	buildTypes {
		release {
			isMinifyEnabled = false
			proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
		}
	}
	composeOptions {
		kotlinCompilerExtensionVersion = "1.5.3"
	}
	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_11
		targetCompatibility = JavaVersion.VERSION_11
	}
	kotlinOptions {
		jvmTarget = "11"
	}
	buildFeatures {
		viewBinding = true
		compose = true
	}
}

dependencies {
	implementation(project(":feature:posters"))
	implementation(project(":feature:details"))
	implementation(project(":shared:films"))

	implementation(libs.androidx.core.ktx)
	implementation(libs.androidx.appcompat)
	implementation(libs.material)

	implementation(libs.androidx.activity.compose)
	implementation(libs.androidx.ui)
	implementation(libs.androidx.material3)
	implementation(libs.androidx.ui.tooling)
	implementation(libs.androidx.runtime)
	implementation(libs.androidx.lifecycle.viewmodel.compose)

	implementation(libs.cicerone)

	implementation(libs.koin.android)
	implementation(libs.koin.core)

	implementation(libs.retrofit)
	implementation(libs.converter.scalars)
	implementation(libs.logging.interceptor)
	implementation(libs.converter.moshi)
	implementation(libs.moshi.kotlin)
	implementation(libs.moshi.kotlin.codegen)
	implementation(libs.moshi.adapters)
}