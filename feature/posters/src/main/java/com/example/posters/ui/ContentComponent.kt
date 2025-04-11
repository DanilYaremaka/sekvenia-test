package com.example.posters.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.films.domain.entity.Film
import com.example.posters.R
import com.example.posters.ui.blocks.BlockTitleText
import com.example.posters.ui.blocks.PostersGrid
import com.example.posters.ui.blocks.TextCard
import com.example.ui.black
import com.example.ui.selection
import com.example.ui.white

@Composable
fun Content(
	modifier: Modifier,
	posters: List<Film>,
	genres: Set<String>,
	selectedGenre: String?,
	onGenreChange: (String) -> Unit,
	onPosterClick: (Film) -> Unit,
) {
	LazyColumn(
		modifier = modifier
			.fillMaxWidth()
	) {
		item {
			Spacer(modifier = Modifier.height(8.dp))
		}

		item {
			TextCard(modifier = Modifier, containerColor = white) {
				BlockTitleText(text = stringResource(R.string.genre_title))
			}
		}

		items(items = genres.toList(), key = { it }) {
			val color = if (it == selectedGenre) selection
				else white
			TextCard(
				modifier = Modifier
					.clickable { onGenreChange(it) },
				containerColor = color
			) {
				Text(
					text = it,
					modifier = Modifier
						.fillMaxWidth()
						.padding(vertical = 10.dp, horizontal = 16.dp),
					fontSize = 16.sp,
					color = black,
					lineHeight = 20.sp,
					letterSpacing = TextUnit(value = 0.1f, type = TextUnitType.Sp),
					fontWeight = FontWeight.W400,
				)
			}
		}

		item {
			Spacer(modifier = Modifier.height(16.dp))
		}

		item {
			TextCard(modifier = Modifier, containerColor = white) {
				BlockTitleText(text = stringResource(R.string.films_title))
			}
		}

		item {
			PostersGrid(
				posters = posters,
				modifier = Modifier,
				onPosterClick = onPosterClick,
			)
		}
	}
}