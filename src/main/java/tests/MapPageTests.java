package tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.MapPage;
import testbase.TestBase;

import java.io.IOException;

public class MapPageTests extends TestBase {
    MapPage mapPage;
    static Logger logger;

    public MapPageTests() throws IOException {
        super();
        mapPage = PageFactory.initElements(driver, MapPage.class);
        logger = Logger.getLogger(MapPageTests.class);
    }

    @Test
    public void goToMap() {
        try {
            boolean res = mapPage.goToGoogleMap();
            if (res) {
                logger.info("Map url is opened");
            } else {
                logger.error("Map url is not opened");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findDistances() {
        try {
            boolean res = mapPage.findDistance();
            if (res) {
                logger.info("Distance found");
            } else {
                logger.error("Unable to find the distance");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
