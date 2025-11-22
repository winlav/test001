package com.example.tests.ui

import org.junit.jupiter.api.Test
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

class ArticlePage(private val driver: WebDriver) {
    private val wait = WebDriverWait(driver, Duration.ofSeconds(10))

    @Test
    fun openNewArticle() {
        driver.get(com.example.tests.config.TestConfig.BASE_UI_URL + "/editor")
    }

    @Test
    fun createArticle(title: String, body: String) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Article Title']")))
        driver.findElement(By.cssSelector("input[placeholder='Article Title']")).sendKeys(title)
        driver.findElement(By.cssSelector("textarea[placeholder='Write your article']")).sendKeys(body)
        driver.findElement(By.cssSelector("button[type='button']")).click()
    }
}
