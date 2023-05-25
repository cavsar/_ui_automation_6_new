package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _01_Project1 extends Base {
    /*
    Navigate to https://techglobal-training.com/frontend/project-1
    Validate the heading is “Contact Us”
    Validate the address is “2860 S River Rd Suite 350, Des Plaines IL 60018”
    Validate the email is “info@techglobalschool.com"
    Validate the phone number is “(773) 257-3010”
     */

    @BeforeMethod
    public void setPage() {
        driver.get("https://techglobal-training.com/frontend/project-1");

    }

    @Test
    public void validateContactUsInfo() {
        WebElement header = driver.findElement(By.xpath("//h1"));
        WebElement address = driver.findElement(By.id("address"));
        WebElement email = driver.findElement(By.id("email"));
        WebElement phone = driver.findElement(By.id("phone-number"));
        Assert.assertTrue(header.isDisplayed());
        Assert.assertEquals(header.getText(), "Contact Us");
        Assert.assertTrue(address.isDisplayed());
        Assert.assertEquals(address.getText(), "2860 S River Rd Suite 350, Des Plaines IL 60018");
        Assert.assertTrue(email.isDisplayed());
        Assert.assertEquals(email.getText(), "info@techglobalschool.com");
        Assert.assertTrue(phone.isDisplayed());
        Assert.assertEquals(phone.getText(), "(773) 257-3010");

    }

    /*
    Navigate to https://techglobal-training.com/frontend/project-1
    Validate that the Full name input box is displayed
    Validate that the Full name input box is required
    Validate that the label of the Full name input box is “Full name”
    Validate that the placeholder of the Full name input box is “Enter your name”
     */
    @Test
    public void validateFullNameInputBox() {
        WebElement fullNameInputBox = driver.findElement(By.cssSelector("input[placeholder*='Enter your full name']"));
        Assert.assertTrue(fullNameInputBox.isDisplayed());


    }

}
