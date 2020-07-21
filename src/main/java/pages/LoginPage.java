package pages;

import data.ReadProperties;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.SeleniumWrapper;
import testbase.TestBase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LoginPage extends TestBase {
    WebDriver driver;
    SeleniumWrapper se;
    ReadProperties readProperties;
    String fileName = "data.properties";
    public static String url = "https://mail.google.com/";
    static Logger logger;

    public LoginPage(WebDriver driver) throws IOException {
        super();
        this.driver = driver;
        se = new SeleniumWrapper(driver);
        readProperties = new ReadProperties();
        logger = Logger.getLogger(LoginPage.class);
    }

    @FindBy(id = "identifierId")
    WebElement emailId;
    @FindBy(id = "identifierNext")
    WebElement idNextButton;
    @FindBy(name = "password")
    WebElement password;
    @FindBy(id = "passwordNext")
    WebElement pwdNextButton;

    public boolean openGmailLoginPage() {
        boolean res = false;
        try {
            driver.get(url);
            logger.info(url + " is opened");
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            String email = readProperties.getPropValue(fileName, "emailid");
            String pswd = readProperties.getPropValue(fileName, "password");
            se.clickAndSendKeys(emailId, email);
            se.clickElement(idNextButton);
            res = se.waitForElementVisible(password);
            if (res) {
                se.clickAndSendKeys(password, pswd);
                se.clickElement(pwdNextButton);
                res = true;
            }
            logger.info("Email & Password entered");
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
        return res;
    }
}
