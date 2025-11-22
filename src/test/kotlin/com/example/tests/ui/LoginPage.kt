// LoginPage.kt
import com.example.tests.config.TestConfig.BASE_UI_URL
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

class LoginPage(private val driver: WebDriver) {

    private val wait = WebDriverWait(driver, Duration.ofSeconds(30))

    private val emailSelector = By.cssSelector("input[placeholder='Email']")
    private val passwordSelector = By.cssSelector("input[placeholder='Password']")
    private val signInButtonSelector = By.cssSelector("button.btn-primary")

    fun open() {
        driver.get("${BASE_UI_URL}/#/login")
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailSelector))
    }

    fun login(email: String, password: String) {
        val emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(emailSelector))
        emailField.clear()
        emailField.sendKeys(email)

        val passwordField = driver.findElement(passwordSelector)
        passwordField.clear()
        passwordField.sendKeys(password)

        val signInButton = driver.findElement(signInButtonSelector)
        signInButton.click()

        // Ждем редирект
        wait.until(ExpectedConditions.urlContains("/"))
    }
}
