package com.example.sekvenia.di

import com.example.posters.presentation.PostersRouter
import com.example.sekvenia.navigation.PostersRouterImpl
import org.koin.dsl.module

val routerModule = module {
	single<PostersRouter> { PostersRouterImpl(get()) }
}