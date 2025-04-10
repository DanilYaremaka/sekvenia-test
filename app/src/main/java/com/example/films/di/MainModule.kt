package com.example.films.di

import com.example.films.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
	viewModel<MainViewModel> { MainViewModel(get()) }
}