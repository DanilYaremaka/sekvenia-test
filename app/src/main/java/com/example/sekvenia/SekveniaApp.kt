package com.example.sekvenia

import android.app.Application
import com.example.sekvenia.di.ciceroneModule
import com.example.sekvenia.di.mainModule
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class SekveniaApp : Application() {

	override fun onCreate() {
		super.onCreate()

		startKoin {
			androidLogger(Level.ERROR)
			androidContext(this@SekveniaApp)

			modules(
				ciceroneModule,
				mainModule
			)
		}
	}
}