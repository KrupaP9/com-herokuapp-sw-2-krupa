package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class UtilityHerokuApp extends BaseTest {
    public void clickOnElement(By by){
        //find element to click, store within link
        WebElement link = driver.findElement(by);
        //click on element
        link.click();
    }
    public void sendTextToElement(By by, String text){
        //Find field to add text
        WebElement field = driver.findElement(by);
        //send text
        field.sendKeys(text);
    }
    public String getTextFromElement(By by){
        //find field which will return message
        WebElement actualMessageElement = driver.findElement(by);
        //return message as text
        return actualMessageElement.getText();
    }
}
