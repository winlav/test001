package com.example.tests.ui

import LoginPage

import com.example.tests.shared.TestUser
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ArticleUiTest : BaseUiTest() {

    @BeforeEach
    fun prepareUser() {
        TestUser.initOnce() // инициализация один раз
    }

    @Test
    fun `user can create article via ui`() {
        // 1. UI login
        val loginPage = LoginPage(driver)
        loginPage.open()
        loginPage.login(TestUser.email, TestUser.password)

        // 2. Редактор
        val articlePage = ArticlePage(driver)
        articlePage.openNewArticleViaButton()

        // 3. Создаём статью
        articlePage.createArticle(
            title = "My Test Article",
            about = "About this article",
            body = "This is article body",
            tags = listOf("selenium", "test")
        )

        // 4. Проверяем title
        articlePage.assertArticleTitle("My Test Article")
    }
}
