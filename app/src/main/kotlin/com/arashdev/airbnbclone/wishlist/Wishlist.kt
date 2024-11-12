package com.arashdev.airbnbclone.wishlist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arashdev.airbnbclone.components.NoLoginMessage

@Composable
fun Wishlist(modifier: Modifier = Modifier) {
	Scaffold(
		modifier = modifier.padding(vertical = 0.dp, horizontal = 24.dp),
	) { padding ->
		Column(modifier = Modifier.padding(padding)) {
			Column(modifier = Modifier) {
				Row(
					modifier = Modifier
						.fillMaxWidth()
						.padding(vertical = 16.dp),
					horizontalArrangement = Arrangement.End
				) {
					var text by remember { mutableStateOf("edit") }
					Text(
						text,
						modifier = Modifier.clickable {
							text = if (text != "edit") "edit" else "done"
						},
						color = Color.Black,
						textDecoration = TextDecoration.Underline
					)
				}
				Text(
					text = "Wishlists",
					color = Color.Black,
					fontSize = 30.sp,
					fontWeight = FontWeight.SemiBold
				)
			}
			NoLoginMessage(
				modifier = modifier,
				title = "Login to view your Wishlists",
				description = "You can create,view or edit Wishlists once you`ve logged in."
			)
		}
	}
}
