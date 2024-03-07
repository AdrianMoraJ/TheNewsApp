package com.example.adrian_clementinomora_practicapmdm.repository

import com.example.adrian_clementinomora_practicapmdm.api.RetrofitInstance
import com.example.adrian_clementinomora_practicapmdm.database.ArticleDatabase
import com.example.adrian_clementinomora_practicapmdm.models.Article
import java.util.Locale.IsoCountryCode

class NewsRepository (val db: ArticleDatabase) {
    suspend fun getHeadLines (countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getHeadLines(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    fun getFavouriteNews() = db.getArticleDao().getAllArticles()

    suspend fun  deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)
}