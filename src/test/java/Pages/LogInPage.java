package Pages;

import Base_Class_Property.Base_Page;
import Page_Objects.HomePage_Objects;
import Page_Objects.LogInPage_Objects;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LogInPage extends Base_Page implements LogInPage_Objects {

    public LogInPage(WebDriver driver) throws Exception {
        super(driver);
    }

    //LogIn with Valid Credential
    public MyAccount LogInWithValidCredential() throws Exception {
        try {
            if(isElementPresent(authenticateText,"isDisplayed")){
                type(emailAddress,"Rtest@test.com");
                type(password,"test123");
                clickMe(submitLogin);
            }

        } catch (Exception ex) {
            throw new Exception("LogIn Unsuccessful");

        }
        return new MyAccount(ldriver);
    }

    //LogIn with InValidCredentail: Validating Error
    public LogInPage LogInWithInValidCredential() throws Exception {
        try{
            if(isElementPresent(authenticateText,"isDisplayed")){
                type(emailAddress,"Rtest@tt.com"); //Incorrect Mail
                type(password,"test123");
                clickMe(submitLogin);
            }
            Assert.assertTrue(isElementPresent(authenticateFail,"isDisplayed"),"Error message is not displayed!!");


        }
        catch(Exception ex){

            throw new Exception("Unable to view Error Note");
        }
        return new LogInPage(ldriver);

    }

    //LogIn with Blank value: Validating Error
    public LogInPage LogInWithBlankValue() throws Exception {
        try{
            if(isElementPresent(authenticateText,"isDisplayed")){
                type(emailAddress,""); //Blank Value
                type(password,"");//Blank Value
                clickMe(submitLogin);
            }
            Assert.assertTrue(isElementPresent(BlankEmailTextBox,"isDisplayed"),"Error message is not displayed!!");


        }
        catch(Exception ex){

            throw new Exception("Unable to view Error Note");
        }
        return new LogInPage(ldriver);

    }
}
