package genericUtility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

public class WebdriverUtility {
	
	WebDriver driver;
	
	public WebDriver launchBrowser(String browserName) {
		if(browserName.equalsIgnoreCase("chrome"))
			driver=new ChromeDriver();
		else if(browserName.equalsIgnoreCase("edge"))
			driver=new EdgeDriver();
		else if(browserName.equalsIgnoreCase("firefox"))
			driver=new FirefoxDriver();
		else if(browserName.equalsIgnoreCase("safari"))
			driver=new SafariDriver();
		else
			driver=new ChromeDriver();
		return driver;
	}
	
	public void maximizeBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	public void switchToChildWindow(WebDriver driver,String parentId) {
		Set<String> windowIDs=driver.getWindowHandles();
		for(String windowId:windowIDs) {
			driver.switchTo().window(windowId);
			if(!windowId.equals(parentId))
				break;
		}
	}
	
	public void moveToElementMethod(WebDriver driver,WebElement element) {
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
	}
	
	public void clickOnElementMethod(WebDriver driver,WebElement element) {
		Actions a=new Actions(driver);
		a.click(element).perform();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
