package businessUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelsPage {
	
	public HotelsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//a[.='View Hotel']")
	private WebElement viewHotelBtn;
	
	public WebElement getViewHotelBtn() {
		return viewHotelBtn;
	}
	
	@FindBy(xpath  = "//span[@id='locationClearBtnListing']")
	private WebElement clearCityBtn;
	
	public WebElement getClearCityBtn() {
		return clearCityBtn;
	}
	
	@FindBy(css = ".search-but")
	private WebElement hotelSearch;
	
	public WebElement getHotelSearchBtn() {
		return hotelSearch;
	}
	
	@FindBy(xpath = "//div/p[@class='hb-card-location']")
	private WebElement hotelAddress;
	
	public WebElement getHotelAddress() {
		return hotelAddress;
	} 
	
	@FindBy(xpath = "//div[@class='traveller-trigger']")
	private WebElement traveller;
	
	public WebElement getChooseTraveller() {
		return traveller;
	}
	
	@FindBy(xpath = "//div[@class='counter-controls']/button[text()='−']")
	private WebElement removeOneAdult;
	
	public WebElement getDecrementAdultTravellerBtn() {
		return removeOneAdult;
	}
	
	@FindBy(css = ".done-btn")
	private WebElement doneBtn;
	
	public WebElement getTravellerDoneBtn() {
		return doneBtn;
	}
	
	@FindBy(xpath = "//span[@class='innent-price']")
	private WebElement hotelPrice;
	
	public WebElement getHotelPriceCurrencyText() {
		return hotelPrice;
	}
}
