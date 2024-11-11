package com.arashdev.airbnbclone.wishlist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Wishlist(modifier: Modifier = Modifier) {
	Box(
		modifier = Modifier.padding(horizontal = 24.dp),
		contentAlignment = Alignment.Center
	) { Text("Wishlist under construction 🚧") }
}