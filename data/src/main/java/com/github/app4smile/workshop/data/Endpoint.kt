package com.github.app4smile.workshop.data

import com.github.app4smile.workshop.data.articles.model.Articles
import io.reactivex.Single
import retrofit2.http.GET

interface Endpoint {
    @GET("api.json?rss_url=https%3A%2F%2Fmedium.com%2Ffeed%2F%40pyin001")
    fun getArticlesList(): Single<Articles>
}
