package com.example.sekvenia.navigation

import com.example.films.domain.entity.Film
import com.example.posters.presentation.PostersRouter
import com.github.terrakok.cicerone.Router

class PostersRouterImpl(
	private val router: Router
) : PostersRouter {

	override fun openFilmDetails(film: Film) {
		router.navigateTo(Screens.FilmDetails(film))
	}
}