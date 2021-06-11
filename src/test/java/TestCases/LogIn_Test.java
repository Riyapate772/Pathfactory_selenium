package TestCases;

import ConfigFile_Reader.Config_Holders;
import Pages.HomePage;
import Pages.LogInPage;
import Pages.MyAccount;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogIn_Test extends Config_Holders {
    HomePage homePage = new HomePage();
    protected static LogInPage logInPage;
    protected static MyAccount myAccount;

    public LogIn_Test() throws Exception {
        super();
    }

    @BeforeMethod
    public void SetUp() throws Exception {
        Initialization();
        logInPage = homePage.ClickOnSignInPage();
    }

    // Login with valid credential to validate positive test scenario.
    @Test
    public void UserLogIn_Actions() throws Exception {
        myAccount = logInPage.LogInWithValidCredential();
    }

    //LogIn with InValidCredentail: Validating Error
    @Test
    public void InvalidUser_LogIn() throws Exception {
        logInPage = logInPage.LogInWithInValidCredential();

    }

    //LogIn with BlankEmailandPW: Validating Error
    @Test
    public void BlankValues_LogIn() throws Exception {
        logInPage = logInPage.LogInWithBlankValue();

    }

    @AfterMethod
    public void CloseBrowser() {
        driver.quit();
    }
}
