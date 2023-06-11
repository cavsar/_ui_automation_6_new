package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class Project3Page {
    public Project3Page() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "input[value='One way']")
    public WebElement oneWayRadioButton;

    @FindBy(css = "input[value='Round trip']")
    public WebElement roundTripRadioButton;


    @FindBy(css = ".field>div:nth-child(2)")
    public WebElement cabinClassLAbel;

    @FindBy(css = ".field>div:nth-child(2)>select:nth-child(1)")
    public WebElement cabinClassDropdown;

    @FindBy(css = "form>div>div:nth-child(3)>label")
    public WebElement fromLAbel;

    @FindBy(css = "form>div>div:nth-child(3)>div")
    public WebElement fromDropdown;

    @FindBy(css = "form>div>div:nth-child(4)>label")
    public WebElement toLAbel;

    @FindBy(css = "form>div>div:nth-child(4)>div")
    public WebElement toDropdown;

    @FindBy(css = "form>div>div:nth-child(5)>label")
    public WebElement departLabel;

    @FindBy(css = ".react-date-picker")
    public WebElement datePickerDepart;

    @FindBy(css = "form>div>div:nth-child(6)>label")
    public WebElement returnLabel;

    @FindBy(css = ".react-date-picker__inputGroup")
    public WebElement datePickerReturn;

    @FindBy(css = "form>div>div:nth-child(7)>label")
    public WebElement numPassengerLabel;

    @FindBy(css = "form>div>div:nth-child(7)>div")
    public WebElement numPassengerBox;

    @FindBy(css = "form>div>div:nth-child(7)>div>select")
    public WebElement passengerNumbers;

    @FindBy(css = "form>div>div:nth-child(8)>label")
    public WebElement Passenger1Label;

    @FindBy(css = "form>div>div:nth-child(8)>div")
    public WebElement Passenger1Box;

    @FindBy(css = "form>div>div:nth-child(8)>div>select")
    public WebElement PassengerType;

    @FindBy(css = "button[class^='Button']")
    public WebElement bookButton;


}
