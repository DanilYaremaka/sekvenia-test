package com.example.posters.data.datasource

import com.example.posters.data.api.PostersApi
import com.example.posters.data.model.FilmModel

interface PostersDataSource {

	suspend fun getAllPosters(): List<FilmModel>
}

class PostersDataSourceImpl(
	private val api: PostersApi
) : PostersDataSource {

	override suspend fun getAllPosters(): List<FilmModel> =
		api.getAllPosters()
}