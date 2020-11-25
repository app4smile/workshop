package com.github.app4smile.workshop.di.module

import com.github.app4smile.workshop.data.articles.repository.ArticlesRepository
import com.github.app4smile.workshop.domain.articles.GetArticlesListUseCase
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Named
import javax.inject.Singleton

@Module
class UseCaseModule {
    @Provides
    @Singleton
    @Named("ioScheduler")
    internal fun provideIoScheduler() = Schedulers.io()

    @Provides
    @Singleton
    @Named("mainThreadScheduler")
    internal fun provideMainThreadScheduler() = AndroidSchedulers.mainThread()

    @Provides
    @Singleton
    internal fun provideGetArticlesListUseCase(
        articlesRepository: ArticlesRepository,
        @Named("ioScheduler") ioScheduler: Scheduler,
        @Named("mainThreadScheduler") mainThreadScheduler: Scheduler
    ): GetArticlesListUseCase =
        GetArticlesListUseCase(articlesRepository, ioScheduler, mainThreadScheduler)
}
