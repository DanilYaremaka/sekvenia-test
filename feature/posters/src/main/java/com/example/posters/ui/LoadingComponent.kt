package com.example.posters.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ui.selection

@Composable
fun Loading() {
	Box(
		modifier = Modifier.fillMaxSize(),
		contentAlignment = Alignment.Center
	) {
		CircularProgressIndicator(
			modifier = Modifier.size(48.dp),
			color = selection,
		)
	}
}