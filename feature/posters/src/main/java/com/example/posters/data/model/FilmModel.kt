package com.example.posters.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FilmModel(
	val id: Int,
	@Json(name = "localized_name") val localizedNamed: String,
	val name: String,
	val year: Int,
	val rating: Float?,
	@Json(name = "image_url") val imageUrl: String?,
	val description: String?,
	val genres: List<String>,
)
