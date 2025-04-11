package com.example.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val DarkColorScheme = darkColorScheme(
	background = Color.White,
	surface = Color.White,
	onPrimary = Color.White,
	onSecondary = Color.White,
	onTertiary = Color.LightGray,
	onBackground = Color(0xFF1C1B1F),
	onSurface = Color(0xFF1C1B1F),
	primaryContainer = selection,
)

val LightColorScheme = lightColorScheme(
	background = Color.White,
	surface = Color.White,
	onPrimary = Color.White,
	onSecondary = Color.White,
	onTertiary = Color.LightGray,
	onBackground = Color(0xFF1C1B1F),
	onSurface = Color(0xFF1C1B1F),
	primaryContainer = selection,
)

@Composable
fun SequeniaAppTheme(
	darkTheme: Boolean = isSystemInDarkTheme(),
	content: @Composable () -> Unit
) {
	val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

	MaterialTheme(
		colorScheme = colorScheme,
		typography = Typography,
		content = content
	)
}