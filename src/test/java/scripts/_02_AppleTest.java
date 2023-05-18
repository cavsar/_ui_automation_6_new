package scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class _02_AppleTest {
    public static WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.apple.com/");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();

    }
    /*
    Go to https://www.apple.com/
Validate its title is apple
Validate its URL is https://www.apple.com/
     */

    @Test
    public void validateTitleAndURL(){
        System.out.println("The title is = "+ driver.getTitle());
        System.out.println("The current URL is = "+driver.getCurrentUrl());
        Assert.assertEquals(driver.getTitle(),"Apple");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.apple.com/");
    }



}
