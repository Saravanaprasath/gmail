package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.LoginPage;
import testbase.TestBase;

import java.io.IOException;

public class LoginPageTests extends TestBase {
    LoginPage loginPage;

    public LoginPageTests() throws IOException {
        super();
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    @Test
    public void loginToGmail() {
        try {
            loginPage.openGmailLoginPage();
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }


}
