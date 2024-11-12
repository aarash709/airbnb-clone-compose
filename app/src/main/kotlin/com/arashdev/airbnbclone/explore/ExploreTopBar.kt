package com.arashdev.airbnbclone.explore

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Tune
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arashdev.airbnbclone.ui.theme.AirbnbCloneTheme


@Composable
fun ExploreTopBar(modifier: Modifier = Modifier) {
	Row(
		modifier = modifier
			.fillMaxWidth()
			.padding(start = 24.dp, top = 8.dp, end = 24.dp, bottom = 16.dp),
		verticalAlignment = Alignment.CenterVertically,
		horizontalArrangement = Arrangement.SpaceBetween
	) {
		ElevatedButton(
			onClick = {},
			modifier = Modifier.weight(1f),
			colors = ButtonDefaults.elevatedButtonColors(containerColor = MaterialTheme.colorScheme.background),
			elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 8.dp)
		) {
			Row(
				modifier = Modifier.fillMaxWidth(),
				horizontalArrangement = Arrangement.Start,
				verticalAlignment = Alignment.CenterVertically
			) {
				Icon(
					imageVector = Icons.Outlined.Search,
					modifier = Modifier.size(30.dp),
					contentDescription = "search"
				)
				Column(
					modifier = Modifier.padding(horizontal = 8.dp),
					verticalArrangement = Arrangement.Center,
				) {
					Text(
						text = "Where to?",
						fontWeight = FontWeight.SemiBold,
						fontSize = 15.sp,
						maxLines = 1,
						overflow = TextOverflow.Ellipsis
					)
					Text(
						"Anywhere . Any week . Any guests",
						fontSize = 12.sp,
						color = Color.Gray,
						maxLines = 1,
						overflow = TextOverflow.Ellipsis
					)
				}
			}
		}
		OutlinedButton(
			onClick = {},
			modifier
				.padding(start = 8.dp)
				.width(40.dp)
				.aspectRatio(1f),
			shape = CircleShape,
			contentPadding = PaddingValues(0.dp)
		) {
			Icon(
				imageVector = Icons.Outlined.Tune,
				modifier = Modifier.size(20.dp),
				contentDescription = null
			)
		}
	}
}

@Preview(showBackground = true)
@Composable
private fun AirbnbTopBarPreview() {
	AirbnbCloneTheme {
		ExploreTopBar()
	}
}