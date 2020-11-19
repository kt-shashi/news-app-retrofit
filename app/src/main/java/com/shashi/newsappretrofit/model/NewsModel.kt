package com.shashi.newsappretrofit.model

data class NewsModel(
    var totalArticles: Int,
    var articles: List<NewsArticleModel>
)