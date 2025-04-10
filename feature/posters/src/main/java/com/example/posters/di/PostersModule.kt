package com.example.posters.di

import com.example.posters.data.api.PostersApi
import com.example.posters.data.datasource.PostersDataSource
import com.example.posters.data.datasource.PostersDataSourceImpl
import com.example.posters.data.repository.PostersRepositoryImpl
import com.example.posters.domain.repository.PostersRepository
import com.example.posters.domain.usecase.GetAllPostersUseCase
import com.example.posters.domain.usecase.GetGenresUseCase
import com.example.posters.presentation.PostersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val postersModule = module {
	single { get<Retrofit>().create(PostersApi::class.java) }

	single<PostersRepository> { PostersRepositoryImpl(get()) }
	single<PostersDataSource> { PostersDataSourceImpl(get()) }

	single { GetAllPostersUseCase(get()) }
	single { GetGenresUseCase(get()) }

	viewModel { PostersViewModel(get()) }
}