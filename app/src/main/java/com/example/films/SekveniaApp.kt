package com.example.films

import android.app.Application
import com.example.films.di.ciceroneModule
import com.example.films.di.mainModule
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