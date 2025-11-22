package com.example.tests.ui

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

class ArticlePage(private val driver: WebDriver) {

    private fun waitForElement(cssSelector: String, timeoutSec: Long = 10): WebElement {
        val wait = WebDriverWait(driver, Duration.ofSeconds(timeoutSec))
        return wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssSelector)))
    }

    fun openNewArticleViaButton() {
        // Ждем появления кнопки на главной странице
        val newArticleButton = WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.elementToBeClickable(By.linkText("New Article")))
        newArticleButton.click()
    }

    fun createArticle(title: String, about: String, body: String, tags: List<String>) {
        val titleInput = waitForElement("input[placeholder='Article Title']")
        titleInput.sendKeys(title)

        val aboutInput = waitForElement("input[placeholder=\"What's this article about?\"]")
        aboutInput.sendKeys(about)

        val bodyInput = waitForElement("textarea[placeholder='Write your article (in markdown)']")
        bodyInput.sendKeys(body)

        val tagsInput = waitForElement("input[placeholder='Enter tags']")
        tagsInput.sendKeys(tags.joinToString(", "))

        val publishButton = waitForElement("button[type='submit']")
        publishButton.click()
    }

    fun assertArticleTitle(expectedTitle: String) {
        val titleElement = waitForElementVisible("h1:nth-of-type(1)", 20) // первый текстовый элемент
        if (titleElement.text != expectedTitle) {
            throw AssertionError("Expected article title '$expectedTitle', but found '${titleElement.text}'")
        }
    }

    private fun waitForElementVisible(cssSelector: String, timeoutSec: Long = 10): WebElement {
        val wait = WebDriverWait(driver, Duration.ofSeconds(timeoutSec))
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)))
    }
}
