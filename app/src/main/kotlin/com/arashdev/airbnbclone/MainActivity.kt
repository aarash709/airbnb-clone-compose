package com.arashdev.airbnbclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.arashdev.airbnbclone.components.AirbnbNavigationBar
import com.arashdev.airbnbclone.navigation.AirbnbNavHost
import com.arashdev.airbnbclone.ui.theme.AirbnbCloneTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			App()
		}
	}
}

@Composable
fun App() {
	AirbnbCloneTheme {
		val navController = rememberNavController()
		Scaffold(bottomBar = {
			AirbnbNavigationBar(
				navController = navController
			)
		}) { padding ->
			Box(modifier = Modifier.padding(padding).consumeWindowInsets(padding)) {
				AirbnbNavHost(
					navController = navController
				)
			}
		}
	}
}


@Preview(showBackground = true)
@Composable
fun AirbnbClonePreview() {
	AirbnbCloneTheme {
		App()
	}
}