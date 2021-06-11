package ConfigFile_Reader;

import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Config_Holders {

    public static Properties properties;
    public static WebDriver driver;


    //Property Files Details
    public static final String Config_File_Path = "/Users/riyas/Downloads/PathFactory_Selenium/Resources/Configuration_Files/config.properties";
    public static final String Confg_File_Name = "config.properties";

    public Config_Holders() {
        //LOAD Property File
        properties = new Properties();
        String fileFormat = FilenameUtils.getExtension(Confg_File_Name);
        if (!Confg_File_Name.isEmpty()) {
            if (!Confg_File_Name.isEmpty()) {
                if (fileFormat.equals("properties")) {
                    try {
                        FileInputStream input = new FileInputStream(Config_File_Path);
                        properties.load(input);

                    } catch (IOException e) {
                        System.out.println("Failed to load user properties from :" + Confg_File_Name + "\n" + e.getMessage());
                    }
                } else {
                    System.out.println("Property file format is incorrect");
                }
            } else {
                System.out.println("Property file name is empty");
            }
        } else {
            System.out.println("Property file path is empty");
        }
    }

    //Initializing diver
    public static void Initialization() {
        //Initialize web driver
        String BrowserName = properties.getProperty("browserName");
        System.out.println("Browser Name: " + BrowserName);

        if (BrowserName.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", properties.getProperty("chromeSetUp"));
            driver = new ChromeDriver();
        } else if (BrowserName.equals("gecko")) {
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.navigate().to(Config_Holders.properties.getProperty("URL"));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }


    //GeneraicMethods for Reuse
    protected WebElement identifyElement(By locator) {

        WebElement element = driver.findElement(locator);

        return element;
    }

    //Pass Values
    protected void type(By locator, String Value) {
        WebElement element = driver.findElement(locator);
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
