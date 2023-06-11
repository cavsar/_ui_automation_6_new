package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Project2Page;
import pages.Project3Page;
import utils.DropdownHandler;

import java.util.List;

public class _03_ProjectTest extends Base {
    @BeforeMethod
    public void setPage() {
        driver.get("https://techglobal-training.netlify.app/frontend/project-3");
        project3Page = new Project3Page();
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

    @Test(priority = 1, description = "TC01=Validate the default Book your trip form")
    public void validateBookYourTrip() {

        Assert.assertTrue(project3Page.oneWayRadioButton.isDisplayed());
        Assert.assertTrue(project3Page.oneWayRadioButton.isSelected());

        Assert.assertTrue(project3Page.roundTripRadioButton.isDisplayed());
        Assert.assertFalse(project3Page.roundTripRadioButton.isSelected());

        Assert.assertTrue(project3Page.cabinClassLAbel.isDisplayed());
        Assert.assertTrue(project3Page.cabinClassDropdown.isDisplayed());

        Assert.assertTrue(project3Page.fromLAbel.isDisplayed());
        Assert.assertTrue(project3Page.fromDropdown.isDisplayed());

        Assert.assertTrue(project3Page.toLAbel.isDisplayed());
        Assert.assertTrue(project3Page.toDropdown.isDisplayed());

        Assert.assertTrue(project3Page.departLabel.isDisplayed());
        Assert.assertTrue(project3Page.datePickerDepart.isDisplayed());

        Assert.assertTrue(project3Page.returnLabel.isDisplayed());
        Assert.assertTrue(project3Page.datePickerReturn.isDisplayed());

        Assert.assertTrue(project3Page.numPassengerLabel.isDisplayed());
        Assert.assertTrue(project3Page.numPassengerBox.isDisplayed());
        Assert.assertEquals(project3Page.numPassengerLabel.getText(), "Number of passengers");
        Assert.assertEquals(project3Page.passengerNumbers.getAttribute("value"), "1");


        Assert.assertTrue(project3Page.Passenger1Label.isDisplayed());
        Assert.assertEquals(project3Page.Passenger1Label.getText(), "Passenger 1");
        Assert.assertTrue(project3Page.Passenger1Box.isDisplayed());
        Assert.assertEquals(project3Page.PassengerType.getAttribute("value"), "Adult (16-64)");

        Assert.assertTrue(project3Page.bookButton.isDisplayed());
        Assert.assertTrue(project3Page.bookButton.isEnabled());


    }
    @Test(priority = 2, description ="TC02=Validate the Book your trip form when Round trip is selected")
    public void validateTestCase2(){
        /**
         * Navigate to https://techglobal-training.com/frontend/project-3
         * Click on the “Round trip” radio button and validate it is selected
         * Validate that the “One way” radio button is not selected
         * Validate that the “Cabin Class” label and dropdown are displayed
         * Validate that the “From” label and dropdown are displayed
         * Validate that the “To” label and dropdown are displayed
         * Validate that the “Depart” label and date picker is displayed
         * Validate that the “Return” label and date picker is displayed
         * Validate that the “Number of passengers” label and dropdown are displayed and 1 is the default
         * Validate that the “Passenger 1” label and dropdown are displayed and “Adult (16-64)” is the default
         * Validate that the “BOOK” button is displayed and enabled
         */


        project3Page.roundTripRadioButton.click();
        Assert.assertTrue(project3Page.roundTripRadioButton.isSelected());
        Assert.assertFalse(project3Page.oneWayRadioButton.isSelected());
        Assert.assertTrue(project3Page.cabinClassLAbel.isDisplayed());
        Assert.assertTrue(project3Page.cabinClassDropdown.isDisplayed());
        Assert.assertTrue(project3Page.departLabel.isDisplayed());
        Assert.assertTrue(project3Page.datePickerDepart.isDisplayed());

        Assert.assertTrue(project3Page.returnLabel.isDisplayed());
        Assert.assertTrue(project3Page.datePickerReturn.isDisplayed());

        Assert.assertTrue(project3Page.numPassengerLabel.isDisplayed());
        Assert.assertTrue(project3Page.numPassengerBox.isDisplayed());
        Assert.assertEquals(project3Page.numPassengerLabel.getText(), "Number of passengers");
        Assert.assertEquals(project3Page.passengerNumbers.getAttribute("value"), "1");


        Assert.assertTrue(project3Page.Passenger1Label.isDisplayed());
        Assert.assertEquals(project3Page.Passenger1Label.getText(), "Passenger 1");
        Assert.assertTrue(project3Page.Passenger1Box.isDisplayed());
        Assert.assertEquals(project3Page.PassengerType.getAttribute("value"), "Adult (16-64)");

        Assert.assertTrue(project3Page.bookButton.isDisplayed());
        Assert.assertTrue(project3Page.bookButton.isEnabled());

    }

    /**
     * Navigate to https://techglobal-training.com/frontend/project-3
     * Select the “One way” radio button
     * Select “Business” for the “Cabin Class” dropdown
     * Select “Illinois” for the “From” dropdown
     * Select “Florida” for the “To” dropdown
     * Select the next week for the ”Depart”
     * Select “1” for the “Number of passengers” dropdown
     * Select “Senior (65+)” for the Passenger 1 dropdown
     * Click on the “BOOK” button
     * Validate the booking information displayed below
     * DEPART
     * IL to FL
     * {dynamic date}
     * Number of passengers: 1
     * Passenger 1: Senior (65+)
     * Cabin Class: Business
     */
    @Test(priority = 3, description = "Test Case 03 - Validate the booking for 1 passenger and one way")
    public void validateTest3(){
        project3Page.oneWayRadioButton.click();
        List<WebElement> cabinClassOptions = driver.findElements(By.cssSelector(".field>div:nth-child(2) >select>option"));
        DropdownHandler.clickDropdownOption(project3Page.cabinClassDropdown,cabinClassOptions,"Business");
        DropdownHandler.clickDropdownOption(project3Page.toDropdown, cabinClassOptions,"Illinois");
        DropdownHandler.clickDropdownOption(project3Page.toDropdown, cabinClassOptions,"Florida");




    }
}
