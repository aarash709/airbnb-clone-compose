package com.arashdev.airbnbclone.wishlist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Tune
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arashdev.airbnbclone.components.EmptyWishlist

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Wishlist(modifier: Modifier = Modifier) {
	Scaffold(
		modifier = modifier.padding(vertical = 14.dp, horizontal = 24.dp),
		topBar = {
			MediumTopAppBar(
				title = {
					Text(
						text = "Wishlists",
						color = Color.Black,
						fontSize = 30.sp,
						fontWeight = FontWeight.SemiBold
					)
				},
				actions = {
					Text(
						"edit",
						color = Color.Black,
						textDecoration = TextDecoration.Underline
					)
				},
				colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = MaterialTheme.colorScheme.background)
			)
		}
	) { padding ->
		Column(modifier = Modifier.padding(padding)) {
			EmptyWishlist()
		}
	}

}
