package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.UtilityHerokuApp;

public class LoginTest extends UtilityHerokuApp {
    @Before
    public void openTheBrowser(){
       //open browser and launch URL
        openBrowser("http://the-internet.herokuapp.com/login");
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //Enter “tomsmith” username
        sendTextToElement(By.xpath("//input[@name='username']"),"tomsmith");
        //Enter “SuperSecretPassword!” password
        sendTextToElement(By.xpath("//input[@name='password']"),"SuperSecretPassword!");
        //Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//button[@class='radius']"));
        //define expected text on the page
        String expectedText = "Secure Area";
        //get actual text displayed on the page
        String actualText = getTextFromElement(By.xpath("//h2[text()=' Secure Area']"));
        //Verify the text “Secure Area” is as expected
        Assert.assertEquals("Not in secure area", expectedText,actualText);
    }
    @Test
    public void verifyTheUsernameErrorMessage(){
        //Enter “tomsmith1” username
        sendTextToElement(By.xpath("//input[@name='username']"),"tomsmith1");
        //Enter “SuperSecretPassword!” password
        sendTextToElement(By.xpath("//input[@name='password']"),"SuperSecretPassword!");
        //Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//button[@class='radius']"));
        //Define whole expected message
        String expectedMessage = "Your username is invalid!"+"\n×";
        //Get actual message
        String actualMessage = getTextFromElement(By.xpath("//div[@class='flash error']"));
        //Verify the error message “Your username is invalid!”
        Assert.assertEquals("Invalid Message Did Not Appear",expectedMessage,actualMessage);
    }
    @Test
    public void verifyThePasswordErrorMessage(){
        //Enter “tomsmith” username
        sendTextToElement(By.xpath("//input[@name='username']"),"tomsmith");
        //Enter “SuperSecretPassword” password
        sendTextToElement(By.xpath("//input[@name='password']"),"SuperSecretPassword");
        //Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//button[@class='radius']"));
        //Define Expected message
        String expectedMessage = "Your password is invalid!"+"\n×";
        //Get actual message
        String actualMessage = getTextFromElement(By.xpath("//div[@class='flash error']"));
        //Verify the error message “Your password is invalid!”
        Assert.assertEquals("Invalid Password Message Did Not Appear",expectedMessage,actualMessage);
    }
    @After
    public void tearDown(){
        //quit the browser
        closeBrowser();
    }
}
