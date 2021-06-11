package Pages;

import Base_Class_Property.Base_Page;
import org.openqa.selenium.WebDriver;

public class MyAccount extends Base_Page implements Page_Objects.MyAccount_Objects {
    public MyAccount(WebDriver driver) throws Exception {
        super(driver);
    }
}
