package com.example.tests.ui

import org.junit.jupiter.api.Test
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

class LoginPage(private val driver: WebDriver) {
    private val wait = WebDriverWait(driver, Duration.ofSeconds(10))

    private fun usernameField(): WebElement = driver.findElement(By.cssSelector("input[placeholder='Username']"))
    private fun passwordField(): WebElement = driver.findElement(By.cssSelector("input[placeholder='Password']"))
    private fun signInButton(): WebElement = driver.findElement(By.cssSelector("button[type='submit']"))

    @Test
    fun open() {
        driver.get(com.example.tests.config.TestConfig.BASE_UI_URL + "/login")
    }

    @Test
    fun login(username: String, password: String) {
        wait.until(ExpectedConditions.visibilityOf(usernameField())).apply {
            usernameField().clear()
            usernameField().sendKeys(username)
        }
        passwordField().clear()
        passwordField().sendKeys(password)
        signInButton().click()
    }
}
