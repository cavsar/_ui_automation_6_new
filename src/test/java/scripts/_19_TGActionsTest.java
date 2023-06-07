package scripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Waiter;

public class _19_TGActionsTest extends Base{
    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend");
        driver.findElement(By.id("card-15")).click();
        actions=new Actions(driver);
    }
    /**
     * Test Case 1: Click Action
     * Go to https://techglobal-training.com/frontend/
     * Click on the "Actions" card
     * Verify that the user is redirected to the Actions page
     * Verify that the first three web elements are present and labeled as "Click on me", "Right-Click on me", and "Double-Click on me"
     * Perform a click action on the first web element labeled "Click on me"
     * Verify that a message appears next to the element stating, "You clicked on a button!"
     * Perform a right-click action on the second web element labeled "Right-Click on me"
     * Verify that the message appears next to the element stating, "You right-clicked on a button!"
     * Perform a double-click action on the third web element labeled "Double-Click on me"
     * Verify that the message appears next to the element stating, "You double-clicked on a button!"
     */
    @Test
    public void mouseActions(){
        WebElement clickOnMeButton= driver.findElement(By.id("click"));
        actions.moveToElement(clickOnMeButton).click().perform();
        WebElement elementResultClickOnMeButton= driver.findElement(By.id("click_result"));
        Assert.assertEquals(elementResultClickOnMeButton.getText(),"You clicked on a button!");

        WebElement rightClickOnMeButton = driver.findElement(By.id("right-click"));
        actions.moveToElement(rightClickOnMeButton).contextClick().perform();
        WebElement elementResult = driver.findElement(By.id("right_click_result"));
        Assert.assertEquals(elementResult.getText(),"You right-clicked on a button!");

        WebElement doubleClickOnMeButton = driver.findElement(By.id("double-click"));
        actions.moveToElement(doubleClickOnMeButton).doubleClick().perform();
        WebElement elementResultDoubleClick= driver.findElement(By.id("double_click_result"));
        Assert.assertEquals(elementResultDoubleClick.getText(),"You double-clicked on a button!");


    }
    /**
     * TEST CASE 2
     * Go to https://techglobal-training.com/frontend/
     * Click on the "Actions" card
     * Verify that the last two web elements are present and labeled as "Drag Me", and "Drop Here",
     * Perform a Drag and Drop action on the "Drag Me" web element, and drop it to "Drop Here"
     * Verify that the first web element "Drag me" is successfully dropped into the second web element "Drop Here"
     * Verify that a message appears next to the web element stating, "An element dropped here!"
     */

    @Test
    public void DragAndDrop(){
        WebElement dragButton = driver.findElement(By.id("drag_element"));
        WebElement dropButton = driver.findElement(By.id("drop_element"));

        actions.moveToElement(dragButton).clickAndHold().moveToElement(dropButton).release().perform();

        WebElement resultText = driver.findElement(By.id("drag_and_drop_result"));
        Waiter.waitForVisibilityOfElement(resultText,4);
        Assert.assertEquals(resultText.getText(),"An element dropped here!");
    }
}






















