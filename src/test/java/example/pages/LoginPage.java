package example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) { super(driver); }

    @FindBy
    public WebElement loginButton;

    @FindBy
    public WebElement loginField;

    @FindBy
    public WebElement subDomainField;

    public WebElement passwordField;

    public WebElement submitButton;


    public MailListPage logIn ( String login, String password){
        loginButton.click();
        passwordField.sendKeys(password);
        loginField.sendKeys(login);
        submitButton.click();
      return new MailListPage(driver);
    }

}
