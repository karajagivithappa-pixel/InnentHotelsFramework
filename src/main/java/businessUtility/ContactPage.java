package businessUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	public ContactPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css = "#name")
	private WebElement name;
	
	public WebElement getNameInput() {
		return name;
	}
	
	@FindBy(css = "#email")
	private WebElement email;
	
	public WebElement getEmailInput() {
		return email;
	}
	
	@FindBy(css = "#phone")
	private WebElement phone;
	
	public WebElement getPhoneInput() {
		return phone;
	}
	
	@FindBy(css = "#comments")
	private WebElement comments;
	
	public WebElement getMessageInput() {
		return comments;
	}
	
	@FindBy(xpath = "//button[.='Send Message']")
	private WebElement sendMessageBtn;
	
	public WebElement getSendMessageBtn() {
		return sendMessageBtn;
	}
	
	@FindBy(xpath = "//div[contains(@class,'alert alert')]")
	private WebElement enquirySuccessMessage;
	
	public WebElement getEnquirySubmittedText() {
		return enquirySuccessMessage;
	}
}
