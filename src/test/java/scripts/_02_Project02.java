package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Waiter;

import static scripts._01_GoogleTest.driver;

public class _02_Project02 extends Base {
    @BeforeMethod
    public void setPage() {
        driver.get("https://techglobal-training.com/frontend/project-2");
    }

    /**
     * Navigate to https://techglobal-training.com/frontend/project-2
     * Validate that the username input box is displayed
     * Validate that the username input box is not required
     * Validate that the label of the username input box is “Please enter your username”
     * Validate that the password input box is displayed
     * Validate that the password input box is not required
     * Validate that the label of the password input box is “Please enter your password”
     * Validate the “LOGIN” button is displayed
     * Validate the “LOGIN” button is clickable
     * Validate that the button text is “LOGIN”
     * Validate the “Forgot Password?” link is displayed
     * Validate that the “Forgot Password?” link is clickable
     * Validate that the link text is “Forgot Password?”
     */
    @Test
    public void validateLoginForm() {
        WebElement usernameInputBox = driver.findElement(By.id("username"));
        WebElement usernameLabel = driver.findElement(By.xpath("//input[@id='username']/../label"));
        WebElement passwordInputBox = driver.findElement(By.id("password"));
        WebElement passwordLabel = driver.findElement(By.xpath("//input[@id='password']/../label"));
        WebElement loginButton = driver.findElement(By.id("login_btn"));
        WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot Password?"));
        Assert.assertTrue(usernameInputBox.isDisplayed());
        Assert.assertFalse(Boolean.parseBoolean(usernameInputBox.getAttribute("required")));
        Assert.assertEquals(usernameLabel.getText(), "Please enter your username");
        Assert.assertTrue(passwordInputBox.isDisplayed());
        Assert.assertFalse(Boolean.parseBoolean(passwordInputBox.getAttribute("required")));
        Assert.assertEquals(passwordLabel.getText(), "Please enter your password");
        Assert.assertTrue(loginButton.isDisplayed());
        Assert.assertTrue(loginButton.isEnabled());
        Assert.assertTrue(forgotPasswordLink.isDisplayed());
        Assert.assertTrue(forgotPasswordLink.isEnabled());
        Assert.assertEquals(forgotPasswordLink.getText(), "Forgot Password?");
    }

    /**
     * Navigate to https://techglobal-training.com/frontend/project-2
     * Enter the username as “TechGlobal”
     * Enter the password as “Test1234”
     * Click on the “LOGIN” button
     * Validate the success message is displayed as “You are logged in”
     * Validate the logout button displayed with the text “LOGOUT”
     */
    @Test
    public void validateValidLogin(){
        WebElement usernameInputBox = driver.findElement(By.id("username"));
        WebElement passwordInputBox = driver.findElement(By.id("password"));
        usernameInputBox.sendKeys("TechGlobal");
        passwordInputBox.sendKeys("Test1234");
        WebElement loginButton = driver.findElement(By.id("login_btn"));
        loginButton.click();
        WebElement successLoginMessage= driver.findElement(By.id("success_lgn"));
        Assert.assertTrue(successLoginMessage.isDisplayed());
        WebElement logoutButton = driver.findElement(By.id("logout"));
        Assert.assertTrue(logoutButton.isDisplayed());

    }

    /**
     * Navigate to https://techglobal-training.com/frontend/project-2
     * Enter the username as “TechGlobal”
     * Enter the password as “Test1234”
     * Click on the “LOGIN” button
     * Click on the “LOGOUT” button
     * Validate that the login form is displayed
     */
    @Test
    public void validateLogout(){
        WebElement usernameInputBox = driver.findElement(By.id("username"));
        WebElement passwordInputBox = driver.findElement(By.id("password"));
        usernameInputBox.sendKeys("TechGlobal");
        Waiter.pause(1);
        passwordInputBox.sendKeys("Test1234");
        Waiter.pause(1);
        WebElement loginButton = driver.findElement(By.id("login_btn"));
        loginButton.click();
        WebElement logoutButton = driver.findElement(By.id("logout"));
        logoutButton.click();
        WebElement loginForm =driver.findElement(By.className("pt-6"));
        Assert.assertTrue(loginForm.isDisplayed());
    }
    /**
     * Navigate to https://techglobal-training.com/frontend/project-2
     * Click on the “Forgot Password?” link
     * Validate that the modal heading “Reset Password” is displayed
     * Validate that the close button is displayed
     * Validate that the email input box is displayed
     * Validate that the label of the email input box is “Enter your email address and we'll send you a link to reset your password.”
     * Validate the “SUBMIT” button is displayed
     * Validate the “SUBMIT” button is clickable
     * Validate that the button text is “SUBMIT”
     */
    @Test
    public void validateForgotPassword(){
        WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot Password?"));
        forgotPasswordLink.click();
        WebElement modalHeading = driver.findElement(By.id("sub_heading"));
        Assert.assertTrue(modalHeading.isDisplayed());
        WebElement closeButton = driver.findElement(By.className("delete"));
        Assert.assertTrue(closeButton.isDisplayed());
        WebElement emailInputBox =driver.findElement(By.id("email"));
        Assert.assertTrue(emailInputBox.isDisplayed());
        WebElement labelOfEmail =driver.findElement(By.cssSelector("label[for='email']"));
        Assert.assertEquals(labelOfEmail.getText(),"Enter your email address and we'll send you a link to reset your password.");
        WebElement submitButton = driver.findElement(By.id("submit"));
        Assert.assertTrue(submitButton.isDisplayed());
        Assert.assertTrue(submitButton.isEnabled());
        Assert.assertEquals(submitButton.getText(),"SUBMIT");
    }
    /**
     * Navigate to https://techglobal-training.com/frontend/project-2
     * Click on the “Forgot Password?” link
     * Validate that the “Reset Password” modal is displayed
     * Click on the close button
     * Validate that the “Reset Password” modal is closed
     */

    @Test
    public void validateReset(){
        WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot Password?"));
        forgotPasswordLink.click();
        WebElement modalHeading = driver.findElement(By.id("sub_heading"));
        Assert.assertTrue(modalHeading.isDisplayed());
        WebElement closeButton = driver.findElement(By.className("delete"));
        closeButton.click();
    }
}
