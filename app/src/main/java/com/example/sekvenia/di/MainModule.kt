package com.example.sekvenia.di

import com.example.sekvenia.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
	viewModel<MainViewModel> { MainViewModel(get()) }
}