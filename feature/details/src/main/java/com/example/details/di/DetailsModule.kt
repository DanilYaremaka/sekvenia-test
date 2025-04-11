package com.example.details.di

import com.example.details.presentation.DetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val detailsModule = module {
	viewModel { DetailsViewModel(router = get()) }
}