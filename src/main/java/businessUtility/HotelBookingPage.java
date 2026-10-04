package businessUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelBookingPage {
	public HotelBookingPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//input[@id='phone_code']")
	private WebElement countryCode;
	
	public WebElement getCountryCodeInput() {
		return countryCode;
	}
	
	@FindBy(xpath = "//h3[.='Guest Details']")
	private WebElement guestDetailsHeading;
	
	public WebElement getGuestDetailsHeadingText() {
		return guestDetailsHeading;
	}
	
	@FindBy(id = "checkLabel")
	private WebElement checkBox;
	
	public WebElement getCheckboxBtn() {
		return checkBox;
	}
	
	@FindBy(id = "personalInfoBtn")
	private WebElement proceedBilling;
	
	public WebElement getProceedBillingBtn() {
		return proceedBilling;
	}
	
	@FindBy(xpath = "//input[@id='country']")
	private WebElement country;
	
	public WebElement getCountryText() {
		return country;
	}
	
	@FindBy(xpath = "//input[@id='state']")
	private WebElement state;
	
	public WebElement getStateText() {
		return state;
	}
	
	@FindBy(xpath = "//input[@id='city']")
	private WebElement city;
	
	public WebElement getCityText() {
		return city;
	}
	
	@FindBy(xpath = "//input[@id='postal_code']")
	private WebElement postalCode;
	
	public WebElement getPostalCodeText() {
		return postalCode;
	}
	
	@FindBy(xpath = "//input[@id='street']")
	private WebElement street;
	
	public WebElement getStreetText() {
		return street;
	}
	
	@FindBy(xpath = "//button[@id='billingAddressBtn']")
	private WebElement proceedPayment;
	
	public WebElement getProceedPaymentBtn() {
		return proceedPayment;
	}
	
	@FindBy(xpath = "//label[@for='payNow']")
	private WebElement payNow;
	
	public WebElement getPayNowText() {
		return payNow;
	}
	
	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailAddress;
	
	public WebElement getEmailAddressValue() {
		return emailAddress;
	}
}
