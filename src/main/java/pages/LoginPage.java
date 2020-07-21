package pages;

import data.ReadProperties;
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

    public LoginPage(WebDriver driver) throws IOException {
        super();
        this.driver = driver;
        se = new SeleniumWrapper(driver);
        readProperties = new ReadProperties();
    }

    @FindBy(id = "identifierId")
    WebElement emailId;
    @FindBy(id="identifierNext")
    WebElement idNextButton;
    @FindBy(name="password")
    WebElement password;
    @FindBy(id="passwordNext")
    WebElement pwdNextButton;

    public void openGmailLoginPage() {
        try {
            driver.get(url);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            String email = readProperties.getPropValue(fileName, "emailid");
            String pswd= readProperties.getPropValue(fileName,"password");
            se.clickAndSendKeys(emailId, email);
            se.clickElement(idNextButton);
            boolean res = se.waitForElementVisible(password);
            if(res){
                se.clickAndSendKeys(password,pswd);
                se.clickElement(pwdNextButton);
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }



   /* @FindBy(id = "ReviewTitle")
    WebElement reviewTitle;

    @FindBy(id = "ReviewText")
    WebElement reviewText;


    public void fillForms(){
        try{
            reviewTitle.sendKeys(readProperties.getPropValue(fileName,"reviewTitle"));
            reviewText.sendKeys(readProperties.getPropValue(fileName,"review"));
        } catch (Exception e){
            e.printStackTrace();
            e.getMessage();
        }
    }*/
}
