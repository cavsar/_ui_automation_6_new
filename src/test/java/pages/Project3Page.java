package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class Project3Page {
    public Project3Page() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "input[value='One way']")
    public WebElement oneWayRadioButton;

    @FindBy(css = "input[value='Round trip']")
    public WebElement roundTripRadioButton;


    @FindBy(xpath = "(//div[@class='field']/label)[1]")
    public WebElement cabinClassLAbel;

    @FindBy(xpath = "(//div[@style='width: 100%;']/select)[1]")
    public WebElement cabinClassDropdown;

    @FindBy(xpath = "(//div[@class='field']/label)[2]")
    public WebElement fromLAbel;

    @FindBy(xpath = "(//div[@style='width: 100%;']/select)[2]")
    public WebElement fromDropdown;

    @FindBy(xpath = "(//div[@class='field']/label)[3]")
    public WebElement toLAbel;

    @FindBy(xpath = "(//div[@style='width: 100%;']/select)[3]")
    public WebElement toDropdown;

    @FindBy(xpath = "(//div[@class='field']/label)[4]")
    public WebElement departLabel;

    @FindBy(css = ".react-date-picker")
    public WebElement datePickerDepart;

    @FindBy(css="div[class^='Projects_']>div:nth-child(5) input[placeholder='dd']")
    public WebElement dateOfDeparture;

    @FindBy(xpath = "(//div[@class='field']/label)[5]")
    public WebElement returnLabel;

    @FindBy(css = ".react-date-picker__inputGroup")
    public WebElement datePickerReturn;

    @FindBy(css="div[class= 'field']:nth-child(6) input[name='month']")
    public WebElement dateOfReturn;

    @FindBy(xpath = "(//div[@class='field']/label)[6]")
    public WebElement numPassengerLabel;

    @FindBy(css = "form>div>div:nth-child(7)>div")
    public WebElement numPassengerBox;

    @FindBy(css = "form>div>div:nth-child(7)>div>select")
    public WebElement passengerNumbers;

    @FindBy(xpath = "(//div[@class='field']/label)[7]")
    public WebElement Passenger1Label;

    @FindBy(css = "form>div>div:nth-child(8)>div")
    public WebElement Passenger1Box;

    @FindBy(css = "form>div>div:nth-child(8)>div>select")
    public WebElement PassengerType;

    @FindBy(css = "form>div>div:nth-child(8)>div>select")
    public WebElement PassengerType2;

    @FindBy(css = "button[class^='Button']")
    public WebElement bookButton;

    @FindBy(css = ".ml-3 p")
    public List<WebElement> bookInfo;

    @FindBy (css ="div[class^='Projects_']>div:nth-child(2)>div>select>option")
    public List<WebElement> OptionsCabinClass;

    @FindBy(css = "div[class^='Projects_']>div:nth-child(3)>div>select>option")
    public List<WebElement> OptionsFrom;

    @FindBy (css = "div[class^='Projects_']>div:nth-child(4)>div>select>option")
    public List<WebElement> OptionsTo;

    @FindBy (css = "form>div>div:nth-child(8)>div>select>option")
    public  List<WebElement>OptionPassengerType;

    @FindBy (css = "form>div>div:nth-child(9)>div>select>option")
    public  List<WebElement>OptionPassengerType2;
}
