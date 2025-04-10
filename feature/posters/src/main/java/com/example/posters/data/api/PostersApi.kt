package com.example.posters.data.api

import com.example.posters.data.model.FilmsResponse
import retrofit2.http.GET

interface PostersApi {

	@GET("/sequeniatesttask/films.json")
	suspend fun getAllPosters(): FilmsResponse
}