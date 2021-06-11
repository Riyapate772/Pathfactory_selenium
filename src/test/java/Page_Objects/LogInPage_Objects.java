package Page_Objects;

import org.openqa.selenium.By;

public interface LogInPage_Objects {

    By authenticateText= By.xpath("//h1[text()='Authentication']");
    By emailAddress= By.xpath("//input[@id='email']");
    By password=By.xpath("//input[@id='passwd']");
    By submitLogin= By.xpath("//button[@id='SubmitLogin']");
    By authenticateFail=By.xpath("//li[text()='Authentication failed.']");
    By BlankEmailTextBox=By.xpath("//li[text()='An email address required.']");

}
