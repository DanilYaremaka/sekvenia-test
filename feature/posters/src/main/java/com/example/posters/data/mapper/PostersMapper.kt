package com.example.posters.data.mapper

import com.example.films.domain.entity.Film
import com.example.posters.data.model.FilmModel

internal fun FilmModel.toEntity() = Film(
	id = id,
	description = description,
	genres = genres,
	imageUrl = imageUrl,
	localizedName = localizedNamed,
	name = name,
	rating = rating,
	year = year
)