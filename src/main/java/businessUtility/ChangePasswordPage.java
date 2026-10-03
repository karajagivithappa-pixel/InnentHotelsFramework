package businessUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePasswordPage {
	public ChangePasswordPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//input[@name='current_password']")
	private WebElement currentPassword;
	
	public WebElement getCurrentPasswordInput() {
		return currentPassword;
	}
	
	@FindBy(xpath = "//input[@name='new_password']")
	private WebElement newPassword;
	
	public WebElement getNewPasswordInput() {
		return newPassword;
	}
	
	@FindBy(xpath = "//input[@name='repeat_password']")
	private WebElement repeatPassword;
	
	public WebElement getRepeatPasswordInput() {
		return repeatPassword;
	}
	
	@FindBy(xpath = "//button[.='Save Changes ']")
	private WebElement saveChanges;
	
	public WebElement getSaveChangesBtn() {
		return saveChanges;
	}
	
	@FindBy(xpath = "//div[contains(@class,'alert alert')]")
	private WebElement successMessage;
	
	public WebElement getSuccessMessageText() {
		return successMessage;
	}
	
}
