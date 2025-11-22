import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import java.io.File

object DriverFactory {
    fun createDriver(): ChromeDriver {
        val options = ChromeOptions()
        options.addArguments("--headless=new", "--no-sandbox", "--disable-dev-shm-usage")

        WebDriverManager.chromedriver().setup()

        return ChromeDriver(options)
    }
}
