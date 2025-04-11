package com.example.details.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.details.R
import com.example.details.utils.getGenresAndYear
import com.example.films.domain.entity.Film
import com.example.ui.appBarBackground
import com.example.ui.black
import com.example.ui.blueText
import com.example.ui.component.AppBarText
import com.example.ui.gray
import com.example.ui.white
import com.example.ui.R as ComponentR

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(
	film: Film,
	onBackPressed: () -> Unit,
) {
	Scaffold(
		topBar = {
			TopAppBar(
				title = {
					AppBarText(
						text = film.name,
					)
				},
				navigationIcon = { IconButton(
					onClick = onBackPressed,
				) {
					Icon(
						imageVector = ImageVector.vectorResource(id = ComponentR.drawable.arrow_back),
						contentDescription = "navigate back"
					)
				} },
				colors = TopAppBarDefaults.topAppBarColors().copy(
					containerColor = appBarBackground,
					navigationIconContentColor = white,
					titleContentColor = white,
				)
			)
		},
	) { paddingValues ->
		Column(
			modifier = Modifier
				.fillMaxSize()
				.padding(paddingValues)
				.verticalScroll(rememberScrollState())
				.padding(start = 16.dp, end = 16.dp, bottom = 15.dp)
		) {
			Spacer(modifier = Modifier.height(24.dp))

			Box(
				modifier = Modifier.fillMaxWidth(),
				contentAlignment = Alignment.Center
			) {
				AsyncImage(
					model = film.imageUrl,
					contentDescription = film.localizedName,
					placeholder = painterResource(ComponentR.drawable.empty_image),
					error = painterResource(ComponentR.drawable.empty_image),
				)
			}

			Spacer(modifier = Modifier.height(24.dp))

			Text(
				text = film.localizedName,
				modifier = Modifier.fillMaxWidth(),
				fontSize = 26.sp,
				color = black,
				lineHeight = 32.sp,
				letterSpacing = TextUnit(value = 0.1f, type = TextUnitType.Sp),
				fontWeight = FontWeight.W700,
				overflow = TextOverflow.Ellipsis,
			)

			Spacer(modifier = Modifier.height(8.dp))

			Text(
				text = film.getGenresAndYear(),
				modifier = Modifier.fillMaxWidth(),
				fontSize = 16.sp,
				color = gray,
				lineHeight = 20.sp,
				letterSpacing = TextUnit(value = 0.1f, type = TextUnitType.Sp),
				fontWeight = FontWeight.W400,
			)

			Spacer(modifier = Modifier.height(10.dp))

			Text(
				text = buildAnnotatedString {
					withStyle(style = SpanStyle(
						fontSize = 24.sp,
						letterSpacing = TextUnit(value = 0.1f, type = TextUnitType.Sp),
						fontWeight = FontWeight.W700,
					)) {
						if (film.rating == null)
							append("- ")
						else
							append("%.1f ".format(film.rating).replace(',', '.'))
					}

					withStyle(style = SpanStyle(
						fontSize = 16.sp,
						letterSpacing = TextUnit(value = 0.1f, type = TextUnitType.Sp),
						fontWeight = FontWeight.W500,
					)) {
						append(stringResource(R.string.kinopoisk))
					}
				},
				modifier = Modifier.fillMaxWidth(),
				color = blueText,
				letterSpacing = TextUnit(value = 0.1f, type = TextUnitType.Sp),
			)

			Spacer(modifier = Modifier.height(14.dp))

			Text(
				text = film.description ?: "",
				modifier = Modifier.fillMaxWidth(),
				fontSize = 14.sp,
				color = black,
				lineHeight = 20.sp,
				letterSpacing = TextUnit(value = 0.1f, type = TextUnitType.Sp),
				fontWeight = FontWeight.W400,
			)
		}
	}
}