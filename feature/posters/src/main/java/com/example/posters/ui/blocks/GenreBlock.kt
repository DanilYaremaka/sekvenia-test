package com.example.posters.ui.blocks

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.black

@Composable
internal fun TextCard(
	modifier: Modifier = Modifier,
	containerColor: Color,
	content: @Composable ColumnScope.() -> Unit
) {
	Card(
		modifier = modifier
			.fillMaxWidth()
			.height(40.dp),
		shape = RectangleShape,
		colors = CardDefaults.cardColors().copy(containerColor = containerColor)
	) {
		content()
	}
}

@Composable
internal fun BlockTitleText(
	text: String,
) {
	Text(
		text = text,
		modifier = Modifier
			.fillMaxWidth()
			.padding(vertical = 8.dp, horizontal = 16.dp),
		fontSize = 20.sp,
		color = black,
		lineHeight = 22.sp,
		letterSpacing = TextUnit(value = 0.1f, type = TextUnitType.Sp),
		fontWeight = FontWeight.W700,
	)
}