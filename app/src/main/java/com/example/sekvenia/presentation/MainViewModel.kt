package com.example.sekvenia.presentation

import androidx.lifecycle.ViewModel
import com.example.sekvenia.navigation.Screens
import com.github.terrakok.cicerone.Router

class MainViewModel(
	private val router: Router
) : ViewModel() {

	fun openFragment() {
		router.newRootScreen(Screens.Posters())
	}
}