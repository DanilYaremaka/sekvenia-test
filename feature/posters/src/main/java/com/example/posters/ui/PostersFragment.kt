package com.example.posters.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.example.posters.presentation.PostersViewModel
import com.example.ui.SequeniaAppTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class PostersFragment: Fragment() {

	companion object {

		fun newInstance(): PostersFragment = PostersFragment()
	}

	private val viewModel: PostersViewModel by viewModel()

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
		ComposeView(requireContext()).apply {
			setContent {
				SequeniaAppTheme {
					PostersScreen(
						stateFlow = viewModel.state,
						eventFlow = viewModel.event,
						applyIntent = viewModel::applyIntent,
					)
				}
			}
		}
}