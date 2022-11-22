package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    //WebDriver defined as public static to allow access from other packages
    public static WebDriver driver;
    public void openBrowser(String baseUrl){
        //set key to value of webdriver location
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        //declare an object for ChromeDriver
        driver = new ChromeDriver();
        //launch baseUrl
        driver.get(baseUrl);
        //maximise windows
        driver.manage().window().maximize();
        //set implicit wait time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }
    public void closeBrowser(){
        //close browser
        driver.quit();
    }
}
