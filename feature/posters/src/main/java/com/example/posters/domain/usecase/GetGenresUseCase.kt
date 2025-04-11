package com.example.posters.domain.usecase

import com.example.films.domain.entity.Film
import com.example.posters.domain.repository.PostersRepository

class GetGenresUseCase(
	repository: PostersRepository
): (List<Film>) -> Set<String> by repository::getGenres