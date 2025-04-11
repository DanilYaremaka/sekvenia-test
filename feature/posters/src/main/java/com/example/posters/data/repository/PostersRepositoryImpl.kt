package com.example.posters.data.repository

import com.example.films.domain.entity.Film
import com.example.posters.data.datasource.PostersDataSource
import com.example.posters.data.mapper.toEntity
import com.example.posters.domain.repository.PostersRepository

class PostersRepositoryImpl(
	private val remoteDataSource: PostersDataSource
): PostersRepository {

	override fun getGenres(films: List<Film>): Set<String> {
		val genres = mutableSetOf<String>()
		films.forEach { film ->
			film.genres.forEach { genre ->
				genres.add(genre.replaceFirstChar { it.uppercaseChar() })
			}
		}
		return genres.sorted().toSet()
	}

	override suspend fun getAllPosters(): List<Film> =
		remoteDataSource.getAllPosters().films.map { it.toEntity() }.sortedBy { it.localizedNamed }
}