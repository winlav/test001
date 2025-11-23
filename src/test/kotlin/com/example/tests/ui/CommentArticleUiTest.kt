package com.example.tests.ui

import com.example.tests.shared.TestUser
import com.example.tests.ui.pages.CommentPage
import LoginPage
import org.junit.jupiter.api.*

class CommentArticleUiTest : BaseUiTest() {

    @BeforeEach
    fun prepareUser() {
        TestUser.initOnce() // один раз инициализируем тестового пользователя
    }

    @Test
    @DisplayName("UI - открываем первую статью, добавляем комментарий и проверяем его отображение")
    fun `user can comment on first article via ui`() {
        // авторизуемся
        val loginPage = LoginPage(driver)
        loginPage.open()
        loginPage.login(TestUser.email, TestUser.password)

        // действие
        val commentPage = CommentPage(driver)
        commentPage.openFirstArticle()

        val commentText = "UI test comment ${System.currentTimeMillis()}"
        commentPage.addComment(commentText)

        // проверка
        commentPage.assertCommentVisible(commentText)
    }
}
