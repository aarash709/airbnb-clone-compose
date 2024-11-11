package com.arashdev.airbnbclone.explore

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.TimeToLeave
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PrimaryScrollableTabRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arashdev.airbnbclone.data.AirbnbDataItem
import com.arashdev.airbnbclone.data.rawData
import com.arashdev.airbnbclone.ui.theme.AirbnbCloneTheme
import kotlinx.serialization.json.Json

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExploreScreen(modifier: Modifier = Modifier) {
	var data: List<AirbnbDataItem> by remember {
		mutableStateOf(listOf())
	}
	LaunchedEffect(true) {
		data = Json.decodeFromString<List<AirbnbDataItem>>(rawData)
	}
	Scaffold(
		modifier = modifier,
		topBar = { ExploreTopBar() }
	) { padding ->
		Column(
			modifier = Modifier
				.fillMaxSize()
				.padding(padding)
		) {
			var selectedIndex by remember { mutableIntStateOf(0) }

			PrimaryScrollableTabRow(
				selectedTabIndex = selectedIndex,
				edgePadding = 0.dp,
				containerColor = MaterialTheme.colorScheme.background,
				divider = {}
			) {
				repeat(5) {
					val selected = selectedIndex == it
					val selectedColor =
						if (selected) LocalContentColor.current else LocalContentColor.current.copy(
							alpha = 0.5f
						)
					Tab(selected = selected, onClick = { selectedIndex = it }) {
						Column(
							Modifier,
							horizontalAlignment = Alignment.CenterHorizontally
						) {
							Icon(Icons.Default.TimeToLeave, null, tint = selectedColor)
							Text("text", color = selectedColor)
						}
					}
				}
			}
			LazyColumn(
				modifier = Modifier
					.fillMaxSize(),
				contentPadding = PaddingValues(24.dp),
				verticalArrangement = Arrangement.spacedBy(32.dp)
			) {
				data.forEach { airbnbData ->
					item {
						ExploreCardItem(
							modifier = Modifier.fillMaxWidth(),
							imageUrl = airbnbData.xl_picture_url!!,
							location = airbnbData.host_location ?: "",
							title = airbnbData.name ?: "",
							description = "Hosted by ${airbnbData.host_name}",
							price = "${airbnbData.price ?: ""}$",
							stars = airbnbData.review_scores_rating!!.toFloat()
						)
					}
				}
			}
		}
	}
}

@Preview(showBackground = true)
@Composable
private fun ExplorePreview() {
	AirbnbCloneTheme {
		ExploreScreen()
	}
}