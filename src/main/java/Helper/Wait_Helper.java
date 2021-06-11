package Helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait_Helper {


        public static void Waitclickable(WebDriver driver, String attribute, String value)
        {


            if (attribute == "id")
            {
                WebDriverWait wait= new WebDriverWait(driver, 20);
                wait.until(ExpectedConditions.elementToBeClickable(By.id(value)));

            }
            if (attribute == "xpath")
            {
                WebDriverWait wait= new WebDriverWait(driver, 30);
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(value)));

            }
            if (attribute == "css")
            {
                WebDriverWait wait= new WebDriverWait(driver, 20);
                wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(value)));

            }
            if (attribute == "name")
            {
                WebDriverWait wait= new WebDriverWait(driver, 20);
                wait.until(ExpectedConditions.elementToBeClickable(By.name(value)));

            }
            if (attribute == "cssSelector")
            {
                WebDriverWait wait= new WebDriverWait(driver, 30);
                wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(value)));

            }

        }

        public static void Waitvisible(WebDriver driver, String attribute, String value)
        {
            if (attribute == "id")
            {
                WebDriverWait wait= new WebDriverWait(driver, 20);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(value)));
            }
            if (attribute == "xpath")
            {
                WebDriverWait wait= new WebDriverWait(driver, 30);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value)));
            }

            if (attribute == "name")
            {
                WebDriverWait wait= new WebDriverWait(driver, 20);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(value)));
            }

            if (attribute == "className")
            {
                WebDriverWait wait= new WebDriverWait(driver, 30);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(value)));
            }

            if (attribute == "tagName")
            {
                WebDriverWait wait= new WebDriverWait(driver, 20);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(value)));

            }
            if (attribute == "cssSelector")
            {
                WebDriverWait wait= new WebDriverWait(driver, 20);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(value)));

            }

        }
    }



