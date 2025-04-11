package com.example.sequenia

import android.app.Application
import com.example.details.di.detailsModule
import com.example.posters.di.postersModule
import com.example.sequenia.di.ciceroneModule
import com.example.sequenia.di.mainModule
import com.example.sequenia.di.networkModule
import com.example.sequenia.di.routerModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class SequeniaApp : Application() {

	override fun onCreate() {
		super.onCreate()

		startKoin {
			androidLogger(Level.ERROR)
			androidContext(this@SequeniaApp)

			modules(
				ciceroneModule,
				mainModule,
				networkModule,
				postersModule,
				routerModule,
				detailsModule,
			)
		}
	}
}