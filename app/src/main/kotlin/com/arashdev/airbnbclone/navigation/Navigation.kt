package com.arashdev.airbnbclone.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.arashdev.airbnbclone.components.EmptyMessages
import com.arashdev.airbnbclone.components.EmptyTrips
import com.arashdev.airbnbclone.profile.Profile
import com.arashdev.airbnbclone.explore.ExploreScreen
import com.arashdev.airbnbclone.wishlist.Wishlist
import kotlinx.serialization.Serializable

@Composable
fun AirbnbNavHost(
	modifier: Modifier = Modifier,
	navController: NavHostController = rememberNavController()
) {
	NavHost(
		navController = navController,
		startDestination = Explore,
		modifier = modifier
	) {
		composable<Explore>(
			enterTransition = { EnterTransition.None },
			exitTransition = { ExitTransition.None }
		) { ExploreScreen() }
		composable<Wishlist>(
			enterTransition = { EnterTransition.None },
			exitTransition = { ExitTransition.None }
		) { Wishlist() }
		composable<Trips>(
			enterTransition = { EnterTransition.None },
			exitTransition = { ExitTransition.None }
		) { EmptyTrips() }
		composable<Messages>(
			enterTransition = { EnterTransition.None },
			exitTransition = { ExitTransition.None }
		) { EmptyMessages() }
		composable<Profile>(
			enterTransition = { EnterTransition.None },
			exitTransition = { ExitTransition.None }
		) { Profile() }
	}
}

@Serializable
object Trips

@Serializable
object Messages

@Serializable
object Explore

@Serializable
object Profile

@Serializable
object Wishlist