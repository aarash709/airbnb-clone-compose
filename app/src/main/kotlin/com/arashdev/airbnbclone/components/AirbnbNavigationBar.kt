package com.arashdev.airbnbclone.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.ChatBubbleOutline
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.arashdev.airbnbclone.navigation.Explore
import com.arashdev.airbnbclone.navigation.Messages
import com.arashdev.airbnbclone.navigation.Profile
import com.arashdev.airbnbclone.navigation.Trips
import com.arashdev.airbnbclone.navigation.Wishlist
import com.arashdev.airbnbclone.ui.theme.AccentColor
import com.arashdev.airbnbclone.ui.theme.AirbnbCloneTheme

@Composable
fun AirbnbNavigationBar(
	modifier: Modifier = Modifier,
	navController: NavController,
) {
	val currentBackStackEntry by navController.currentBackStackEntryAsState()
	NavigationBar(
		modifier = modifier
			.padding(top = 4.dp)
			.height(70.dp),
		containerColor = MaterialTheme.colorScheme.background
	) {
		Row(
			modifier = Modifier
				.fillMaxWidth()
				.padding(horizontal = 24.dp),
			horizontalArrangement = Arrangement.SpaceBetween
		) {
			items.forEach { topLevelDestination ->
				val onClick = {
					navController.navigate(topLevelDestination.route) {
						popUpTo(navController.graph.findStartDestination().id) {
							saveState = true
						}
						restoreState = true
						launchSingleTop = true

					}
				}
				val selected =
					currentBackStackEntry?.destination?.hierarchy?.any {
						it.hasRoute(topLevelDestination.route::class)
					} == true
				val fontWeight = if (selected) FontWeight.SemiBold else FontWeight.Normal
				val unselectedColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
				val color =
					if (selected) AccentColor else unselectedColor
				AirbnbNavigationBarItem(
					modifier = Modifier.selectable(
						selected = selected,
						enabled = true,
						onClick = { onClick() }
					),
					icon = {
						Icon(
							imageVector = topLevelDestination.icon,
							tint = color,
							contentDescription = topLevelDestination.label
						)
					},
					label = {
						Text(
							text = topLevelDestination.label,
							fontWeight = fontWeight,
							fontSize = 12.sp,
							color = color
						)
					}
				)
			}
		}
	}
}

@Composable
private fun RowScope.AirbnbNavigationBarItem(
	modifier: Modifier = Modifier,
	icon: @Composable () -> Unit,
	label: @Composable () -> Unit
) {
	Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
		icon()
		label()
	}
}

data class NavBarItem<T : Any>(val icon: ImageVector, val route: T, val label: String)

val items = listOf(
	NavBarItem(
		icon = Icons.Outlined.Search,
		route = Explore,
		label = "Explore"
	),
	NavBarItem(
		icon = Icons.Outlined.FavoriteBorder,
		route = Wishlist,
		label = "Wishlist"
	),
	NavBarItem(
		icon = Icons.Outlined.CheckCircle,
		route = Trips,
		label = "Trips"
	),
	NavBarItem(
		icon = Icons.Outlined.ChatBubbleOutline,
		route = Messages,
		label = "Messages"
	),
	NavBarItem(
		icon = Icons.Outlined.AccountCircle,
		route = Profile,
		label = "Profile"
	),
)

@Preview
@Composable
private fun NavigationBarPreview() {
	AirbnbCloneTheme {
		AirbnbNavigationBar(
			modifier = Modifier,
			navController = rememberNavController()
		)
	}
}