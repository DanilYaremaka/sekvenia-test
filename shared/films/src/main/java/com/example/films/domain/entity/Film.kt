package com.example.films.domain.entity

data class Film(
	val id: Int,
	val localizedNamed: String,
	val name: String,
	val year: Int,
	val rating: Float?,
	val imageUrl: String?,
	val description: String?,
	val genres: List<String>,
)
