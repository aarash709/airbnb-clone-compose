package com.arashdev.airbnbclone.Trips

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arashdev.airbnbclone.components.EmptyTrips

@Composable
fun Trips(modifier: Modifier = Modifier) {
	Scaffold(modifier = modifier) { padding ->
		Column(modifier = Modifier
			.padding(padding)
			.padding(horizontal = 24.dp)) {
			Text(
				text = "Trips",
				modifier = Modifier.padding(vertical = 32.dp),
				fontWeight = FontWeight.Bold,
				fontSize = 30.sp
			)
			HorizontalDivider(
				thickness = 1.dp,
				color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.15f)
			)
			EmptyTrips()
		}
	}
}