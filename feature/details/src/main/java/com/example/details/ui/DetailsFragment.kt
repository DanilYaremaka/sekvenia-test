package com.example.details.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.films.domain.entity.Film

class DetailsFragment : Fragment() {

	private val film: Film by lazy {
		requireArguments().getParcelable<Film>(FILM_KEY)
			?: throw IllegalStateException("Film not passed")
	}

	companion object {
		private const val FILM_KEY = "film key"
		fun newInstance(film: Film): DetailsFragment = DetailsFragment().apply {
			arguments = bundleOf(FILM_KEY to film)
		}
	}

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		Log.d("details", film.toString())
		return super.onCreateView(inflater, container, savedInstanceState)
	}
}