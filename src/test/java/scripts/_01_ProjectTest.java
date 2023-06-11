package scripts;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Waiter;

import java.util.List;

public class _01_ProjectTest extends Base {
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
        Assert.assertEquals(address.getText(), "2860 S River Rd Suite 480, Des Plaines IL 60018");
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
        Assert.assertEquals(fullNameInputBox.getAttribute("required"), "true");
        WebElement fullNameLAbel = driver.findElement(By.cssSelector("label[for='name']"));
        Assert.assertEquals(fullNameLAbel.getText(), "Full name *");
        WebElement placeholderFullName = driver.findElement(By.cssSelector("input[placeholder*='full name']"));
        Assert.assertEquals(placeholderFullName.getAttribute("placeholder"), "Enter your full name");

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
        WebElement labelGender2 = driver.findElement(By.cssSelector(".radio>input"));
        Assert.assertEquals(labelGender2.getAttribute("required"), "true");
        List<WebElement> optionsLabel = driver.findElements(By.cssSelector(".control label.radio"));
        List<WebElement> optionsInput = driver.findElements(By.cssSelector(".control label input[type='radio']"));
        String[] expectedGenders = {"Male", "Female", "Prefer not to disclose"};
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
    public void validateAddress() {
        WebElement addressInbox = driver.findElement(By.cssSelector("input[placeholder*='address']"));
        Assert.assertTrue(addressInbox.isDisplayed());
        Assert.assertFalse(Boolean.parseBoolean(addressInbox.getAttribute("required")));
        WebElement addressLabel = driver.findElement(By.xpath("//input[contains (@placeholder, 'address')]/../../label"));
        Assert.assertEquals(addressLabel.getText(), "Address");
        WebElement addressplaceholder = driver.findElement(By.cssSelector("input[placeholder*=address]"));
        Assert.assertEquals(addressplaceholder.getAttribute("placeholder"), "Enter your address");

    }

    /**
     * Navigate to https://techglobal-training.com/frontend/project-1
     * Validate that the Email input box is displayed
     * Validate that the Email input box is required
     * Validate that the label of the Email input box is “Email”
     * Validate that the placeholder of the Email input box is “Enter your email”
     */
    @Test
    public void validateEmail() {
        WebElement email = driver.findElement(By.cssSelector("input[type*='email']"));
        Assert.assertTrue(email.isDisplayed());
        Assert.assertEquals(email.getAttribute("required"), "true");
        WebElement emailLabel = driver.findElement(By.xpath("//input[contains (@type, 'email')]/../../label"));
        Assert.assertEquals(emailLabel.getText(), "Email *");
        WebElement emailPlaceholder = driver.findElement(By.cssSelector("input[type*='email']"));
        Assert.assertEquals(emailPlaceholder.getAttribute("placeholder"), "Enter your email");
    }

    /**
     * Navigate to https://techglobal-training.com/frontend/project-1
     * Validate that the Phone input box is displayed
     * Validate that the Phone input box is not required
     * Validate that the label of the Phone input box is “Phone”
     * Validate that the placeholder of the Address input box is “Enter your phone number”
     */
    @Test
    public void validatePhone() {
        WebElement phone = driver.findElement(By.cssSelector("input[type*='phone']"));
        Assert.assertTrue(phone.isDisplayed());
        Assert.assertFalse(Boolean.parseBoolean(phone.getAttribute("required")));
        WebElement phoneLabel = driver.findElement(By.xpath("//input[contains (@type, 'phone')]/../../label"));
        Assert.assertEquals(phoneLabel.getText(), "Phone");
        WebElement phonePlaceholder = driver.findElement(By.cssSelector("input[type*='phone']"));
        Assert.assertEquals(phonePlaceholder.getAttribute("placeholder"), "Enter your phone number");
    }

    /**
     * Navigate to https://techglobal-training.com/frontend/project-1
     * Validate that the Message text area is displayed
     * Validate that the Message text area is not required
     * Validate that the label of the Message text area is “Message”
     * Validate that the placeholder of the Message text area is “Type your message here…”
     */
    @Test
    public void validateMessage() {
        WebElement message = driver.findElement(By.cssSelector(".textarea"));
        Assert.assertTrue(message.isDisplayed());
        WebElement messageLabel = driver.findElement(By.xpath("//textarea[@class]/../../label"));
        Assert.assertEquals(messageLabel.getText(), "Message");
        WebElement messagePlaceholder = driver.findElement(By.xpath("//textarea[@class]"));
        Assert.assertEquals(messagePlaceholder.getAttribute("placeholder"), "Type your message here...");

    }

    /**
     * Navigate to https://techglobal-training.com/frontend/project-1
     * Validate the label is “I give my consent to be contacted.”
     * Validate that the Consent checkbox is required
     * Validate that the Consent checkbox is clickable
     * Click on the “I give my consent to be contacted.” checkbox and validate it is selected
     * Click on the “I give my consent to be contacted.” checkbox again and validate it is not selected
     */
    @Test
    public void validateConsentCheckBox() {
        WebElement consentLabel = driver.findElement(By.cssSelector("label.checkbox"));
        Assert.assertEquals(consentLabel.getText(), "I give my consent to be contacted.");
        WebElement consentCheckBox = driver.findElement(By.cssSelector("input[type='checkbox']"));
        Assert.assertEquals(consentCheckBox.getAttribute("required"), "true");
        Assert.assertTrue(consentCheckBox.isEnabled());
        consentCheckBox.click();
        Assert.assertTrue(consentCheckBox.isSelected());
        consentCheckBox.click();
        Assert.assertFalse(consentCheckBox.isSelected());

    }

    /**
     * Navigate to https://techglobal-training.com/frontend/project-1
     * Validate the “SUBMIT” button is displayed
     * Validate the “SUBMIT” button is clickable
     * Validate that the button text is “SUBMIT”
     */

    @Test
    public void validatesubmission() {
        WebElement submitButton = driver.findElement(By.cssSelector(".is-link"));
        Assert.assertTrue(submitButton.isDisplayed());
        Assert.assertTrue(submitButton.isEnabled());
        Assert.assertEquals(submitButton.getText(), "SUBMIT");
    }

    /**
     * Navigate to https://techglobal-training.com/frontend/project-1
     * Enter a first name
     * Select a gender
     * Enter an address
     * Enter an email
     * Enter a phone number
     * Enter a message
     * Select the “I give my consent to be contacted.” checkbox
     * Click on the “SUBMIT” button
     * Validate the form message “Thanks for submitting!” is displayed under the “SUBMIT” button
     */
    @Test(priority = 10, description = "Test Case 10 - Validate the form submission")
    public void validateTheFormSubmission(){
        Faker faker = new Faker();

        WebElement nameInputBox = driver.findElement(By.xpath("//label[@for='name']/..//input"));
        List<WebElement> genders = driver.findElements(By.cssSelector(".mr-1"));
        WebElement addressInputBox = driver.findElement(By.xpath("//label[text()='Address']/..//input"));
        WebElement emailInputBox = driver.findElement(By.cssSelector("input[type='email']"));
        WebElement phoneInputBox = driver.findElement(By.cssSelector("input[type='phone']"));
        WebElement messageTextArea = driver.findElement(By.tagName("textarea"));
        WebElement consentCheckBox = driver.findElement(By.cssSelector("input[type='checkbox']"));
        WebElement submitButton = driver.findElement(By.cssSelector(".is-link"));

        nameInputBox.sendKeys(faker.name().fullName());
        genders.get(0).click();
        addressInputBox.sendKeys(faker.address().fullAddress());
        emailInputBox.sendKeys("abcd@gmail.com");
        phoneInputBox.sendKeys(faker.phoneNumber().cellPhone());
        messageTextArea.sendKeys(faker.gameOfThrones().quote());
        consentCheckBox.click();
        submitButton.click();

        WebElement confirmationMessage = driver.findElement(By.cssSelector(".mt-5"));

        Assert.assertTrue(confirmationMessage.isDisplayed());
        Assert.assertEquals(confirmationMessage.getText(), "Thanks for submitting!");

        Waiter.pause(30);
    }
}


