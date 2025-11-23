package com.example.tests.ui

import LoginPage

import com.example.tests.shared.TestUser
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ArticleUiTest : BaseUiTest() {

    @BeforeEach
    fun prepareUser() {
        TestUser.initOnce() // инициализация один раз
    }

    @Test
    @DisplayName("UI - Создание корректной статьи")
    fun `user can create article via ui`() {
        // авторизуемся
        val loginPage = LoginPage(driver)
        loginPage.open()
        loginPage.login(TestUser.email, TestUser.password)

        // переход в редактор статьи
        val articlePage = ArticlePage(driver)
        articlePage.openNewArticleViaButton()

        // создаём статью
        articlePage.createArticle(
            title = "My Test Article",
            about = "About this article",
            body = "This is article body",
            tags = listOf("selenium", "test")
        )

        // Проверяем что создалась
        articlePage.assertArticleTitle("My Test Article")
    }
}
