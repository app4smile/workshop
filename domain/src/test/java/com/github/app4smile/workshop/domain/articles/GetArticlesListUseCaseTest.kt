package com.github.app4smile.workshop.domain.articles

import com.github.app4smile.workshop.data.articles.repository.ArticlesRepository
import com.github.app4smile.workshop.domain.articles.model.Article
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import io.reactivex.schedulers.Schedulers
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner

@RunWith(PowerMockRunner::class)
@PrepareForTest(ArticlesRepository::class)
class GetArticlesListUseCaseTest {

    private lateinit var getArticlesListUseCase: GetArticlesListUseCase

    @Mock
    lateinit var articlesRepository: ArticlesRepository

    val articlesList = listOf(
        com.github.app4smile.workshop.data.articles.model.Article(
            title = "title",
            pubDate = "pub date",
            link = "this is link"
        )
    )

    @Before
    fun setUp() {
        `when`(articlesRepository.articles())
            .thenReturn(Single.just(articlesList))

        getArticlesListUseCase = GetArticlesListUseCase(
            articlesRepository,
            Schedulers.trampoline(),
            Schedulers.trampoline()
        )
    }

    @After
    fun tearDown() {
        getArticlesListUseCase.dispose()
    }

    @Test
    fun `should map data article type to domain article type`() {
        val observer = TestObserver<List<Article>>()
        getArticlesListUseCase.execute(observer)
        observer.assertNoErrors()
        observer.assertComplete()
        assertEquals(Article("title", "pub date", "this is link"), observer.values()[0][0])
    }
}