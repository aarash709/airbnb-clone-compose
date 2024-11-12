package com.arashdev.airbnbclone.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SevereCold
import androidx.compose.material.icons.outlined.Apartment
import androidx.compose.material.icons.outlined.BeachAccess
import androidx.compose.material.icons.outlined.DirectionsBus
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LocalFireDepartment
import androidx.compose.material.icons.outlined.SevereCold
import androidx.compose.material.icons.outlined.Surfing
import androidx.compose.material.icons.outlined.VideogameAsset
import androidx.compose.ui.graphics.vector.ImageVector

data class Categorie(val name: String, val icon: ImageVector)

val categories = listOf(
	Categorie(name = "Tiny homes", Icons.Outlined.Home),
	Categorie(name = "Trending", Icons.Outlined.LocalFireDepartment),
	Categorie(name = "Arctic", Icons.Outlined.SevereCold),
	Categorie(name = "City", Icons.Outlined.Apartment),
	Categorie(name = "Surfing", Icons.Outlined.Surfing),
	Categorie(name = "Beach front", Icons.Outlined.BeachAccess),
	Categorie(name = "Play", Icons.Outlined.VideogameAsset),
	Categorie(name = "Camper vans", Icons.Outlined.DirectionsBus),
)