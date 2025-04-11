package com.example.sequenia.navigation

import com.example.details.ui.DetailsFragment
import com.example.films.domain.entity.Film
import com.example.posters.ui.PostersFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
	fun Posters() = FragmentScreen { PostersFragment.newInstance() }
	fun FilmDetails(film: Film) = FragmentScreen { DetailsFragment.newInstance(film) }
}