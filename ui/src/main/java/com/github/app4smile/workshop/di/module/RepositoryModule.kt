package com.github.app4smile.workshop.di.module

import com.github.app4smile.workshop.data.Endpoint
import com.github.app4smile.workshop.data.articles.repository.ArticlesRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Singleton
    internal fun provideArticleRepository(endpoint: Endpoint): ArticlesRepository =
        ArticlesRepository(endpoint)
}