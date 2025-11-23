package com.example.tests.api

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName

class ArticleApiTest : BaseApiTest() {

    @Test

    @DisplayName("API - Создание корректной статьи")
    fun `create article returns correct status and body`() {
        // подготовка
        val title = "My title"
        val body = "Body text"
        // действие
        val response = client.createArticle(title, body)
            .then()
            .statusCode(200)
            .extract()
            .response()
        // проверки
        assertEquals(title, response.jsonPath().getString("article.title"))
        assertEquals("desc", response.jsonPath().getString("article.description"))
        assertEquals(body, response.jsonPath().getString("article.body"))
    }
}
