package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.Project3Page;
import utils.DropdownHandler;
import utils.Waiter;


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

    @Test(priority = 2, description = "TC02=Validate the Book your trip form when Round trip is selected")
    public void validateTestCase2() {
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
    public void validateTest3() {
        project3Page.oneWayRadioButton.click();
        List<WebElement> OptionsCabinClass = driver.findElements(By.cssSelector("div[class^='Projects_']>div:nth-child(2)>div>select>option"));
        DropdownHandler.clickDropdownOption(project3Page.cabinClassDropdown, OptionsCabinClass, "Business");
        List<WebElement> OptionsFrom = driver.findElements(By.cssSelector("div[class^='Projects_']>div:nth-child(3)>div>select>option"));
        DropdownHandler.clickDropdownOption(project3Page.fromDropdown, OptionsFrom, "Illinois");
        List<WebElement> OptionsTo = driver.findElements(By.cssSelector("div[class^='Projects_']>div:nth-child(4)>div>select>option"));
        DropdownHandler.clickDropdownOption(project3Page.toDropdown, OptionsTo, "Florida");
        List<WebElement>OptionPassengerType= driver.findElements(By.cssSelector("form>div>div:nth-child(8)>div>select>option"));
        DropdownHandler.clickDropdownOption(project3Page.PassengerType,OptionPassengerType,"Senior (65+)");
        project3Page.dateOfDeparture.sendKeys("18");

        project3Page.bookButton.click();
        String [] expectedResults = {"Sun Jun 18 2023","Number of Passengers: 1","Passenger 1: Senior (65+)","Cabin class: Business"};
        for (int i = 0; i < project3Page.bookInfo.size(); i++) {
            Assert.assertEquals(project3Page.bookInfo.get(i).getText(),expectedResults[i]);
            System.out.println(project3Page.bookInfo);
        }}



    /**
     * Navigate to https://techglobal-training.com/frontend/project-3
     * Select the “Round trip” radio button
     * Select “First” for the “Cabin Class” dropdown
     * Select “California” for the “From” dropdown
     * Select “Illinois” for the “To” dropdown
     * Select the next week for the ”Depart”
     * Select the next month for the “Return”
     * Select “1” for the “Number of passengers” dropdown
     * Select “Adult (16-64)” for the Passenger 1 dropdown
     * Click on the “BOOK” button
     * Validate the booking information displayed below
     * DEPART
     * CA to IL
     * {dynamic date}
     * Number of passengers: 1
     * Passenger 1: Adult (16-64)
     * Cabin Class: First
     * <p>
     * <p>
     * RETURN
     * IL to CA
     * {dynamic date}
     */
    @Test(priority = 4, description = "Test Case 04 - Validate the booking for 1 passenger and round trip")
    public void validateTest4() {
        project3Page.roundTripRadioButton.click();
        List<WebElement> OptionsCabinClass = driver.findElements(By.cssSelector("div[class^='Projects_']>div:nth-child(2)>div>select>option"));
        DropdownHandler.clickDropdownOption(project3Page.cabinClassDropdown, OptionsCabinClass, "First");
        List<WebElement> OptionsFrom = driver.findElements(By.cssSelector("div[class^='Projects_']>div:nth-child(3)>div>select>option"));
        DropdownHandler.clickDropdownOption(project3Page.fromDropdown, OptionsFrom, "California");
        List<WebElement> OptionsTo = driver.findElements(By.cssSelector("div[class^='Projects_']>div:nth-child(4)>div>select>option"));
        DropdownHandler.clickDropdownOption(project3Page.toDropdown, OptionsTo, "Illinois");
        project3Page.dateOfDeparture.sendKeys("18");
        project3Page.dateOfReturn.sendKeys("7");
        project3Page.bookButton.click();
        Waiter.pause(3);
        String [] expectedResults = {"Sun Jun 18 2023", "Tue Jul 18 2023","Number of Passengers: 1","Passenger 1: Adult (16-64)","Cabin class: First"};
        for (int i = 0; i < project3Page.bookInfo.size(); i++) {
            Assert.assertEquals(project3Page.bookInfo.get(i).getText(),expectedResults[i]);
            System.out.println(project3Page.bookInfo);
    }}
    /**
     * Navigate to https://techglobal-training.com/frontend/project-3
     * Select the “One way” radio button
     * Select “Premium Economy” for the “Cabin Class” dropdown
     * Select “New York” for the “From” dropdown
     * Select “Texas” for the “To” dropdown
     * Select the next day for the ”Depart”
     * Select “2” for the “Number of passengers” dropdown
     * Select “Adult (16-64)” for the Passenger 1 dropdown
     * Select “Child (2-11)” for the Passenger 2 dropdown
     * Click on the “BOOK” button
     * Validate the booking information displayed below
     * DEPART
     * NY to TX
     * {dynamic date}
     * Number of passengers: 2
     * Passenger 1: Adult (16-64)
     * Passenger 2: Child (2-11)
     * Cabin Class: Premium Economy
     */

    @Test(priority = 5, description = "Test Case 05 - Validate the booking for 2 passengers and one way")
    public void validateTest5(){
        project3Page.oneWayRadioButton.click();
        List<WebElement> OptionsCabinClass = driver.findElements(By.cssSelector("div[class^='Projects_']>div:nth-child(2)>div>select>option"));
        DropdownHandler.clickDropdownOption(project3Page.cabinClassDropdown, OptionsCabinClass, "Premium Economy");
        List<WebElement> OptionsFrom = driver.findElements(By.cssSelector("div[class^='Projects_']>div:nth-child(3)>div>select>option"));
        DropdownHandler.clickDropdownOption(project3Page.fromDropdown, OptionsFrom, "New York");
        List<WebElement> OptionsTo = driver.findElements(By.cssSelector("div[class^='Projects_']>div:nth-child(4)>div>select>option"));
        DropdownHandler.clickDropdownOption(project3Page.toDropdown, OptionsTo, "Texas");
        project3Page.dateOfDeparture.sendKeys("12");
        project3Page.passengerNumbers.sendKeys("2");
        List<WebElement>OptionPassengerType= driver.findElements(By.cssSelector("form>div>div:nth-child(8)>div>select>option"));
        DropdownHandler.clickDropdownOption(project3Page.PassengerType,OptionPassengerType,"Adult (16-64)");
        List<WebElement>OptionPassengerType2= driver.findElements(By.cssSelector("form>div>div:nth-child(9)>div>select>option"));
        DropdownHandler.clickDropdownOption(project3Page.PassengerType,OptionPassengerType2,"Child (2-11)");
        project3Page.bookButton.click();
        Waiter.pause(3);
        String [] expectedResults = {"Mon Jun 12 2023","Number of Passengers: 2","Passenger 1: Adult (16-64)","Passenger 2: Child (2-11)","Cabin class: Premium Economy"};
        for (int i = 0; i < project3Page.bookInfo.size(); i++) {
            Assert.assertEquals(project3Page.bookInfo.get(i).getText(),expectedResults[i]);
        System.out.println(project3Page.bookInfo);
    }
}}