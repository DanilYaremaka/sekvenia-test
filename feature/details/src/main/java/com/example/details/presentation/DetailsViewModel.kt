package com.example.details.presentation

import androidx.lifecycle.ViewModel

class DetailsViewModel(
	private val router: DetailsRouter,
) : ViewModel() {

	fun handleNavigateBack() {
		router.navigateBack()
	}
}