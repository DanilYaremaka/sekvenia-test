package com.example.posters.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FilmsResponse(
	val films: List<FilmModel>
)
