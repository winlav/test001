package com.example.tests.users

import com.example.tests.shared.TestUser
import io.restassured.RestAssured
import io.restassured.http.ContentType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class UpdateUserProfileTest {

    init {
        // Используем тестового пользователя
        TestUser.initOnce()
    }

    @Test
    @DisplayName("Авторизованный пользователь может обновить bio. Метод PUT")
    fun userCanUpdateProfile() {

        // подготовка
        val newUsername = "updated_${System.currentTimeMillis()}"
        val newBio = "Updated bio from test"

        val updateRequest = mapOf(
            "user" to mapOf(
                "username" to newUsername,
                "bio" to newBio,
            )
        )

        // действие
        val response = RestAssured.given()
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .header("Authorization", "Token ${TestUser.token}")
            .body(updateRequest)
            .put("/api/user")
            .then()
            .statusCode(200)
            .extract()
            .jsonPath()

        // проверка
        val actualUsername = response.getString("user.username")
        val actualBio = response.getString("user.bio")
        assertEquals(newUsername, actualUsername)
        assertEquals(newBio, actualBio)
    }
}