package com.github.app4smile.workshop.articles


import com.github.app4smile.workshop.domain.articles.GetArticlesListUseCase
import com.github.app4smile.workshop.domain.articles.model.Article
import com.github.app4smile.workshop.mvp.CleanPresenter
import javax.inject.Inject

class ArticlesPresenter @Inject constructor(private val getArticlesListUseCase: GetArticlesListUseCase) :
    CleanPresenter<ArticlesView>() {

    override fun initialise() {
        getView()?.initialiseView()
        getArticlesListUseCase.execute(ArticlesListObserver(this))
    }

    override fun disposeSubscriptions() {
        getArticlesListUseCase.dispose()
    }

    fun showArticleList(articlesList: List<Article>) {
        getView()?.showArticleList(articlesList)
    }
}
