package Pages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.time.Duration;

public class KiwiPage {
    public KiwiPage(){
        PageFactory.initElements((WebDriver) Driver.getAndroidDriver(), this);
    }



    @FindBy(xpath = "//*[@text='Continue with Facebook']")
    public WebElement girisKontolText;

    @FindBy(xpath = "//*[@text='Continue as a guest']")
    public WebElement continueGuestText;

    @FindBy(xpath = "//*[@text='Continue']")
    public WebElement continueButton;

    @FindBy(xpath = "//*[@text='Explore the app']")
    public WebElement exploreButton;

    @FindBy(xpath = "//*[@text='Return']")
    public WebElement returnButton;


    @FindBy(xpath = "//*[@text='One way']")
    public WebElement oneWayLink;

    @FindBy(xpath = "//*[@text='From:']")
    public WebElement fromButton;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Clear All\"]")
    public WebElement deleteDefaultCountryLink;

    @FindBy(xpath = "//*[@text='SAW, Sabiha Gökçen International']")
    public WebElement kalkisNoktasıLink;

    @FindBy(xpath = "//*[@text='Choose']")
    public WebElement chooseButton;

    @FindBy(xpath = "//*[@text='To:']")
    public WebElement varisButton;

    @FindBy(xpath = "//*[@text='Netherlands, Western Europe']")
    public WebElement varisYeriLink;

    @FindBy(xpath = "//*[@text='Departure:']")
    public WebElement gidisTarihButton;

    @FindBy(xpath = "//*[@text='Set date']")
    public WebElement setDateButton;

    @FindBy(xpath = "(//*[@text='Search'])[1]")
    public WebElement searchButton;

    @FindBy(xpath = "//*[@text='Popular']")
    public WebElement popularButton;

    @FindBy(xpath = "//*[@text='Cheapest']")
    public WebElement cheapestButton;

    @FindBy(xpath = "//*[@text='Stops']")
    public WebElement stopsButton;

    @FindBy(xpath = "//*[@text='Nonstop']")
    public WebElement nonstopLink;

    @FindBy(xpath = "(//*[@class='android.widget.TextView'])[2]")
    public WebElement priceTextLink;



































    }




