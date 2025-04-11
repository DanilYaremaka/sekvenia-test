package com.example.posters.presentation

import com.example.films.domain.entity.Film

internal fun List<Film>.filterByGenre(genre: String): List<Film> =
	this.filter { it.genres.contains(genre) }