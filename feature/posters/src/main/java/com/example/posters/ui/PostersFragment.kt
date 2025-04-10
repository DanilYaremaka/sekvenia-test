package com.example.posters.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment

class PostersFragment: Fragment() {

	companion object {

		fun newInstance(): PostersFragment = PostersFragment()
	}

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
		ComposeView(requireContext()).apply {
			setContent {
				Screen()
			}
		}
}

@Composable
fun Screen() {
	LazyColumn {
		items(10) {
			Text(it.toString())
		}
	}
}