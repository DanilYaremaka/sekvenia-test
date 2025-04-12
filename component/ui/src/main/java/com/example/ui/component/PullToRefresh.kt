package com.example.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.pulltorefresh.PullToRefreshContainer
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PullToRefresh(
	onRefresh: () -> Unit,
	modifier: Modifier = Modifier,
	contentPaddingValues: PaddingValues = PaddingValues(0.dp),
	content: @Composable () -> Unit,
) {
	val pullToRefreshState = rememberPullToRefreshState()
	if (pullToRefreshState.isRefreshing) {
		LaunchedEffect(true) {
			onRefresh()
			pullToRefreshState.endRefresh()
		}
	}
	Box(modifier = modifier.nestedScroll(pullToRefreshState.nestedScrollConnection)) {
		Box(modifier = Modifier.padding(paddingValues = contentPaddingValues)) {
			content()
		}

		PullToRefreshContainer(
			state = pullToRefreshState,
			modifier = Modifier
				.align(Alignment.TopCenter)
				.padding(top = contentPaddingValues.calculateTopPadding()),
		)
	}
}