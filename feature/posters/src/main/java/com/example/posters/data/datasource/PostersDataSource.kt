package com.example.posters.data.datasource

import com.example.posters.data.api.PostersApi
import com.example.posters.data.model.FilmsResponse

interface PostersDataSource {

	suspend fun getAllPosters(): FilmsResponse
}

class PostersDataSourceImpl(
	private val api: PostersApi
) : PostersDataSource {

	override suspend fun getAllPosters(): FilmsResponse =
		api.getAllPosters()
}