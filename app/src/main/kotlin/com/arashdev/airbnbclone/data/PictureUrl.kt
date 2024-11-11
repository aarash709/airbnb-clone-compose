package com.arashdev.airbnbclone.data

import kotlinx.serialization.Serializable

@Serializable
data class PictureUrl(
    val color_summary: List<String?>?,
    val etag: String?,
    val filename: String?,
    val format: String?,
    val height: Int?,
    val id: String?,
    val last_synchronized: String?,
    val mimetype: String?,
    val thumbnail: Boolean?,
    val width: Int?
)