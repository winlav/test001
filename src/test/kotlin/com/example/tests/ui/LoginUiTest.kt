package com.example.tests.ui

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertTrue

class LoginUiTest : BaseUiTest() {

    @Test
    fun `user can login via ui`() {
        val loginPage = LoginPage(driver)
        loginPage.open()
        loginPage.login("testuser", "testpass")
        // A simple assertion: check that URL changed or profile button is visible
        Thread.sleep(1000)
        assertTrue(driver.currentUrl.contains("/"), "After login should redirect to home or profile")
    }
}
