package com.example.posters.data.datasource

import com.example.posters.data.api.PostersApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.verify

class PostersDataSourceImplTest {

	private val api: PostersApi = mock()

	private val dataSource: PostersDataSource = PostersDataSourceImpl(api)

	@Test
	fun `load data EXPECT api method invocation`() = runTest {
		dataSource.getAllPosters()

		verify(api).getAllPosters()
	}
}