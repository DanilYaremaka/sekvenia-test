package com.example.posters.presentation

import com.example.films.domain.entity.Film

sealed interface PostersState {

	data object Initial : PostersState

	data object Loading : PostersState

	data class Content(
		val genres: Set<String>,
		val selectedGenre: String?,
		val posters: List<Film>,
		val filteredPosters: List<Film>
	) : PostersState
}