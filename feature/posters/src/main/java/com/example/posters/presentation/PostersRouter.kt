package com.example.posters.presentation

import com.example.films.domain.entity.Film

interface PostersRouter {

	fun openFilmDetails(film: Film)
}