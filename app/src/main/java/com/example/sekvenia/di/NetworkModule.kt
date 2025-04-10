package com.example.sekvenia.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.Date

private const val BASE_URL = "https://s3-eu-west-1.amazonaws.com/"

val networkModule = module {

	single {
		Retrofit.Builder()
			.addConverterFactory(ScalarsConverterFactory.create())
			.addConverterFactory(MoshiConverterFactory.create(get()).asLenient())
			.client(get())
			.baseUrl(BASE_URL)
			.build()
	}

	single {
		OkHttpClient().newBuilder()
			.addInterceptor(get<Interceptor>())
			.build()
	}

	single<Interceptor> {
		HttpLoggingInterceptor().apply {
			level = HttpLoggingInterceptor.Level.BODY
		}
	}

	single {
		Moshi.Builder()
			.add(KotlinJsonAdapterFactory())
			.add(Date::class.java, Rfc3339DateJsonAdapter().nullSafe())
			.build()
	}
}