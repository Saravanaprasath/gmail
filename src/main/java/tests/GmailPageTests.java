package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.GmailPage;
import testbase.TestBase;

public class GmailPageTests extends TestBase {
    GmailPage gmailPage;

    public GmailPageTests(){
        gmailPage = PageFactory.initElements(driver,GmailPage.class);
    }

    @Test
    public void composeAndSend(){
        try{
            gmailPage.openComposeWindow();
            gmailPage.composeMail();
        } catch (Exception e){
            e.printStackTrace();
            e.getMessage();
        }
    }

    @Test
    public void verifyEmailInSentBox(){
        try{
            gmailPage.verifyInSentBox();
        } catch (Exception e){
            e.printStackTrace();
            e.getMessage();
        }
    }

}
