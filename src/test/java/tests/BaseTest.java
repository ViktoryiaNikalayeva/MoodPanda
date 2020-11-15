package tests;

import com.codeborne.selenide.Configuration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class BaseTest {

    String email = "v55.mailinator.com";
    String password = "123456";

    LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.timeout = 10000;
        Configuration.headless = false;
        loginPage = new LoginPage();

    }

    @AfterMethod
    public void closeBrowser() {
        getWebDriver().quit();
    }

}
