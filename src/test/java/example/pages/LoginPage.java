package example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Optional;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) { super(driver); }

    @FindBy(css = "button.ph-login")
    public WebElement loginButton;

    @FindBy(css = "iframe.ag-popup__frame__layout__iframe")
    public WebElement loginFrame;

    @FindBy(css = "input[name=\"username\"]")
    public WebElement loginField;

    @FindBy(css =".domain-select")
    public WebElement subDomainField;

    @FindBy(css = "input[name=\"password\"]")
    public WebElement passwordField;

    @FindBy(css = "button[data-test-id=\"next-button\"]")
    public WebElement nextButton;

    @FindBy(css = "button[data-test-id=\"submit-button\"]")
    public WebElement submitButton;

//    public LoginPage selectSubdomain(String subDomain){
//        this.subDomainField.click();
//        Optional<WebElement> subDomainOption = driver.findElements(By.cssSelector(".Select__option")).stream().filter(line -> line.getText().contains(subDomain)).findFirst();
//        if (subDomainOption.isPresent()) {
//            subDomainOption.get().click();
//        }else {
//            throw new InvalidArgumentException("unable to find subdomain button with the value: [" + subDomain + "]");
//        }
//        return new LoginPage(driver);
//    }


    public MailListPage logIn ( String login, String password){
        loginButton.click();
        driver.switchTo().frame(loginFrame);
        loginField.sendKeys(login);
        nextButton.click();
        passwordField.sendKeys(password);
        submitButton.click();
      return new MailListPage(driver);
    }

}
