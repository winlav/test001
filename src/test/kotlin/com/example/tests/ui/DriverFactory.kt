package com.example.tests.ui

import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import com.example.tests.config.TestConfig

object DriverFactory {
    fun createDriver(): WebDriver {
        WebDriverManager.chromedriver().setup()
        val options = ChromeOptions()
        if (TestConfig.HEADLESS) options.addArguments("--headless=new")
        options.addArguments("--no-sandbox","--disable-dev-shm-usage")
        return ChromeDriver(options)
    }
}
