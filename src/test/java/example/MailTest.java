package example;

import example.pages.LoginPage;
import example.pages.MailListPage;
import example.pages.MailPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class MailTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private MailListPage mailListPage;
    private MailPage mailPage;
    private String login;
    private String password;


    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://mail.ru/");

        loginPage = new LoginPage(driver);

        loadProperties();


    }

    private void loadProperties() {
        login = System.getenv("mail_login");
        password = System.getenv("mail_password");

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void loginTest() {
        mailListPage = loginPage.logIn(login,password);
        mailPage= mailListPage.viewMailWithSubject("Вход с нового устройства в аккаунт");
        mailPage.validateMailBody("Если вы этого не делали");


    }




}
