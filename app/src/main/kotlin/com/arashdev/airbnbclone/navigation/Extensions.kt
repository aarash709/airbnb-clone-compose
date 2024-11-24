package com.arashdev.airbnbclone.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.arashdev.airbnbclone.Trips.Trips
import com.arashdev.airbnbclone.explore.Explore
import com.arashdev.airbnbclone.messages.Messages
import com.arashdev.airbnbclone.profile.Profile
import com.arashdev.airbnbclone.wishlist.Wishlist

fun NavGraphBuilder.mainNavigationScreens(
	onExploreItemClicked: (Int) -> Unit
) {
	navigation<ExploreNavGraph>(startDestination = Explore) {
		composable<Explore>(
			enterTransition = { EnterTransition.None },
			exitTransition = { ExitTransition.None }
		) {
			Explore(onItemClicked = {
				onExploreItemClicked(it)
			})
		}
		composable<Wishlist>(
			enterTransition = { EnterTransition.None },
			exitTransition = { ExitTransition.None }
		) { Wishlist() }
		composable<Trips>(
			enterTransition = { EnterTransition.None },
			exitTransition = { ExitTransition.None }
		) { Trips() }
		composable<Messages>(
			enterTransition = { EnterTransition.None },
			exitTransition = { ExitTransition.None }
		) { Messages() }
		composable<Profile>(
			enterTransition = { EnterTransition.None },
			exitTransition = { ExitTransition.None }
		) { Profile() }
	}
}