package selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testbase.TestBase;

import java.util.concurrent.TimeUnit;

public class SeleniumWrapper extends TestBase {
    WebDriver driver;

    public SeleniumWrapper(WebDriver driver) {
        this.driver = driver;
    }

    public void jsExecutor(String script) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script);
    }

    long timeoutInSec = 30;

    public void clickAndSendKeys(WebElement element, String string) {
        try {
            if (element.isDisplayed()) {
                element.click();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                element.sendKeys(string);
            } else {
                System.out.println("Element not displayed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickElement(WebElement element) {
        try {
            if (element.isDisplayed()) {
                element.click();
            } else {
                System.out.println("Element not displayed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean waitForElementVisible(WebElement element) {
        boolean res = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeoutInSec);
            wait.until(ExpectedConditions.visibilityOf(element));
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

}
