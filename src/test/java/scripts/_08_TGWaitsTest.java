package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Driver;
import utils.Waiter;

public class _08_TGWaitsTest extends Base {
    /*
    TEST CASE 1
    Go to https://techglobal-training.com/frontend/
    Click on the "Waits" card
    Click on the "Click on me to see a red box" button
    Validate that a red box is displayed
     */
    @BeforeMethod
    public void setPage() {
        driver.get("https://techglobal-training.com/frontend/");
        driver.findElement(By.id("card-4")).click();
    }

    @Test
    public void validateRedBox() {
        WebElement redBox = driver.findElement(By.cssSelector("button[id*='red']"));
        redBox.click();
        WebElement redButton = driver.findElement(By.cssSelector("button[class*='red_box__k']"));
        Assert.assertTrue(redButton.isDisplayed());

    }

    @Test
    public void waitForBlueBox(){
        WebElement blueBoxButton = driver.findElement(By.id("blue"));
        blueBoxButton.click();

        WebElement blueBox = driver.findElement(By.cssSelector("button[class*='blue_box']"));


        Waiter.waitForVisibilityOfElement(blueBox, 40);

        Assert.assertTrue(blueBox.isDisplayed());
    }
}
