package com.github.app4smile.workshop.articles



import com.github.app4smile.workshop.domain.articles.model.Article
import io.reactivex.observers.DisposableSingleObserver

class ArticlesListObserver(private val presenter: ArticlesPresenter) :
    DisposableSingleObserver<List<Article>>() {
    override fun onSuccess(articlesList: List<Article>) {
        presenter.showArticleList(articlesList)
    }

    override fun onError(e: Throwable) {
        e.printStackTrace()
    }
}
