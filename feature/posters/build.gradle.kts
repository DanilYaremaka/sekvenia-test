plugins {
	alias(libs.plugins.android.library)
	alias(libs.plugins.jetbrains.kotlin.android)
}

android {
	namespace = "com.example.posters"
	compileSdk = 34

	defaultConfig {
		minSdk = 26

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
	}
	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_11
		targetCompatibility = JavaVersion.VERSION_11
	}
	kotlinOptions {
		jvmTarget = "11"
	}
	composeOptions {
		kotlinCompilerExtensionVersion = "1.5.3"
	}
	buildFeatures {
		compose = true
	}
	testOptions {
		unitTests.all {
			it.useJUnitPlatform()
		}
	}
}

dependencies {
	implementation(project(":shared:films"))
	implementation(project(":component:ui"))

	implementation(libs.androidx.core.ktx)
	implementation(libs.androidx.appcompat)
	implementation(libs.material)

	implementation(libs.androidx.activity.compose)
	implementation(libs.androidx.ui)
	implementation(libs.androidx.ui.tooling)
	implementation(libs.androidx.runtime)
	implementation(libs.androidx.lifecycle.viewmodel.compose)
	implementation(libs.androidx.material3)

	implementation(libs.koin.android)
	implementation(libs.koin.core)

	implementation(libs.kotlinx.coroutines.core)
	implementation(libs.kotlinx.coroutines.android)

	implementation(libs.retrofit)
	implementation(libs.converter.scalars)
	implementation(libs.logging.interceptor)
	implementation(libs.converter.moshi)
	implementation(libs.moshi.kotlin)
	implementation(libs.moshi.kotlin.codegen)
	implementation(libs.moshi.adapters)

	implementation(libs.coil3.coil.compose)
	implementation(libs.coil.network.okhttp)

	testImplementation(libs.junit.jupiter.api)
	testImplementation(libs.junit.jupiter.engine)
	testImplementation(libs.junit.jupiter.params)
	testImplementation(libs.junit.platform.suite)
	testImplementation(libs.mockito.inline)
	testImplementation(libs.mockito.mockito.junit.jupiter)
	testImplementation(libs.mockito.core)
	testImplementation(libs.mockito.kotlin)
	testImplementation(libs.kotlinx.coroutines.test)
	testImplementation(libs.turbine)
}