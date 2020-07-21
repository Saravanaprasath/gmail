package testbase;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
    public static WebDriver driver = null;
    //public static String browser = "Chrome";
    FileInputStream stream = new FileInputStream("config.properties");
    Properties properties;

    public TestBase() throws IOException {
        properties = new Properties();
        if (driver == null) {
            initDriver();
        }
    }

    public void initDriver() throws IOException {
        //browser = browser.toLowerCase();
        //String osName = System.getProperty("os.name").toLowerCase();
        properties.load(stream);
        String osName = properties.getProperty("os");
        String browser = properties.getProperty("browser");
        String winChromeDriverPath = properties.getProperty("win_chromedriverpath");
        String linuxChromeDriverPath = properties.getProperty("linux_chromedriverpath");
        String winFireFoxDriverPath = properties.getProperty("win_firefoxdriverpath");
        String linuxFireFoxDriverPath = properties.getProperty("linux_firefoxdriverpath");
        if (browser.contains("chrome")) {
            if (osName.contains("windows")) {
                System.setProperty("webdriver.chrome.driver", winChromeDriverPath);
            } else if (osName.contains("nux")) {
                System.setProperty("webdriver.chrome.driver", linuxChromeDriverPath);
            }
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
            driver = new ChromeDriver(chromeOptions);
        }
        if (browser.contains("firefox")) {
            if (osName.contains("windows")) {
                System.setProperty("webdriver.gecko.driver", winFireFoxDriverPath);
            } else if (osName.contains("nux")) {
                System.setProperty("webdriver.gecko.driver", linuxFireFoxDriverPath);
            }
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
            driver = new FirefoxDriver(firefoxOptions);
        }



        /*if (osName.contains("windows")) {
            if (browser.contains("chrome")) {
                System.setProperty("webdriver.chrome.driver", winChromeDriverPath);
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
                driver = new ChromeDriver(chromeOptions);
            } else if(browser.contains("firefox")){
                System.setProperty("webdriver.gecko.driver",winFireFoxDriverPath);
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
                driver = new FirefoxDriver(firefoxOptions);
            }
        }*/

        driver.manage().window().maximize();
    }

}
