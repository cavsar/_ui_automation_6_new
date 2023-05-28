package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Waiter;

import java.util.List;
import java.util.Objects;

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
        WebElement fullNameInputBox = driver.findElement(By.cssSelector("input[placeholder='Enter your full name']"));
        Assert.assertTrue(fullNameInputBox.isDisplayed());
        WebElement fullNameLAbel = driver.findElement(By.cssSelector("label[for='name']"));
        Assert.assertEquals(fullNameLAbel.getText(), "Full name *");
        WebElement placeholderFullName = driver.findElement(By.cssSelector("input[placeholder*='Enter your full name']"));
        Assert.assertEquals(placeholderFullName.getAttribute("placeholder"), "Enter your name");

    }

    @Test
    public void validateGenderRadioButton() {
        /*
        Navigate to https://techglobal-training.com/frontend/project-1
        Validate the label is “Gender”
        Validate that the Gender is required
        Validate the options are “Female”, “Male” and “Prefer not to disclose”
        Validate the options are clickable and not selected
        Click on the “Male” option and validate it is selected while the others are not selected
        Click on the “Female” option and validate it is selected while the others are not selected
         */
        WebElement labelGender = driver.findElement(By.cssSelector("div[class='control']>label[class='label']"));
        Assert.assertEquals(labelGender.getText(), "Gender *");
        List<WebElement> optionsLabel= driver.findElements(By.cssSelector(".control label.radio"));
        List<WebElement> optionsInput= driver.findElements(By.cssSelector(".control label input[type='radio']"));
        String[] expectedGenders={"Male", "Female", "Prefer not to disclose"};
        for (int i = 0; i < 2; i++) {
            Assert.assertEquals(optionsLabel.get(i).getText(), expectedGenders[i]);
            Assert.assertTrue(optionsLabel.get(i).isEnabled());
            Assert.assertFalse(optionsLabel.get(i).isSelected());

        }
        optionsInput.get(0).click();
        Waiter.pause(3);

        for (int i = 0; i < optionsInput.size(); i++) {
            if (i == 0) continue;
            Assert.assertFalse(optionsInput.get(i).isSelected());
        }
        optionsInput.get(1).click();
        Waiter.pause(5);

        for (int i = 0; i < optionsInput.size(); i++) {
            if (i == 1) continue;
            Assert.assertFalse(optionsInput.get(i).isSelected());
        }
        }
    /**
     * Navigate to https://techglobal-training.com/frontend/project-1
     * Validate that the Address input box is displayed
     * Validate that the Address input box is not required
     * Validate that the label of the Address input box is “Address”
     * Validate that the placeholder of the Address input box is “Enter your address*”
     */
    @Test
    public void validateAddress(){
        WebElement addressInbox = driver.findElement(By.cssSelector("input[placeholder*='address']"));
        Assert.assertTrue(addressInbox.isDisplayed());
        WebElement addressLabel =driver.findElement(By.xpath("//input[contains (@placeholder, 'address')]/../../label"));
        Assert.assertEquals(addressLabel.getText(),"Address");
        WebElement addressplaceholder = driver.findElement(By.cssSelector("input[placeholder*=address]"));
        Assert.assertEquals(addressplaceholder.getAttribute("placeholder"),"Enter your address");

    }
    /**
     * Navigate to https://techglobal-training.com/frontend/project-1
     * Validate that the Email input box is displayed
     * Validate that the Email input box is required
     * Validate that the label of the Email input box is “Email”
     * Validate that the placeholder of the Email input box is “Enter your email”
     */
    @Test
    public void validateEmail(){
        WebElement email = driver.findElement(By.cssSelector("input[type*='email']"));
        Assert.assertTrue(email.isDisplayed());
        WebElement emailLabel = driver.findElement(By.xpath("//input[contains (@type, 'email')]/../../label"));
        Assert.assertEquals(emailLabel.getText() ,"Email *");
        WebElement emailPlaceholder = driver.findElement(By.cssSelector("input[type*='email']"));
        Assert.assertEquals(emailPlaceholder.getAttribute("placeholder"),"Enter your email");
    }


}


