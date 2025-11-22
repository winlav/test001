package com.example.tests.api

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class ArticleApiTest : BaseApiTest() {

    @Test
    fun `create article returns correct status and body`() {
        val title = "My title"
        val body = "Body text"

        val response = client.createArticle(title, body)
            .then()
            .statusCode(200) // Создание статьи в RealWorld API возвращает 200
            .extract()
            .response()

        assertEquals(title, response.jsonPath().getString("article.title"))
        assertEquals("desc", response.jsonPath().getString("article.description"))
        assertEquals(body, response.jsonPath().getString("article.body"))
    }
}
