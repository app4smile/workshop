package com.github.app4smile.workshop.articles.di.module

import com.github.app4smile.workshop.articles.ArticlesPresenter
import com.github.app4smile.workshop.domain.articles.GetArticlesListUseCase
import com.github.app4smile.workshop.mvp.scope.PerActivity
import dagger.Module
import dagger.Provides

@Module
class ArticlesModule {
    @PerActivity
    @Provides
    internal fun provideArticlesPresenter(getArticlesListUseCase: GetArticlesListUseCase) =
        ArticlesPresenter(getArticlesListUseCase)
}
