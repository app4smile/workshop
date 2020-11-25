package com.github.app4smile.workshop.articles.di.component

import com.github.app4smile.workshop.articles.ArticlesActivity
import com.github.app4smile.workshop.articles.di.module.ArticlesModule
import dagger.Component
import com.github.app4smile.workshop.di.component.AppComponent
import com.github.app4smile.workshop.mvp.scope.PerActivity

@PerActivity
@Component(dependencies = [AppComponent::class], modules = [ArticlesModule::class])
interface ArticlesComponent {
    fun inject(articlesActivity: ArticlesActivity)
}