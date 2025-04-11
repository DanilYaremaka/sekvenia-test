package com.example.posters.presentation

import com.example.films.domain.entity.Film

internal fun List<Film>.getFilteredPosters(genre: String?): List<Film> {
	return if (genre == null) this
		else this.filterByGenre(genre)
}

private fun List<Film>.filterByGenre(genre: String): List<Film> =
	this.filter { film -> film.genres.contains(genre.replaceFirstChar { it.lowercase() }) }