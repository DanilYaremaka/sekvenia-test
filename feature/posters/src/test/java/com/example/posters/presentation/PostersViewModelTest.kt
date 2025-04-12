package com.example.posters.presentation

import app.cash.turbine.test
import com.example.films.domain.entity.Film
import com.example.posters.domain.usecase.GetAllPostersUseCase
import com.example.posters.domain.usecase.GetGenresUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.awaitCancellation
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.any
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.doSuspendableAnswer
import org.mockito.kotlin.doThrow
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class PostersViewModelTest {

	private val getAllPostersUseCase: GetAllPostersUseCase = mock()
	private val getGenresUseCase: GetGenresUseCase = mock()
	private val router: PostersRouter = mock()

	private val viewModel = PostersViewModel(getAllPostersUseCase, getGenresUseCase, router)

	private val film = Film(
		id = 1,
		description = "фильм вау",
		genres = listOf("комедия", "ужасы"),
		imageUrl = null,
		localizedName = "Крутой фильм",
		name = "Крутой фильм",
		rating = 2.1f,
		year = 2020,
	)

	private val posters = listOf(
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

	@OptIn(ExperimentalCoroutinesApi::class)
	@BeforeEach
	fun setup() {
		Dispatchers.setMain(UnconfinedTestDispatcher())
	}

	@OptIn(ExperimentalCoroutinesApi::class)
	@AfterEach
	fun reset() {
		Dispatchers.resetMain()
	}

	@Test
	fun `open posters EXPECT get all posters use case invocation`() = runTest {
		whenever(getAllPostersUseCase()) doReturn posters

		viewModel.applyIntent(PostersIntent.LoadData(null))

		verify(getAllPostersUseCase).invoke()
	}

	@Test
	fun `open posters with no connection EXPECT error event invocation`() = runTest {
		whenever(getAllPostersUseCase()) doThrow IllegalStateException()
		val expected = PostersEvent.Error

		viewModel.applyIntent(PostersIntent.LoadData(null))

		viewModel.event.test {
			assertEquals(expected, awaitItem())
		}
	}

	@Test
	fun `open posters with no connection EXPECT error state`() = runTest {
		whenever(getAllPostersUseCase()) doThrow IllegalStateException()
		val expected = PostersState.Error

		viewModel.applyIntent(PostersIntent.LoadData(null))

		viewModel.state.test {
			assertEquals(expected, awaitItem())
		}
	}

	@Test
	fun `load posters EXPECT get genres use case invocation`() = runTest {
		whenever(getAllPostersUseCase()) doReturn posters

		viewModel.applyIntent(PostersIntent.LoadData(null))

		verify(getGenresUseCase).invoke(posters)
	}

	@Test
	fun `load posters EXPECT loading state`() = runTest {
		whenever(getAllPostersUseCase()) doSuspendableAnswer { awaitCancellation() }
		whenever(getGenresUseCase(any())) doReturn emptySet()
		val expected = PostersState.Loading

		viewModel.applyIntent(PostersIntent.LoadData(null))

		viewModel.state.test {
			assertEquals(expected, awaitItem())
		}
	}

	@Test
	fun `open posters EXPECT content state`() = runTest {
		whenever(getAllPostersUseCase()) doReturn posters
		whenever(getGenresUseCase(any())) doReturn emptySet()
		val expected = PostersState.Content(
			emptySet(),
			selectedGenre = null,
			posters = posters,
			filteredPosters = posters
		)

		viewModel.applyIntent(PostersIntent.LoadData(null))

		viewModel.state.test {
			assertEquals(expected, awaitItem())
		}
	}

	@Test
	fun `change genre EXPECT new content state`() = runTest {
		whenever(getAllPostersUseCase()) doReturn posters
		whenever(getGenresUseCase(any())) doReturn emptySet()
		viewModel.applyIntent(PostersIntent.LoadData(null))
		val expected = PostersState.Content(
			emptySet(),
			selectedGenre = "комедия",
			posters = posters,
			filteredPosters = posters.getFilteredPosters("комедия")
		)

		viewModel.applyIntent(PostersIntent.ChangeGenre("комедия"))

		viewModel.state.test {
			assertEquals(expected, awaitItem())
		}
	}

	@Test
	fun `click on poster EXPECT router method invocation`() {
		viewModel.applyIntent(PostersIntent.OpenFilmDetails(film))

		verify(router).openFilmDetails(film)
	}
}