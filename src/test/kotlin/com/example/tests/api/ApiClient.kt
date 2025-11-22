package com.example.tests.api

import io.restassured.RestAssured
import io.restassured.http.ContentType
import com.example.tests.config.TestConfig

open class ApiClient {
    // базовая инициализация и создание шаблона json запроса
    init {
        RestAssured.baseURI = TestConfig.BASE_API_URL
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails()
    }

    fun json(): io.restassured.specification.RequestSpecification =
        RestAssured.given().contentType(ContentType.JSON).accept(ContentType.JSON)
}
