package businessUtility;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//div[@class='show-lang']")
	private WebElement signInIcon;
	
	public WebElement getSignInIcon() {
		return signInIcon;
	}
	
	@FindBy(xpath = "//a[.='Dashboard']")
	private WebElement dashboard;
	
	public WebElement getDashboardLink() {
		return dashboard;
	}
	
	@FindBy(xpath = "//a[.='Sign In']")
	private WebElement signInLink;
	
	@FindBy(css = "input[name='email']")
	private WebElement email;
	
	@FindBy(xpath = "//a[.='Logout']")
	private WebElement logoutLink;
	
	@FindBy(xpath = "//button[@onclick='innentToggleDropdown(this)']")
	private WebElement currencyBtn;
	
	public WebElement getCurrencyBtn() {
		return currencyBtn;
	}
	
	@FindBy(xpath = "//button[@data-cur='USD']")
	private WebElement usDollar;
	
	public WebElement getUSdollarLink() {
		return usDollar;
	}
	
	@FindBy(xpath = "//button[@data-cur='CAD']")
	private WebElement canadaDollar;
	
	public WebElement getCanadaDollarLink() {
		return canadaDollar;
	}
	
	@FindBy(xpath = "//li[.='Hotels']")
	private WebElement hotelsLink;
	
	public WebElement getHotelsLink() {
		return hotelsLink;
	}
	
	@FindBy(xpath = "//a[.='Contact']")
	private WebElement contactLink;
	
	public WebElement getContactLink() {
		return contactLink;
	}
	
	@FindBy(xpath = "//span[@class='cur-code']")
	private WebElement currencyText;
	
	public WebElement getCurrencyVisibleText() {
		return currencyText;
	}
	
	@FindBy(xpath = "//button[@onclick='cookieAccept()']")
	private WebElement cookieAccept;
	
	public WebElement getCookieAcceptBtn() {
		return cookieAccept;
	}
	
	public void userSignIn(WebDriver driver,String username,String password) {
		Actions a=new Actions(driver);
		a.moveToElement(signInIcon).perform();
		a.click(signInLink).perform();
		a.sendKeys(email,username,Keys.TAB,password,Keys.ENTER).perform();
	}
	
	public void userSignOut(WebDriver driver) {
		Actions a=new Actions(driver);
		a.moveToElement(signInIcon).perform();
		a.click(logoutLink).perform();
	}
}
