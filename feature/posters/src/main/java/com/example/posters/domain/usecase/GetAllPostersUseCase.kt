package com.example.posters.domain.usecase

import com.example.films.domain.entity.Film
import com.example.posters.domain.repository.PostersRepository

class GetAllPostersUseCase(
	repository: PostersRepository
): suspend () -> List<Film> by repository::getAllPosters