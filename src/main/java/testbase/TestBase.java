package testbase;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {
    public static WebDriver driver = null;
    public static String browser = "Chrome";

    public TestBase() {
        if (driver == null) {
            initDriver();
        }
    }

    public void initDriver() {
        browser = browser.toLowerCase();
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("windows")) {
            if (browser.contains("chrome")) {
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver1.exe");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
                driver = new ChromeDriver(chromeOptions);
            }
        }
        driver.manage().window().maximize();
    }

}
