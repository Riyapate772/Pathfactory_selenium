package Pages;

import ConfigFile_Reader.Config_Holders;
import Page_Objects.HomePage_Objects;

public class HomePage extends Config_Holders implements HomePage_Objects {


    public LogInPage ClickOnSignInPage() throws Exception {
        Thread.sleep(3000);
        clickMe(SignInButton);
        return new LogInPage(driver);
    }
}
