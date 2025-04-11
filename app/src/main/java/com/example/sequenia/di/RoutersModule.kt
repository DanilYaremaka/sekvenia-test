package com.example.sequenia.di

import com.example.details.presentation.DetailsRouter
import com.example.posters.presentation.PostersRouter
import com.example.sequenia.navigation.routers.DetailsRouterImpl
import com.example.sequenia.navigation.routers.PostersRouterImpl
import org.koin.dsl.module

val routerModule = module {
	single<PostersRouter> { PostersRouterImpl(get()) }
	single<DetailsRouter> { DetailsRouterImpl(get()) }
}