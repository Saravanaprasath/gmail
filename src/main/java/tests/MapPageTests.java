package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.MapPage;
import testbase.TestBase;

import java.io.IOException;

public class MapPageTests extends TestBase {
    MapPage mapPage;
    public MapPageTests() throws IOException {
        super();
        mapPage = PageFactory.initElements(driver,MapPage.class);
    }

    @Test
    public void goToMap(){
        try{
            mapPage.goToGoogleMap();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void findDistances(){
        try{
            mapPage.findDistance();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
