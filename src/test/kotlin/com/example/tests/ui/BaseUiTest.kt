package com.example.tests.ui

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

open class BaseUiTest {

    protected lateinit var driver: WebDriver

    @BeforeEach
    fun setUpDriver() {
        driver = ChromeDriver()
        driver.manage().window().maximize()
    }

    @AfterEach
    fun tearDownDriver() {
        driver.quit()
    }
}
