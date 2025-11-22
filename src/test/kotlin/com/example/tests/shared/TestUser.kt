package com.example.tests.shared

import io.restassured.RestAssured
import io.restassured.http.ContentType

object TestUser {

    lateinit var email: String
    lateinit var password: String
    lateinit var token: String

    private var initialized = false

    fun initOnce() {
        if (initialized) return

        val username = "testuser_${System.currentTimeMillis()}"
        email = "$username@example.com"
        password = "testpass"

        // 1.
        // Регистрируем нового пользователя,
        // каждый раз будет новый, но один для всех тестов
        // мусорится база, но считаем что для автотеста создан отдельный контур
        RestAssured.given()
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .body(
                mapOf(
                    "user" to mapOf(
                        "username" to username,
                        "email" to email,
                        "password" to password
                    )
                )
            )
            .post("/api/users")
            .then()
            .statusCode(200)

        // 2. Login
        token = RestAssured.given()
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .body(
                mapOf(
                    "user" to mapOf(
                        "email" to email,
                        "password" to password
                    )
                )
            )
            .post("/api/users/login")
            .then()
            .statusCode(200)
            .extract()
            .jsonPath()
            .getString("user.token")

        initialized = true
    }
}
