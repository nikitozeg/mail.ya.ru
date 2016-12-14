package pages

import groovy.util.logging.Slf4j
import webDriver.DriverManager

@Slf4j
class Application {

    def static navigateToMainPage() {
        DriverManager.getWebDriver().get("https://mail.yandex.ru")
        DriverManager.getWebDriver().navigate().refresh()
    }
}
