package com.github.app4smile.workshop.di.component

import android.content.Context
import com.github.app4smile.workshop.App
import com.github.app4smile.workshop.data.Endpoint
import dagger.Component
import com.github.app4smile.workshop.di.module.AppModule
import com.github.app4smile.workshop.di.module.IOModule
import com.github.app4smile.workshop.di.module.RepositoryModule
import com.github.app4smile.workshop.di.module.UseCaseModule
import com.github.app4smile.workshop.domain.articles.GetArticlesListUseCase
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, IOModule::class, RepositoryModule::class, UseCaseModule::class])
interface AppComponent {
    fun inject(app: App)
    fun getApplicationContext(): Context
    fun getEndpoint(): Endpoint

    fun getArticlesListUseCase(): GetArticlesListUseCase
}
