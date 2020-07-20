package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.MapPage;
import testbase.TestBase;

public class MapPageTests extends TestBase {
    MapPage mapPage;
    public MapPageTests(){
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
