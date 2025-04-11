package com.example.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.sp
import com.example.ui.white

@Composable
fun AppBarText(
	text: String,
) {
	Text(
		text = text,
		modifier = Modifier.fillMaxWidth(),
		textAlign = TextAlign.Center,
		fontSize = 18.sp,
		color = white,
		lineHeight = 22.sp,
		letterSpacing = TextUnit(value = 0.15f, type = TextUnitType.Sp),
		fontWeight = FontWeight.W500,
		maxLines = 1
	)
}