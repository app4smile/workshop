package com.github.app4smile.workshop.articles

import com.github.app4smile.workshop.domain.articles.model.Article

interface ArticlesView {
    fun initialiseView()
    fun showArticleList(articles: List<Article>)
}
