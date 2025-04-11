package com.example.details.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.compose.ui.platform.ComposeView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.details.presentation.DetailsViewModel
import com.example.films.domain.entity.Film
import com.example.ui.SequeniaAppTheme
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class DetailsFragment : Fragment() {

	companion object {
		private const val FILM_KEY = "FILM_KEY"

		fun newInstance(film: Film): DetailsFragment = DetailsFragment().apply {
			arguments = bundleOf(FILM_KEY to film)
		}
	}

	private val film: Film by lazy {
		requireArguments().getParcelable<Film>(FILM_KEY)
			?: throw IllegalStateException("Film not passed!")
	}

	private val viewModel: DetailsViewModel by viewModel { parametersOf(arguments?.getParcelable(FILM_KEY)) }

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
		ComposeView(requireContext()).apply {
			setContent {
				SequeniaAppTheme {
					DetailsScreen(
						film = film,
						onBackPressed = viewModel::handleNavigateBack
					)
				}
			}
		}

	override fun onStart() {
		requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
			viewModel.handleNavigateBack()
		}
		super.onStart()
	}
}