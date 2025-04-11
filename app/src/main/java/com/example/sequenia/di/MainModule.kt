package com.example.sequenia.di

import com.example.sequenia.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
	viewModel<MainViewModel> { MainViewModel(get()) }
}