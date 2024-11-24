package com.arashdev.airbnbclone.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.arashdev.airbnbclone.components.AirbnbNavigationBar
import com.arashdev.airbnbclone.explore.Details
import kotlinx.serialization.Serializable

@Composable
fun AirbnbNavHost(
	modifier: Modifier = Modifier,
	rootNavController: NavHostController = rememberNavController()
) {
	NavHost(
		navController = rootNavController,
		startDestination = ExploreNavGraph,
		modifier = modifier,
	) {
		composable<ExploreNavGraph>(
			enterTransition = {
				if (initialState.destination.hasRoute<DetailsNavGraph>())
					slideInHorizontally { -it / 3 }
				else EnterTransition.None
			},
			exitTransition = {
				if (targetState.destination.hasRoute<DetailsNavGraph>())
					slideOutHorizontally { -it / 3 }
				else ExitTransition.None
			}
		) {
			val exploreNavController = rememberNavController()
			Scaffold(bottomBar = {
				AirbnbNavigationBar(
					navController = exploreNavController
				)
			}) { padding ->
				Box(modifier = Modifier.padding(padding).systemBarsPadding()) {
					NavHost(
						startDestination = ExploreNavGraph,
						navController = exploreNavController,
					) {
						mainNavigationScreens(onExploreItemClicked = {
							rootNavController.navigate(
								Details(it)
							)
						})
					}
				}
			}
		}
		composable<Details>(
			enterTransition = { slideInHorizontally { it / 3 } },
			exitTransition = { slideOutHorizontally { it / 3 } }
		) { backstackEntry ->
			val id = backstackEntry.toRoute<Details>().id
			Details(
				id = id,
				onBackPressed = {
					rootNavController.popBackStack()
				})
		}
	}
}


@Serializable
data object ExploreNavGraph

@Serializable
data object DetailsNavGraph

@Serializable
data class Details(val id: Int)

@Serializable
data object Trips

@Serializable
data object Messages

@Serializable
data object Explore

@Serializable
data object Profile

@Serializable
data object Wishlist


