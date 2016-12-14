package pages

import components.DataGridComponent
import webDriver.DriverManagerHelper

import static components.CommonComponent.clickOnElement
import static constants.Locators.*
import static webDriver.DriverManagerHelper.searchElementByCss

class LoginForm {


    static def typeLogin(String value) {
        searchElementByCss(LOGIN_INPUT).sendKeys(value)
    }

    static def typePassword(String value) {
        searchElementByCss(PASSWORD_INPUT).sendKeys(value)
    }

    static DataGridComponent clickOnEnter() {
        clickOnElement(searchElementByCss(LOGIN_BTN, 30))
        DriverManagerHelper.waitElementIsVisibleByCss(SEARCH_INPUT)
        new DataGridComponent(searchElementByCss(VIEW_APP))

    }

}
