package com.example.posters.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.films.domain.entity.Film
import com.example.posters.domain.usecase.GetAllPostersUseCase
import com.example.posters.domain.usecase.GetGenresUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class PostersViewModel(
	private val getAllPostersUseCase: GetAllPostersUseCase,
	private val getGenresUseCase: GetGenresUseCase,
	private val router: PostersRouter,
) : ViewModel() {

	private val _state = MutableStateFlow<PostersState>(PostersState.Initial)
	val state: StateFlow<PostersState> = _state

	private val _event = Channel<PostersEvent>(capacity = Channel.CONFLATED)
	val event: Flow<PostersEvent> = _event.receiveAsFlow()

	private val getErrorHandler = CoroutineExceptionHandler { _, _ ->
		_event.trySend(PostersEvent.Error)
	}

	fun applyIntent(intent: PostersIntent) {
		when (intent) {
			is PostersIntent.ChangeGenre     -> handleChangeGenre(intent.genre)
			is PostersIntent.LoadData        -> handleLoadData(intent.genre)
			is PostersIntent.OpenFilmDetails -> openFilmDetails(intent.film)
		}
	}

	private fun handleLoadData(genre: String?) {
		_state.value = PostersState.Loading

		viewModelScope.launch(getErrorHandler) {
			val allPosters = getAllPostersUseCase()
			val genres = getGenresUseCase(allPosters)

			_state.value = PostersState.Content(
				genres = genres,
				selectedGenre = genre,
				posters = allPosters,
				filteredPosters = allPosters,
			)
		}
	}

	private fun handleChangeGenre(genre: String) {
		val currentState = state.value as? PostersState.Content ?: return
		val selectedGenre: String? = if (currentState.selectedGenre == genre) null
			else genre

		_state.value = currentState.copy(
			selectedGenre = selectedGenre,
			filteredPosters = currentState.posters.getFilteredPosters(selectedGenre)
		)
	}

	private fun openFilmDetails(film: Film) {
		router.openFilmDetails(film)
	}
}