package com.example.posters.domain.repository

import com.example.films.domain.entity.Film

interface PostersRepository {

	fun getGenres(films: List<Film>): Set<String>

	suspend fun getAllPosters(): List<Film>
}