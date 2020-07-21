package pages;

import data.ReadProperties;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import selenium.SeleniumWrapper;
import testbase.TestBase;

import java.io.IOException;

public class MapPage extends TestBase {
    WebDriver driver;
    SeleniumWrapper se;
    ReadProperties readProperties;
    String mapUrl = "https://www.google.com/maps";
    String mapFile = "map.properties";
    static Logger logger;

    public MapPage(WebDriver driver) throws IOException {
        this.driver = driver;
        se = new SeleniumWrapper(driver);
        readProperties = new ReadProperties();
        logger = Logger.getLogger(MapPage.class);
    }

    @FindBy(id = "searchbox-directions")
    WebElement directions;
    @FindBy(xpath = "//input[contains(@placeholder,'Choose starting point')]")
    WebElement startingPoint;
    @FindBy(xpath = "//input[contains(@placeholder,'Choose destination')]")
    WebElement destinationPoint;
    @FindBy(xpath = "//button[@aria-label='Search' and @data-tooltip='Search']")
    WebElement searchButton;
    @FindBy(xpath = "//span[@id='fineprint-copyrights' and contains(text(),'Map data')]")
    WebElement mapData;
    @FindBy(xpath = "//div[@class='section-directions-trip-description']//div[contains(text(),'km')]")
    WebElement distance;

    public boolean goToGoogleMap() {
        boolean res = false;
        try {
            driver.get(mapUrl);
            if (mapData.isDisplayed()) {
                res = true;
                logger.info(mapUrl + " is opened");
            } else {
                logger.error(mapUrl + " is not opened");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public boolean findDistance() {
        boolean res = false;
        try {
            se.clickElement(directions);
            String stPoint = readProperties.getPropValue(mapFile, "StartingPoint");
            String destPoint = readProperties.getPropValue(mapFile, "DestinationPoint");
            se.clickAndSendKeys(startingPoint, stPoint);
            startingPoint.sendKeys(Keys.chord(Keys.ENTER));
            se.clickAndSendKeys(destinationPoint, destPoint);
            destinationPoint.sendKeys(Keys.chord(Keys.ENTER));
            if(distance.isDisplayed()){
                logger.info(distance.getText() + " is the distance between two places");
                res = true;
            }else{
                logger.error("Unable to find the distance");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }


}
