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
	
}
