package pages;

import data.ReadProperties;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import selenium.SeleniumWrapper;
import testbase.TestBase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GmailPage extends TestBase {

    WebDriver driver;
    SeleniumWrapper se;
    ReadProperties readProperties;
    String fileName = "data.properties";

    public GmailPage(WebDriver driver) throws IOException {
        super();
        this.driver = driver;
        se = new SeleniumWrapper(driver);
        readProperties = new ReadProperties();
    }

    @FindBy(xpath = "//div[@role='button' and text()='Compose']")
    WebElement composeBtn;
    @FindBy(xpath = "//img[@alt='Pop-out']")
    WebElement popOut;
    @FindBy(xpath = "//textarea[@name='to']")
    WebElement recipient;
    @FindBy(xpath = "//input[@name='subjectbox']")
    WebElement subject;
    @FindBy(xpath = "//div[@aria-label='Message Body']")
    WebElement messageBody;
    @FindBy(xpath = "//div[text()='Send']")
    WebElement sendBtn;
    @FindBy(xpath = "//a[contains(@href,'#sent')]")
    WebElement sentTab;

    public void openComposeWindow() {
        try {
            boolean res = se.waitForElementVisible(composeBtn);
            if (res) {
                se.clickElement(composeBtn);
                se.clickElement(popOut);
            }
        } catch (Exception e) {
            e.getStackTrace();
            e.getMessage();
        }
    }

    public void composeMail() {
        try {
            String recipientId = readProperties.getPropValue(fileName, "recipientEmailId");
            String emailSubject = readProperties.getPropValue(fileName, "emailSubject");
            String message = readProperties.getPropValue(fileName, "content");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            Thread.sleep(5000);
            boolean res = se.waitForElementVisible(recipient);
            if (res) {
                se.clickAndSendKeys(recipient, recipientId);
                se.clickAndSendKeys(subject, emailSubject);
                se.clickAndSendKeys(messageBody, message);
            }
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            se.clickElement(sendBtn);
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }

    @FindBy(xpath = "//div[@aria-label='Show details']")
    WebElement showDetails;

    public void verifyInSentBox() {
        try {
            Thread.sleep(5000);
            se.clickElement(sentTab);
            String emailSubject = readProperties.getPropValue(fileName, "emailSubject");
            String sentId = readProperties.getPropValue(fileName,"recipientEmailId");
            String subjectXp1 = "(//span[text()='" + emailSubject + "']//ancestor::td[@id and @tabindex='-1' and @role='gridcell'])[1]";
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            WebElement emailSubInSentBox = driver.findElement(By.xpath(subjectXp1));
            se.clickElement(emailSubInSentBox);
            String headingXp = "//h2[text()='" + emailSubject + "']";
            se.clickElement(showDetails);
            String sendId = "//table//tr[2]//td[2]//span[@data-hovercard-id='"+sentId+"']";
            //WebElement senderID = driver.findElement(By.xpath(sendId));
            if (driver.findElement(By.xpath(headingXp)).isDisplayed()&&driver.findElement(By.xpath(sendId)).isDisplayed()) {
                System.out.println("Email Sent");
            } else {
                System.out.println("Email Not sent");
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }

}
