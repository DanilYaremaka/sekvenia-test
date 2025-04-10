package com.example.sekvenia.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.sekvenia.R
import com.example.sekvenia.databinding.ActivityMainBinding
import com.example.sekvenia.presentation.MainViewModel
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

	private val screenNavigatorHolder: NavigatorHolder by inject()
	private val navigator = AppNavigator(this, R.id.globalContainer)
	private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

	private val viewModel: MainViewModel by viewModel()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContentView(binding.root)

		viewModel.openFragment()
	}

	override fun onResume() {
		super.onResume()
		screenNavigatorHolder.setNavigator(navigator)
	}

	override fun onPause() {
		super.onPause()
		screenNavigatorHolder.removeNavigator()
	}
}
