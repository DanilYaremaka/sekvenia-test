package com.example.posters.presentation

import com.example.films.domain.entity.Film

sealed interface PostersIntent {

	data class LoadData(val genre: String?) : PostersIntent

	data class ChangeGenre(val genre: String) : PostersIntent

	data class OpenFilmDetails(val film: Film) : PostersIntent
}