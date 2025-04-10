package com.example.posters.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.posters.domain.usecase.GetAllPostersUseCase
import kotlinx.coroutines.launch

class PostersViewModel(
	private val getAllPostersUseCase: GetAllPostersUseCase,
) : ViewModel() {

	fun load() {
		viewModelScope.launch {
			getAllPostersUseCase().forEach{ Log.d("posters", it.localizedNamed) }
		}
	}
}