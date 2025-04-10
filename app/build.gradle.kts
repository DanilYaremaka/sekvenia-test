plugins {
	alias(libs.plugins.android.application)
	alias(libs.plugins.jetbrains.kotlin.android)
}

android {
	namespace = "com.example.sekvenia"
	compileSdk = 34

	defaultConfig {
		applicationId = "com.example.sekvenia"
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

	implementation("com.squareup.retrofit2:retrofit:2.9.0")
	implementation("com.squareup.retrofit2:converter-scalars:2.9.0")
	implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")
	implementation("com.squareup.retrofit2:converter-moshi:2.9.0")
	implementation("com.squareup.moshi:moshi-kotlin:1.15.0")
	implementation("com.squareup.moshi:moshi-kotlin-codegen:1.15.0")
	implementation("com.squareup.moshi:moshi-adapters:1.15.0")

	testImplementation(libs.junit)
	androidTestImplementation(libs.androidx.junit)
	androidTestImplementation(libs.androidx.espresso.core)
}