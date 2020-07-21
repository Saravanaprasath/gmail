package pages;

import data.ReadProperties;
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

    public MapPage(WebDriver driver) throws IOException {
        this.driver = driver;
        se = new SeleniumWrapper(driver);
        readProperties = new ReadProperties();
    }

    public void goToGoogleMap() {
        try {
            driver.get(mapUrl);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FindBy(id = "searchbox-directions")
    WebElement directions;
    @FindBy(xpath = "//input[contains(@placeholder,'Choose starting point')]")
    WebElement startingPoint;
    @FindBy(xpath = "//input[contains(@placeholder,'Choose destination')]")
    WebElement destinationPoint;
    @FindBy(xpath = "//button[@aria-label='Search' and @data-tooltip='Search']")
    WebElement searchButton;

    public void findDistance() {
        try {
            se.clickElement(directions);
            String stPoint = readProperties.getPropValue(mapFile, "StartingPoint");
            String destPoint = readProperties.getPropValue(mapFile, "DestinationPoint");
            se.clickAndSendKeys(startingPoint, stPoint);
            startingPoint.sendKeys(Keys.chord(Keys.ENTER));
            se.clickAndSendKeys(destinationPoint, destPoint);
            destinationPoint.sendKeys(Keys.chord(Keys.ENTER));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
