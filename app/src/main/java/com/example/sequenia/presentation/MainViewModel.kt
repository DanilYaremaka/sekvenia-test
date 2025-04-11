package com.example.sequenia.presentation

import androidx.lifecycle.ViewModel
import com.example.sequenia.navigation.Screens
import com.github.terrakok.cicerone.Router

class MainViewModel(
	private val router: Router
) : ViewModel() {

	fun openStartScreen() {
		router.newRootScreen(Screens.Posters())
	}
}