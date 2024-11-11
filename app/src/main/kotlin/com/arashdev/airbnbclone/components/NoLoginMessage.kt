package com.arashdev.airbnbclone.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arashdev.airbnbclone.ui.theme.AccentColor
import com.arashdev.airbnbclone.ui.theme.AirbnbCloneTheme

@Composable
fun EmptyMessages(modifier: Modifier = Modifier) {
	NoLoginMessage(
		modifier = modifier,
		label = "Messages",
		title = "Login to read messages",
		description = "Once you login, you`ll find messages from hosts here."
	)
}

@Composable
fun EmptyTrips(modifier: Modifier = Modifier) {
	NoLoginMessage(
		modifier = modifier,
		label = "Trips",
		title = "No trips yet",
		description = "When you`re ready to plan your next trip, we`re here"
	)
}

@Composable
fun EmptyWishlist(modifier: Modifier = Modifier) {

}

@Composable
fun NoLoginMessage(
	modifier: Modifier = Modifier,
	label: String,
	title: String,
	description: String
) {
	Scaffold(
		modifier = modifier.padding(vertical = 14.dp, horizontal = 24.dp)
	) { padding ->
		Column(modifier = Modifier.padding(padding)) {
			Text(
				text = label,
				modifier = Modifier.padding(vertical = 32.dp),
				fontWeight = FontWeight.Bold,
				fontSize = 30.sp
			)
			HorizontalDivider()
			Text(
				title,
				fontWeight = FontWeight.Bold,
				fontSize = 18.sp,
				modifier = Modifier.padding(top = 32.dp, bottom = 8.dp)
			)
			Text(
				description,
				fontSize = 18.sp,
				color = LocalContentColor.current.copy(alpha = 0.75f),
			)
			Button(
				onClick = {},
				modifier = Modifier.padding(vertical = 16.dp),
				shape = RoundedCornerShape(12.dp),
				contentPadding = PaddingValues(vertical = 16.dp, horizontal = 24.dp),
				colors = ButtonDefaults.buttonColors(containerColor = AccentColor)
			) {
				Text("Log in", fontSize = 16.sp)
			}
		}
	}
}

@Preview
@Composable
private fun EmptyMessagesPreview() {
	AirbnbCloneTheme {
		EmptyMessages()
	}
}

@Preview
@Composable
private fun EmptyTripsPreview() {
	AirbnbCloneTheme {
		EmptyTrips()
	}
}

@Preview
@Composable
private fun EmptyWishlistPreview() {
	AirbnbCloneTheme {

	}
}