package businessUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	public DashboardPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//a[contains(@href,'change-password')]")
	private WebElement changePasswordTab;
	
	public WebElement getChangePasswordTabLink() {
		return changePasswordTab;
	}
	
	@FindBy(xpath = "//a[contains(@href,'feedback')]")
	private WebElement feedbackTab;
	
	public WebElement getFeedbackTabLink() {
		return feedbackTab;
	}
}
