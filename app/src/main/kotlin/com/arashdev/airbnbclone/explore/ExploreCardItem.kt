package com.arashdev.airbnbclone.explore

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.arashdev.airbnbclone.R
import com.arashdev.airbnbclone.ui.theme.AirbnbCloneTheme

@Composable
fun ExploreCardItem(
	modifier: Modifier = Modifier,
	imageUrl: String,
	location: String,
	title: String,
	description: String,
	price: String,
	stars: Float
) {
	Column(modifier = modifier.clickable { }) {
//		Image(
//			painter = painterResource(R.drawable.ic_launcher_background),
//			modifier = Modifier
//				.aspectRatio(1f)
//				.clip(RoundedCornerShape(12.dp)),
//			contentDescription = null
//		)
		Box(
			Modifier
				.clip(RoundedCornerShape(12.dp))
				.aspectRatio(1f)
		) {
			val model = ImageRequest.Builder(LocalContext.current)
				.data(imageUrl)
				.crossfade(true)
				.build()
			AsyncImage(
				model = model,
				modifier = Modifier.fillMaxSize(),
				contentScale = ContentScale.Crop,
				contentDescription = null
			)
		}
		Row(
			modifier = Modifier
				.fillMaxWidth()
				.padding(top = 16.dp),
			horizontalArrangement = Arrangement.SpaceBetween
		) {
			Text(location, fontWeight = FontWeight.SemiBold)
			Row {
				Icon(Icons.Outlined.Star, contentDescription = null)
				Text((stars / 25).toString())
			}
		}
		Text(
			title,
			color = LocalContentColor.current.copy(alpha = 0.7f)
		)
		Text(
			description,
			color = LocalContentColor.current.copy(alpha = 0.7f)
		)
		Text(
			text = buildAnnotatedString {
				withStyle(
					style = SpanStyle(
						fontWeight = FontWeight.SemiBold,
						textDecoration = TextDecoration.Underline
					)
				) {
					append(price)
					append("$")
				}
				withStyle(
					style = SpanStyle(
						textDecoration = TextDecoration.Underline
					)
				) {
					append(" ")
					append("Total")
				}

			},
		)
	}
}

@Preview(showBackground = true)
@Composable
private fun AirbnbCardPreview() {
	AirbnbCloneTheme {
		ExploreCardItem(
			modifier = Modifier,
			title = "cozy house",
			description = "5 nights . 3-8 Jan",
			price = "100$, per night",
			stars = 45.0f,
			location = "California, US ",
			imageUrl = "http://www.bing.com/search?q=nulla",
		)
	}
}