package businessUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelDetailPage {
	
	public HotelDetailPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//div[@class='api-info-row']/a[@target='_blank']")
	private WebElement hotelHyperLink;
	
	public WebElement getHotelHyperLink() {
		return hotelHyperLink;
	}
	
	@FindBy(xpath = "//div[@class='api-title-main']/h1")
	private WebElement hotelName;
	
	public WebElement getHotelName() {
		return hotelName;
	}
	
	@FindBy(css = ".hb-reserve-btn")
	private WebElement reserve;
	
	public WebElement getReserveNowBtn() {
		return reserve;
	}
	
	@FindBy(xpath = "//input[@name='rg_total']")
	private WebElement overallRating;
	
	public WebElement getOverallRatingInput() {
		return overallRating;
	}
	
	@FindBy(xpath = "//textarea[@name='review']")
	private WebElement ourReview;
	
	public WebElement getOurReviewInput() {
		return ourReview;
	}
	
	@FindBy(xpath = "//button[.='Submit Review']")
	private WebElement submitReview;
	
	public WebElement getSubmitReviewBtn() {
		return submitReview;
	}
	
	
	
}
