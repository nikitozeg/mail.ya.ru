package components

import groovy.util.logging.Slf4j
import org.openqa.selenium.StaleElementReferenceException
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import webDriver.DriverManager

@Slf4j
class CommonComponent {

    public static void clickOnElement(WebElement element) {
        try {
            Actions action = new Actions(DriverManager.getWebDriver())
            action.moveToElement(element).click(element).build().perform()

            System.out.println("Sucessfully Clicked on the element\n");
        } catch (StaleElementReferenceException e) {
            System.out.println("Element is not attached to the page document "
                    + e.getStackTrace());
        } catch (NoSuchElementException e) {
            System.out.println("Element " + element + " was not found in DOM "
                    + e.getStackTrace());
        } catch (Exception e) {
            System.out.println("Element " + element + " was not clickable "
                    + e.getStackTrace());
        }
    }


}
