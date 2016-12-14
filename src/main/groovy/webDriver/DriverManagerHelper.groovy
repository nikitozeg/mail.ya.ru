package webDriver

import groovy.util.logging.Slf4j
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

@Slf4j
class DriverManagerHelper {

    def static waitElementIsVisibleByCss(String cssSelector, long timeout = 20) {
        new WebDriverWait(DriverManager.getWebDriver(), timeout).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)))
    }

    def static WebElement searchElementByCss(String cssSelector, long timeout = 10) {
        new WebDriverWait(DriverManager.getWebDriver(), timeout).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssSelector)))
    }

}

