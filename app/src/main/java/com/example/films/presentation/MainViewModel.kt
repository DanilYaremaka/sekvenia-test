package com.example.films.presentation

import androidx.lifecycle.ViewModel
import com.example.films.navigation.Screens
import com.github.terrakok.cicerone.Router

class MainViewModel(
	private val router: Router
) : ViewModel() {

	fun openFragment() {
		router.newRootScreen(Screens.Posters())
	}
}