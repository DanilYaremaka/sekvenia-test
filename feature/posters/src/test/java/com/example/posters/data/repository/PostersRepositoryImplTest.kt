package com.example.posters.data.repository

import com.example.films.domain.entity.Film
import com.example.posters.data.datasource.PostersDataSource
import com.example.posters.data.model.FilmModel
import com.example.posters.data.model.FilmsResponse
import com.example.posters.domain.repository.PostersRepository
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.mockito.Mockito.mock
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.whenever
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PostersRepositoryImplTest {

	private val dataSource: PostersDataSource = mock()

	private val repository: PostersRepository = PostersRepositoryImpl(dataSource)

	private val filmModels = listOf(
		FilmModel(
			id = 1,
			description = "фильм вау",
			genres = listOf("комедия", "ужасы"),
			imageUrl = null,
			localizedName = "Крутой фильм",
			name = "Крутой фильм",
			rating = 2.1f,
			year = 2020,
		),
		FilmModel(
			id = 2,
			description = "фильм не оч",
			genres = listOf("комедия", "драма"),
			imageUrl = null,
			localizedName = "Плохой фильм",
			name = "Плохой фильм",
			rating = 2.1f,
			year = 2020,
		)
	)

	private val filmsEntity = listOf(
		Film(
			id = 1,
			description = "фильм вау",
			genres = listOf("комедия", "ужасы"),
			imageUrl = null,
			localizedName = "Крутой фильм",
			name = "Крутой фильм",
			rating = 2.1f,
			year = 2020,
		),
		Film(
			id = 2,
			description = "фильм не оч",
			genres = listOf("комедия", "драма"),
			imageUrl = null,
			localizedName = "Плохой фильм",
			name = "Плохой фильм",
			rating = 2.1f,
			year = 2020,
		)
	)

	@Test
	fun `load data EXPECT list of films`() = runTest {
		whenever(dataSource.getAllPosters()) doReturn FilmsResponse(filmModels)
		val expected = filmsEntity

		val actual = repository.getAllPosters()

		assertEquals(expected, actual)
	}

	@ParameterizedTest
	@MethodSource("provide data")
	fun `get genres EXPECT set of genres`(films: List<Film>, expected: Set<String>) {
		assertEquals(expected, repository.getGenres(films))
	}

	private fun `provide data`(): Stream<Arguments?>? {
		return Stream.of(
			Arguments.of(
				listOf(
					Film(
						id = 1,
						description = "фильм вау",
						genres = listOf("комедия", "ужасы"),
						imageUrl = null,
						localizedName = "Крутой фильм",
						name = "Крутой фильм",
						rating = 2.1f,
						year = 2020,
					),
					Film(
						id = 2,
						description = "фильм не оч",
						genres = listOf("комедия", "драма"),
						imageUrl = null,
						localizedName = "Плохой фильм",
						name = "Плохой фильм",
						rating = 2.1f,
						year = 2020,
					),
				),
				setOf("Драма", "Комедия", "Ужасы")
			),
			Arguments.of(
				listOf(
					Film(
						id = 2,
						description = "фильм не оч",
						genres = listOf("комедия", "драма"),
						imageUrl = null,
						localizedName = "Плохой фильм",
						name = "Плохой фильм",
						rating = 2.1f,
						year = 2020,
					),
				),
				setOf("Драма", "Комедия")
			),
			Arguments.of(
				listOf(
					Film(
						id = 1,
						description = "фильм вау",
						genres = emptyList(),
						imageUrl = null,
						localizedName = "Крутой фильм",
						name = "Крутой фильм",
						rating = 2.1f,
						year = 2020,
					),
					Film(
						id = 2,
						description = "фильм не оч",
						genres = emptyList(),
						imageUrl = null,
						localizedName = "Плохой фильм",
						name = "Плохой фильм",
						rating = 2.1f,
						year = 2020,
					),
				),
				emptySet<String>()
			)
		)
	}
}