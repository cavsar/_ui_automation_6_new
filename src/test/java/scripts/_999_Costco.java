package scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class _999_Costco {
    public static WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.costco.com/");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
@Test
    public void validateSearchInputBox(){
    WebElement searchInputBox= driver.findElement(By.id("search-field"));
    Assert.assertTrue(searchInputBox.isDisplayed());
    searchInputBox.sendKeys("luggage");
    WebElement searchButton = driver.findElement(By.id("searchWidgetButton"));
    Assert.assertTrue(searchButton.isEnabled());
    searchButton.click();}
}
