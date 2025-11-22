package com.example.tests.api

import io.restassured.RestAssured
import io.restassured.http.ContentType
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
open class BaseApiTest {

    protected lateinit var client: ArticleApiClient
    private lateinit var token: String

    @BeforeAll
    fun setUp() {
        val username = "testuser_${System.currentTimeMillis()}"
        val email = "$username@example.com"
        val password = "testpass"

        // Регистрируем нового пользователя,
        // каждый раз будет новый,
        // мусорится база, но считаем что для автотеста создан отдельный контур
        RestAssured.given()
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .body(mapOf("user" to mapOf(
                "username" to username,
                "email" to email,
                "password" to password
            )))
            .post("/api/users")
            .then()
            .statusCode(200)

        token = obtainApiToken(email, password)
        client = ArticleApiClient(token)
    }

    private fun obtainApiToken(email: String, password: String): String {
        val response = RestAssured.given()
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .body(mapOf("user" to mapOf(
                "email" to email,
                "password" to password
            )))
            .post("/api/users/login")

        response.then().statusCode(200)
        return response.jsonPath().getString("user.token")
    }
}
