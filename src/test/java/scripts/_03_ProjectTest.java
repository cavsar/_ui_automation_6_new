package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class _03_ProjectTest extends Base {
    @BeforeMethod
    public void setPage() {
        driver.get("https://techglobal-training.netlify.app/frontend/project-3");
    }
    /**
     * Navigate to https://techglobal-training.com/frontend/project-3
     * Validate that the “One way” radio button is displayed enabled and selected by default
     * Validate that the “Round trip” radio button is displayed enabled and not selected by default
     * Validate that the “Cabin Class” label and dropdown are displayed
     * Validate that the “From” label and dropdown are displayed
     * Validate that the “To” label and dropdown are displayed
     * Validate that the “Depart” label and date picker is displayed
     * Validate that the “Return” label and date picker is displayed and disabled
     * Validate that the “Number of passengers” label and dropdown are displayed and 1 is the default
     * Validate that the “Passenger 1” category label and dropdown are displayed and “Adult (16-64)” is the default
     * Validate that the “BOOK” button is displayed and enabled
     */

@Test(priority = 1)
public void validateBookYourTrip(){
    WebElement oneWayRadioButton = driver.findElement(By.cssSelector("input[value='One way']"));
    Assert.assertTrue(oneWayRadioButton.isDisplayed());
    Assert.assertTrue(oneWayRadioButton.isSelected());
    WebElement roundTripRadioButton = driver.findElement(By.cssSelector("input[value='Round trip']"));
    Assert.assertTrue(roundTripRadioButton.isDisplayed());
    Assert.assertFalse(roundTripRadioButton.isSelected());
    WebElement cabinClassLAbel =driver.findElement(By.cssSelector(".field>div:nth-child(2)"));
    Assert.assertTrue(cabinClassLAbel.isDisplayed());
    WebElement cabinClassDropdown= driver.findElement(By.cssSelector(".field>div:nth-child(2)>select:nth-child(1)"));
    Assert.assertTrue(cabinClassDropdown.isDisplayed());
    WebElement fromLAbel =driver.findElement(By.cssSelector("form>div>div:nth-child(3)>label"));
    Assert.assertTrue(fromLAbel.isDisplayed());
    WebElement fromDropdown= driver.findElement(By.cssSelector("form>div>div:nth-child(3)>div"));
    Assert.assertTrue(fromDropdown.isDisplayed());
    WebElement toLAbel =driver.findElement(By.cssSelector("form>div>div:nth-child(4)>label"));
    Assert.assertTrue(toLAbel.isDisplayed());
    WebElement toDropdown= driver.findElement(By.cssSelector("form>div>div:nth-child(4)>div"));
    Assert.assertTrue(toDropdown.isDisplayed());
    WebElement departLabel = driver.findElement(By.cssSelector("form>div>div:nth-child(5)>label"));
    Assert.assertTrue(departLabel.isDisplayed());
    WebElement datePickerDepart =driver.findElement(By.cssSelector(".react-date-picker"));
    Assert.assertTrue(datePickerDepart.isDisplayed());
    WebElement returnLabel = driver.findElement(By.cssSelector("form>div>div:nth-child(6)>label"));
    Assert.assertTrue(returnLabel.isDisplayed());
    WebElement datePickerReturn =driver.findElement(By.cssSelector(".react-date-picker__inputGroup"));
    Assert.assertTrue(datePickerReturn.isDisplayed());
    WebElement numPassengerLabel = driver.findElement(By.cssSelector("form>div>div:nth-child(7)>label"));
    Assert.assertTrue(numPassengerLabel.isDisplayed());
    WebElement numPassengerBox =driver.findElement(By.cssSelector("form>div>div:nth-child(7)>div"));
    Assert.assertTrue(numPassengerBox.isDisplayed());
    List<WebElement> option1 =driver.findElements(By.cssSelector("form>div>div:nth-child(7)>div>select>option"));
    int [] numbers ={1,2,3,4,5,6,7,8,9};
    for (int i = 0; i < numbers.length; i++) {
    }

}}
