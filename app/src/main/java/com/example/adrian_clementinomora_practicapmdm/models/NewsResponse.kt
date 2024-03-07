package com.example.adrian_clementinomora_practicapmdm.models

import com.example.adrian_clementinomora_practicapmdm.models.Article

data class NewsResponse(
    val articles: MutableList<Article>,
    val status: String,
    val totalResults: Int
)