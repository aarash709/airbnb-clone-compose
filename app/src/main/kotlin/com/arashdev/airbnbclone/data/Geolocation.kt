package com.arashdev.airbnbclone.data

import kotlinx.serialization.Serializable

@Serializable
data class Geolocation(
    val lat: Double?,
    val lon: Double?
)