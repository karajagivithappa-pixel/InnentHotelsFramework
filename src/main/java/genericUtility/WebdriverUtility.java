package genericUtility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility {
	
	
	
	public WebDriver launchBrowser(String browserName) {
		WebDriver driver;
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
	
	public void sendKeysMethod(WebDriver driver,WebElement element,String data) {
		Actions a=new Actions(driver);
		a.sendKeys(element,data).perform();
	}
	
	public void scrollToElementMethod(WebDriver driver,WebElement element) {
		Actions a=new Actions(driver);
		a.scrollToElement(element).perform();
	}
	
	public void selectDropdown(WebElement selectEle, String optionText) {
		Select s=new Select(selectEle);
		s.selectByVisibleText(optionText);
	}
	
	public void waitUntilClickable(WebDriver driver,WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public void invisibilityOfElement(WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(
		        By.id("innent-loader-overlay")));
	}
	
	public void visibilityOfElement(WebDriver driver,WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ele));
		
	}
	
	public void scrollIntoView(WebDriver driver, WebElement element) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript(
	    	    "arguments[0].scrollIntoView({block: 'center'});",
	    	    element
	    	);
	}
	
	public void javascriptClickElement(WebDriver driver, WebElement element) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript(
	    	    "arguments[0].click();",
	    	    element
	    	);
	}

	
}
