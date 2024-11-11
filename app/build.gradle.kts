plugins {
	alias(libs.plugins.customPlugins.android.application)
	alias(libs.plugins.customPlugins.android.compose.application)
	alias(libs.plugins.kotlin.serialization)
}

android {
	namespace = "com.arashdev.airbnbclone"

	defaultConfig {
		applicationId = "com.arashdev.androidtemplate"
		versionCode = 1
		versionName = "1.0"

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
		vectorDrawables {
			useSupportLibrary = true
		}
	}

	buildTypes {
		release {
			isMinifyEnabled = true
			proguardFiles(
				getDefaultProguardFile("proguard-android-optimize.txt"),
				"proguard-rules.pro"
			)
			signingConfig = signingConfigs.getByName("debug")
		}
		debug {
			isMinifyEnabled = false
		}
		create("benchmark") {
			initWith(buildTypes.getByName("release"))
			signingConfig = signingConfigs.getByName("debug")
			matchingFallbacks += listOf("release")
			isDebuggable = false
		}
	}
	kotlinOptions {
		jvmTarget = "17"
	}
	packaging {
		resources {
			excludes += "/META-INF/{AL2.0,LGPL2.1}"
		}
	}
}

dependencies {

	implementation(libs.androidx.core.ktx)
	implementation(libs.androidx.lifecycle.runtime.ktx)

	//compose
	implementation(libs.androidx.activity.compose)
	implementation(platform(libs.androidx.compose.bom))
	implementation(libs.androidx.compose.ui)
	implementation(libs.androidx.compose.ui.graphics)
	implementation(libs.androidx.compose.ui.tooling.preview)
	implementation(libs.androidx.compose.material3)
	implementation(libs.androidx.compose.material.icons.core)
	implementation(libs.androidx.compose.material.icons.extended)
	implementation(libs.androidx.navigation.compose)
	implementation(libs.coil.compose)
	implementation(libs.coil.network.ktor3)

	//network
	implementation(libs.ktor.androidClient)

	implementation(libs.kotlix.serialization)

	//test
	testImplementation(libs.junit)
	androidTestImplementation(libs.androidx.junit)
	androidTestImplementation(libs.androidx.espresso.core)
	androidTestImplementation(platform(libs.androidx.compose.bom))
	androidTestImplementation(libs.androidx.compose.ui.test.junit4)
	debugImplementation(libs.androidx.compose.ui.tooling)
	debugImplementation(libs.androidx.compose.ui.test.manifest)
}