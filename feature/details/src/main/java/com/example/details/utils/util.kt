package com.example.details.utils

import com.example.films.domain.entity.Film

internal fun Film.getGenresAndYear(): String {
	if (genres.isEmpty())
		return year.toString()
	return "${genres.joinToString(", ") { genre -> genre.replaceFirstChar { it.lowercase() } }}, $year год"
}