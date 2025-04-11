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
import com.example.posters.presentation.PostersViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PostersFragment: Fragment() {

	companion object {

		fun newInstance(): PostersFragment = PostersFragment()
	}

	private val viewModel: PostersViewModel by viewModel()

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
		ComposeView(requireContext()).apply {
			setContent {
				Screen()
			}
		}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
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