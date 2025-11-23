package com.example.tests.ui.pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

class CommentPage(private val driver: WebDriver) {

    fun openFirstArticle() {
        val firstArticle = WebDriverWait(driver, Duration.ofSeconds(10))
            .until { driver.findElements(By.cssSelector(".article-preview")).firstOrNull() }
            ?: throw RuntimeException("Нет ни одной статьи на странице")
        firstArticle.click()
    }

    fun addComment(commentText: String) {
        val commentInput = WebDriverWait(driver, Duration.ofSeconds(10))
            .until { driver.findElement(By.cssSelector("textarea[placeholder='Write a comment...']")) }
        commentInput.clear()
        commentInput.sendKeys(commentText)

        val postButton = driver.findElement(By.xpath("//button[text()='Post Comment']"))
        postButton.click()

        // Ждём пока комментарий появится
        WebDriverWait(driver, Duration.ofSeconds(10)).until {
            driver.findElements(By.cssSelector(".card-text"))
                .any { it.text == commentText }
        }
    }

    fun assertCommentVisible(commentText: String) {
        val comments = driver.findElements(By.cssSelector(".card-text"))
        require(comments.any { it.text == commentText }) { "Комментарий '$commentText' не найден!" }
    }
}
