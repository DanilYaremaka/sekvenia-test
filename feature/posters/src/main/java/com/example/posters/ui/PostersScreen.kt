package com.example.posters.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.example.posters.R
import com.example.posters.presentation.PostersEvent
import com.example.posters.presentation.PostersIntent
import com.example.posters.presentation.PostersState
import com.example.ui.appBarBackground
import com.example.ui.component.AppBarText
import com.example.ui.component.CustomSnackBar
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostersScreen(
	stateFlow: StateFlow<PostersState>,
	eventFlow: Flow<PostersEvent>,
	applyIntent: (PostersIntent) -> Unit,
) {
	val state by stateFlow.collectAsState()
	val snackBarHostState = remember { SnackbarHostState() }
	val context = LocalContext.current

	LaunchedEffect(key1 = true) {
		applyIntent(PostersIntent.LoadData(genre = null))
	}

	Scaffold(
		topBar = {
			TopAppBar(
				title = {
					AppBarText(
						text = stringResource(R.string.films_title),
					)
				},
				colors = TopAppBarDefaults.topAppBarColors().copy(containerColor = appBarBackground)
			)
		},
		snackbarHost = { SnackbarHost(
			hostState = snackBarHostState,
			snackbar = {
				CustomSnackBar(snackBarData = it)
			}
		)
	   },
	) { paddingValues ->
		when (val uiState = state) {
			is PostersState.Content -> Content(
				modifier = Modifier.padding(paddingValues),
				genres = uiState.genres,
				posters = uiState.filteredPosters,
				onGenreChange = { genre -> applyIntent(PostersIntent.ChangeGenre(genre)) },
				selectedGenre = uiState.selectedGenre,
			)
			PostersState.Initial    -> Loading()
			PostersState.Loading    -> Loading()
			PostersState.Error      -> Unit
		}

		LaunchedEffect(key1 = Unit) {
			eventFlow.collect {
				when (it) {
					PostersEvent.Error -> {
						val result = snackBarHostState.showSnackbar(
							message = context.getString(R.string.connection_error_message),
							actionLabel = context.getString(R.string.reload),
							duration = SnackbarDuration.Indefinite
						)
						when (result) {
							SnackbarResult.ActionPerformed -> applyIntent(PostersIntent.LoadData(genre = null))
							SnackbarResult.Dismissed -> Unit
						}
					}
				}
			}
		}
	}
}