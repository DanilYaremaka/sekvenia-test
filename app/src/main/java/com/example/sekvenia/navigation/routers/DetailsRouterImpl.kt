package com.example.sekvenia.navigation.routers

import com.example.details.presentation.DetailsRouter
import com.github.terrakok.cicerone.Router

class DetailsRouterImpl(private val router: Router) : DetailsRouter {

	override fun navigateBack() {
		router.backTo(null)
	}
}