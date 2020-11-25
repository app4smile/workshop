package com.github.app4smile.workshop.articles


import com.github.app4smile.workshop.App
import com.github.app4smile.workshop.R
import com.github.app4smile.workshop.articles.di.component.DaggerArticlesComponent
import com.github.app4smile.workshop.domain.articles.model.Article

import com.github.app4smile.workshop.mvp.CleanActivity
import kotlinx.android.synthetic.main.activity_articles.*

class ArticlesActivity : CleanActivity<ArticlesPresenter>(), ArticlesView {
    override fun getLayout(): Int = R.layout.activity_articles

    override fun initInjector() {
        DaggerArticlesComponent.builder()
            .appComponent((application as App).applicationComponent)
            .build()
            .inject(this)
    }

    override fun initialiseView() {
        articles_list_recycler_view.apply {
            setHasFixedSize(true)
            layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this@ArticlesActivity)
        }
    }

    override fun showArticleList(articles: List<Article>) {
        articles_list_recycler_view.adapter = ArticlesListAdapter(this, articles)
    }
}
