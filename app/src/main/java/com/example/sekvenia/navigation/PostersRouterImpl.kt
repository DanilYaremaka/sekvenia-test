package com.example.sekvenia.navigation

import android.util.Log
import com.example.films.domain.entity.Film
import com.example.posters.presentation.PostersRouter
import com.github.terrakok.cicerone.Router

class PostersRouterImpl(
	private val router: Router
) : PostersRouter {

	override fun openFilmDetails(film: Film) {
		Log.d("navigate To", film.toString())
	}
}