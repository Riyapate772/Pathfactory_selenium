package Base_Class_Property;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Base_Page {

    protected WebDriver ldriver;

    public Base_Page(WebDriver driver) throws Exception {

        if (driver != null) {
            ldriver = driver;
        } else {
            throw new Exception("Driver is null");
        }
    }

    protected WebElement identifyElement(By locator) {

        WebElement element = ldriver.findElement(locator);

        return element;
    }

    //Pass Values
    protected void type(By locator, String Value) {
        WebElement element = ldriver.findElement(locator);
        element.sendKeys(Value);
    }

    //Check if element is present or not
    protected boolean isElementPresent(By locator, String PresentType) throws Exception {

        try {
            switch (PresentType) {
                case "isDisplayed":
                    identifyElement(locator).isDisplayed();
                    return true;

                case "isSelected":
                    identifyElement(locator).isSelected();
                    return true;

                case "isEnabled":
                    identifyElement(locator).isEnabled();
                    return true;

                default:
                    throw new Exception("Verification is not vaild!!");
            }

        } catch (Exception ex) {
            throw new Exception("Unable to vaildate presents of elemnet");
        }
    }

    protected void clickMe(By locator) {
        identifyElement(locator).click();
    }

    protected void getText(By locator) {
        String text = null;
        text = identifyElement(locator).getText();

    }


}
