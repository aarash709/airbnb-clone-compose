package com.arashdev.airbnbclone.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowForwardIos
import androidx.compose.material.icons.automirrored.outlined.LibraryBooks
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.House
import androidx.compose.material.icons.outlined.QuestionMark
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arashdev.airbnbclone.ui.theme.AccentColor
import com.arashdev.airbnbclone.ui.theme.AirbnbCloneTheme

@Composable
fun Profile(modifier: Modifier = Modifier) {
	Column(
		modifier = modifier
			.fillMaxSize()
	) {
		Column(modifier = Modifier.padding(horizontal = 24.dp)) {
			Text(
				text = "Your Profile",
				modifier = Modifier.padding(top = 32.dp),
				fontSize = 35.sp,
				fontWeight = FontWeight.SemiBold
			)
			Text(
				"Login to start planing your next trip",
				color = LocalContentColor.current.copy(alpha = 0.6f),
				fontSize = 18.sp
			)
		}
		LoginButton()
		Row(
			modifier = Modifier
				.fillMaxWidth()
				.padding(horizontal = 24.dp)
		) {
			Text(text = buildAnnotatedString {
				withStyle(
					style = SpanStyle(
						color = LocalContentColor.current.copy(alpha = 0.8f),
						fontSize = 14.sp
					)
				) {
					append("Don`t have an account?")
					append(" ")
				}
				withStyle(
					style = SpanStyle(
						fontWeight = FontWeight.SemiBold,
						textDecoration = TextDecoration.Underline
					)
				) {
					append("Signup")
				}
			}, color = LocalContentColor.current.copy(alpha = 0.8f), fontSize = 14.sp)
		}
		LazyColumn(
			modifier = Modifier,
			contentPadding = PaddingValues(top = 24.dp, bottom = 16.dp)
		) {
			item {
				ProfileItem(leadingIcon = Icons.Outlined.Settings, label = "Settings")
				ProfileItem(leadingIcon = Icons.Outlined.AccountCircle, label = "Accessibility")
				ProfileItem(leadingIcon = Icons.Outlined.House, label = "Learn about housing")
				ProfileItem(leadingIcon = Icons.Outlined.QuestionMark, label = "Get help")
				ProfileItem(
					leadingIcon = Icons.AutoMirrored.Outlined.LibraryBooks,
					label = "Terms of Service"
				)
				ProfileItem(
					leadingIcon = Icons.AutoMirrored.Outlined.LibraryBooks,
					label = "Privacy Policy"
				)
				ProfileItem(
					leadingIcon = Icons.AutoMirrored.Outlined.LibraryBooks,
					label = "Open source licences"
				)
			}
		}
		Text("version 1.0", fontSize = 14.sp, modifier = Modifier.padding(horizontal = 24.dp))
	}
}

@Composable
fun ProfileItem(
	modifier: Modifier = Modifier,
	leadingIcon: ImageVector,
	label: String,
) {
	Surface(onClick = {}, modifier = modifier, color = Color.Transparent) {
		Column {
			Row(
				modifier = modifier
					.fillMaxWidth()
					.padding(vertical = 16.dp, horizontal = 24.dp),
				horizontalArrangement = Arrangement.SpaceBetween
			) {
				Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
					Icon(imageVector = leadingIcon, contentDescription = null)
					Text(label)
				}
				Icon(
					imageVector = Icons.AutoMirrored.Outlined.ArrowForwardIos,
					modifier = Modifier.size(18.dp),
					contentDescription = null
				)
			}
			HorizontalDivider()
		}
	}
}

@Composable
private fun LoginButton(modifier: Modifier = Modifier) {
	Button(
		onClick = {},
		modifier = modifier
			.fillMaxWidth()
			.padding(top = 48.dp, bottom = 24.dp, start = 24.dp, end = 24.dp),
		shape = RoundedCornerShape(8.dp),
		colors = ButtonDefaults.buttonColors(containerColor = AccentColor),
		contentPadding = PaddingValues(vertical = 16.dp)
	) {
		Row {
			Text(text = "Login", fontSize = 16.sp)
		}
	}
}

@Preview(showBackground = true)
@Composable
private fun ProfilePreview(modifier: Modifier = Modifier) {
	AirbnbCloneTheme {
		Profile()
	}
}