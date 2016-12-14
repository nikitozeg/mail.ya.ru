package ru.ya.mail

import components.DataGridComponent
import org.openqa.selenium.By
import org.openqa.selenium.NotFoundException
import org.openqa.selenium.WebElement
import pages.LoginForm
import webDriver.DriverManagerHelper

import static components.CommonComponent.clickOnElement
import static webDriver.DriverManagerHelper.searchElementByCss
import static constants.Locators.*

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)


DataGridComponent driver


When(~'^I type in ([^"]*) value ([^"]*)$') { String location, String value ->
    switch (location) {
        case "LOGIN": LoginForm.typeLogin(value); break;
        case "PASSWORD": LoginForm.typePassword(value); break;
    }
}

When(~'^I click on Enter in login form$') { ->
    driver = LoginForm.clickOnEnter();
}

When(~'^I type ([^"]*) in search box and click Enter') { String value ->
    driver.typeSearchAndClickEnter(value)
}


When(~'^User clicks on ([^"]*) found email') { String subjectLookUp ->
    WebElement eMailListContainer = searchElementByCss(EMAIL_GRID)
    List<WebElement> list = eMailListContainer.findElements(By.cssSelector(EMAIL_GRID_SUBJECT))

    boolean isSubjectMatched = false
    list.each { it ->
        if (it.getText().equals(subjectLookUp)) {
            clickOnElement(it)
            isSubjectMatched = true
        }
    }
    if (!isSubjectMatched) throw new NotFoundException("Subject '$subjectLookUp' is not found")

}

When(~'^Subject is ([^"]*)') { String value ->
    assert searchElementByCss(EMAIL_TOOLBAR_SUBJECT).getText().equals(value)

}

When(~'^Body is ([^"]*)') { String value ->
    assert searchElementByCss(BODY_CONTENT).getText().equals(value)
}
When(~'^User log-out') { ->
    clickOnElement(searchElementByCss(USERNAME_HEADER))
    clickOnElement(searchElementByCss(LOGOUT_HEADER))
    DriverManagerHelper.waitElementIsVisibleByCss(LOGIN_MAINPAGE)
}
