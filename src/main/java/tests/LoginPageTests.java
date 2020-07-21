package tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.LoginPage;
import testbase.TestBase;

import java.io.IOException;

public class LoginPageTests extends TestBase {
    LoginPage loginPage;
static Logger logger;
    public LoginPageTests() throws IOException {
        super();
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        logger = Logger.getLogger(LoginPageTests.class);
    }

    @Test
    public void loginToGmail() {
        boolean res = false;
        try {
            res = loginPage.openGmailLoginPage();
            if(res){
                logger.info("Logged in successfully");
            }else{
                logger.error("Unable to logged in to Gmail");
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }

    }


}
