package com.arashdev.airbnbclone.explore

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.arashdev.airbnbclone.R
import com.arashdev.airbnbclone.data.AirbnbDataItem
import com.arashdev.airbnbclone.data.rawData
import com.arashdev.airbnbclone.ui.theme.AccentColor
import com.arashdev.airbnbclone.ui.theme.AirbnbCloneTheme
import kotlinx.serialization.json.Json

@Composable
fun Details(modifier: Modifier = Modifier, id: Int, onBackPressed: () -> Unit) {
	var data: AirbnbDataItem? by remember {
		mutableStateOf(null)
	}
	LaunchedEffect(true) {
		data = Json.decodeFromString<List<AirbnbDataItem>>(rawData).first { it.id?.toInt() == id }
	}
	Scaffold(
		modifier = modifier,
		topBar = { /*DetailsTopBar()*/ },
		bottomBar = { DetailsBottomBar() },
		contentWindowInsets = WindowInsets(0, 0, 0, 0)
	) { padding ->
		val scrollState = rememberScrollState()
		Box(
			modifier = Modifier
				.fillMaxSize()
				.padding(padding)
				.verticalScroll(state = scrollState)
		) {
			Column(
				modifier = Modifier
					.fillMaxSize()
			) {
				AsyncImage(
					model = data?.xl_picture_url,
					modifier = Modifier
						.aspectRatio(16 / 9f),
					contentScale = ContentScale.Crop,
					contentDescription = null
				)
				Column(modifier = Modifier.padding(horizontal = 24.dp)) {
					Text(
						data?.name.toString(),
						modifier = Modifier.padding(vertical = 24.dp),
						fontSize = 24.sp
					)
					Text(
						text = data?.smart_location.toString(),
						fontSize = 16.sp,
						fontWeight = FontWeight.Bold
					)
					Spacer(Modifier.height(4.dp))
					Text(
						buildAnnotatedString {
							append(data?.guests_included.toString())
							append("guests")
							append(" ")
							append(" · ")
							append(data?.bedrooms.toString())
							append("bedrooms")
							append(" · ")
							append(" ")
							append(data?.beds.toString())
							append("beds")
							append(" · ")
							append(" ")
							append(data?.bathrooms.toString())
							append("bathrooms")
						},
						fontSize = 16.sp
					)
					Spacer(Modifier.height(8.dp))
					Row(verticalAlignment = Alignment.CenterVertically) {
						Icon(Icons.Outlined.Star, contentDescription = null)
						Text(text = buildAnnotatedString {
							append(" ")
							append(data?.review_scores_rating?.toFloat()?.div(25).toString())
							append(" · ")
							withStyle(
								style = SpanStyle(
									textDecoration = TextDecoration.Underline,
									fontWeight = FontWeight.SemiBold
								)
							) {
								append(data?.number_of_reviews.toString())
								append(" ")
								append("reviews")
							}
						})
					}
					HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp))
					Row(
						verticalAlignment = Alignment.CenterVertically,
						horizontalArrangement = Arrangement.spacedBy(8.dp)
					) {
						AsyncImage(
							model = data?.host_picture_url,
							modifier = Modifier
								.size(40.dp)
								.clip(
									CircleShape
								),
							placeholder = painterResource(R.drawable.baseline_person_24),
							contentDescription = null
						)
						Text(text = buildAnnotatedString {
							withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
								append("hosted by")
								append(" ")
								append(data?.host_name.toString())
							}
						})
					}
					HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp))
					Text(data?.description.toString(), fontSize = 16.sp)
				}
			}
		}
		DetailsTopBar(onBackPressed = onBackPressed)
	}
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsTopBar(modifier: Modifier = Modifier, onBackPressed: () -> Unit) {
	val containerColor = MaterialTheme.colorScheme.background
	TopAppBar(
		modifier = modifier,
		navigationIcon = {
			IconButton(
				onClick = { onBackPressed() },
				colors = IconButtonDefaults.iconButtonColors(containerColor = Color.White)
			) {
				Icon(
					Icons.AutoMirrored.Outlined.ArrowBack,
					tint = Color.Black,
					contentDescription = null
				)
			}
		},
		title = { },
		actions = {
			IconButton(
				onClick = {},
				colors = IconButtonDefaults.iconButtonColors(containerColor = containerColor)
			) {
				Icon(imageVector = Icons.Outlined.Share, contentDescription = null)
			}
			IconButton(
				onClick = {},
				colors = IconButtonDefaults.iconButtonColors(containerColor = containerColor)
			) {
				Icon(imageVector = Icons.Outlined.FavoriteBorder, contentDescription = null)
			}
		},
		colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent)
	)
}

@Composable
fun DetailsBottomBar(modifier: Modifier = Modifier) {
	BottomAppBar(modifier = modifier) {
		Row(
			Modifier
				.fillMaxWidth()
				.padding(horizontal = 24.dp),
			verticalAlignment = Alignment.CenterVertically,
			horizontalArrangement = Arrangement.SpaceBetween
		) {
			Text("50$", textDecoration = TextDecoration.Underline, fontWeight = FontWeight.SemiBold)
			Button(
				onClick = {},
				modifier = Modifier
					.fillMaxHeight()
					.padding(vertical = 16.dp),
				shape = RoundedCornerShape(8.dp),
				contentPadding = PaddingValues(vertical = 0.dp, horizontal = 32.dp),
				colors = ButtonDefaults.buttonColors(containerColor = AccentColor)
			) {
				Text("Reserve", fontSize = 14.sp)
			}
		}
	}
}

@Preview
@Composable
private fun DetailsPrev() {
	AirbnbCloneTheme {
		val id = Json.decodeFromString<List<AirbnbDataItem>>(rawData).first().id?.toInt()
		Details(id = id!!, onBackPressed = {})
	}
}