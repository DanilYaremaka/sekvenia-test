package com.example.posters.presentation

sealed interface PostersEvent {

	data object Error: PostersEvent
}