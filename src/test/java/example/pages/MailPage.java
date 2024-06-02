package example.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailPage extends BasePage{
    public MailPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div.letter-body")
    public WebElement letterBody;

    public void validateMailBody(String expectedText){
        waitForElementVisible(letterBody);
        Assertions.assertTrue(letterBody.getText().contains(expectedText));
    }

}
