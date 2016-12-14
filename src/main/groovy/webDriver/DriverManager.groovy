package webDriver

import groovy.util.logging.Slf4j
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

import java.util.concurrent.TimeUnit

@Slf4j
@Singleton(strict = false)
class DriverManager {
    private static WebDriver webDriver

    private DriverManager() {
        System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver.exe");
    }

    static WebDriver getWebDriver() {
        if (webDriver == null){
            webDriver = new ChromeDriver();
            webDriver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
            webDriver.manage().window().maximize();
        }
        webDriver
    }

    static void quitWebDriver() {
        if (webDriver != null) {
            webDriver.quit()
            webDriver = null
        }
    }
}
