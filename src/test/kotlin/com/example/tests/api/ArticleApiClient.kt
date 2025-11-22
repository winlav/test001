package com.example.tests.api

data class ArticleCreateRequest(val article: Map<String, Any>)

class ArticleApiClient(private val token: String? = null) : ApiClient() {

    fun createArticle(title: String, body: String) =
        json().apply {
            token?.let { header("Authorization", "Token $it") }  // Подставляем токен
        }.body(
            ArticleCreateRequest(
                mapOf(
                    "title" to title,
                    "description" to "desc",
                    "body" to body
                )
            )
        ).post("/api/articles")
}
