package com.example.tests.ui

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.openqa.selenium.WebDriver
import java.util.concurrent.TimeUnit
import com.example.tests.config.TestConfig

open class BaseUiTest {
    protected lateinit var driver: WebDriver

    @BeforeEach
    fun setUp() {
        driver = DriverFactory.createDriver()
        driver.manage().timeouts()//.implicitlyWait(TestConfig.IMPLICIT_WAIT, TimeUnit.SECONDS)
        driver.manage().window().maximize()
    }

    @AfterEach
    fun tearDown() {
        driver.quit()
    }
}
