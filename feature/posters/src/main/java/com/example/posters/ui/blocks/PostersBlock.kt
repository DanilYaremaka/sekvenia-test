package com.example.posters.ui.blocks

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.films.domain.entity.Film
import com.example.posters.R
import com.example.ui.black
import com.example.ui.white

@Composable
private fun PosterItem(
	name: String,
	imageUrl: String?,
) {
	Card(
		modifier = Modifier
			.height(270.dp)
			.fillMaxWidth(),
		colors = CardDefaults.cardColors().copy(containerColor = white),
		shape = RectangleShape,
	) {
		Box (
			modifier = Modifier
				.fillMaxWidth()
				.height(222.dp)
				.clip(MaterialTheme.shapes.medium),
		) {
			AsyncImage(
				model = imageUrl,
				contentDescription = name,
				modifier = Modifier
					.fillMaxSize(),
				contentScale = ContentScale.Crop,
				placeholder = painterResource(R.drawable.empty_image),
				error = painterResource(R.drawable.empty_image),
			)
		}

		Spacer(modifier = Modifier.height(8.dp))

		Text(
			text = name,
			modifier = Modifier.fillMaxWidth(),
			fontSize = 16.sp,
			color = black,
			lineHeight = 20.sp,
			letterSpacing = TextUnit(value = 0.1f, type = TextUnitType.Sp),
			fontWeight = FontWeight.W700,
			maxLines = 2,
			overflow = TextOverflow.Ellipsis
		)
	}
}

@Composable
fun LazyItemScope.PostersGrid(
	posters: List<Film>,
	modifier: Modifier = Modifier,
) {
	val gridState = rememberLazyGridState()

	LaunchedEffect(key1 = posters) {
		gridState.scrollToItem(index = 0)
	}

	LazyVerticalGrid(
		columns = GridCells.Fixed(count = 2),
		modifier = modifier
			.fillParentMaxSize()
			.padding(top = 8.dp, bottom = 16.dp, start = 16.dp, end = 16.dp),
		state = gridState,
		horizontalArrangement = Arrangement.spacedBy(8.dp),
		verticalArrangement = Arrangement.spacedBy(16.dp),
	) {
		items(items = posters, key = { it.id }) {
			PosterItem(imageUrl = it.imageUrl, name = it.localizedNamed)
		}
	}
}