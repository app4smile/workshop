package com.github.app4smile.workshop.data.articles.repository

import com.github.app4smile.workshop.data.Endpoint
import com.github.app4smile.workshop.data.articles.model.Article
import io.reactivex.Single
import javax.inject.Inject

class ArticlesRepository @Inject constructor(private val endpoint: Endpoint) {
    fun articles(): Single<List<Article>> = endpoint.getArticlesList()
        .map { it.articles }
}