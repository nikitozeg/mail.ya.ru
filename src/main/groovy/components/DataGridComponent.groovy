package components

import groovy.util.logging.Slf4j
import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement

import static constants.Locators.SEARCH_INPUT
import static webDriver.DriverManagerHelper.searchElementByCss

@Slf4j
class DataGridComponent {
    WebElement VIEWAPP


    DataGridComponent(WebElement VIEWAPP) {
        this.VIEWAPP = VIEWAPP;
    }


    def typeSearchAndClickEnter(String value) {
        searchElementByCss(SEARCH_INPUT).sendKeys(value)
        searchElementByCss(SEARCH_INPUT).sendKeys(Keys.ENTER)
    }


}
