package businessUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FeedbackPage {
	
	public FeedbackPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//span[@data-val='5']")
	private WebElement starRating;
	
	public WebElement getStarRatingBtn() {
		return starRating;
	}
	
	@FindBy(id = "feedbackCategory")
	private WebElement categoryDropdown;
	
	public WebElement getFeedbackDropdownEle() {
		return categoryDropdown;
	}
	
	@FindBy(xpath = "//option[@value='Booking Experience']")
	private WebElement dropdownOption;
	
	public WebElement getDropdownOptionEle() {
		return dropdownOption;
	}
	
	@FindBy(id = "feedbackMessage")
	private WebElement feedbackMessage;
	
	public WebElement getFeedbackMessageInput() {
		return feedbackMessage;
	}
	
	@FindBy(id = "submitFeedbackBtn")
	private WebElement submitFeedback;
	
	public WebElement getFeedbackSubmitBtn() {
		return submitFeedback;
	}
	
	@FindBy(xpath = "//div[@id='swal2-html-container']")
	private WebElement feedbackReceived;
	
	public WebElement getFeedbackReceivedText() {
		return feedbackReceived;
	}
	
}
