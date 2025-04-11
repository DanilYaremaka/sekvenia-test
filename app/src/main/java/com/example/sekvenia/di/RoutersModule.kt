package com.example.sekvenia.di

import com.example.details.presentation.DetailsRouter
import com.example.posters.presentation.PostersRouter
import com.example.sekvenia.navigation.routers.DetailsRouterImpl
import com.example.sekvenia.navigation.routers.PostersRouterImpl
import org.koin.dsl.module

val routerModule = module {
	single<PostersRouter> { PostersRouterImpl(get()) }
	single<DetailsRouter> { DetailsRouterImpl(get()) }
}