package testbase;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
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
    FileInputStream stream = new FileInputStream("config.properties");
    Properties properties;
    static Logger logger;

    public TestBase() throws IOException {
        properties = new Properties();
        logger = Logger.getLogger(TestBase.class);
        if (driver == null) {
            initDriver();
        }
    }

    public void initDriver() throws IOException {
        PropertyConfigurator.configure("loggers/log4j.properties");
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
                logger.info("You are running in Chrome Browser in Windows OS");
            } else if (osName.contains("nux")) {
                System.setProperty("webdriver.chrome.driver", linuxChromeDriverPath);
                logger.info("You are running in Chrome Browser in Linux OS");
            }
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
            driver = new ChromeDriver(chromeOptions);
        }
        if (browser.contains("firefox")) {
            if (osName.contains("windows")) {
                System.setProperty("webdriver.gecko.driver", winFireFoxDriverPath);
                logger.info("You are running in Firefox Browser in Windows OS");
            } else if (osName.contains("nux")) {
                System.setProperty("webdriver.gecko.driver", linuxFireFoxDriverPath);
                logger.info("You are running in Firefox Browser in Linux OS");
            }
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
            driver = new FirefoxDriver(firefoxOptions);
        }
        driver.manage().window().maximize();
    }

}
