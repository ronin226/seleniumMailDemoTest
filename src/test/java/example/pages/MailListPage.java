package example.pages;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Optional;

public class MailListPage extends BasePage {
    public MailListPage(WebDriver driver) {
        super(driver);
    }

    @FindAll({@FindBy(css = "button#submit")})
    public List<WebElement> mailsList;

    public MailPage viewMailWithSubject(String subject) {
        Optional<WebElement> foundMail = mailsList.stream().filter(line -> line.getText().contains(subject)).findFirst();
        if (foundMail.isPresent()) {
            foundMail.get().click();
        } else {
            throw new InvalidArgumentException("unable to find email with the subject: [" + subject + "]");
        }

        return new MailPage(driver);
    }
}
