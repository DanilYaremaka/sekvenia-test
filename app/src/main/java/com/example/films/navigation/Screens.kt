package com.example.films.navigation

import com.example.posters.ui.PostersFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
	fun Posters() = FragmentScreen { PostersFragment.newInstance() }
}