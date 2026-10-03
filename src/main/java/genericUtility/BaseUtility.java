package genericUtility;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import businessUtility.HomePage;

public class BaseUtility {
	
	public PropertyUtility pu=new PropertyUtility();
	public WebdriverUtility wu=new WebdriverUtility();
	public WebDriver driver;
	public static ThreadLocal<WebDriver> localDriver=new ThreadLocal<WebDriver>();
	
	@BeforeClass(groups = {"integrationTest","smokeTest"})
	public void configBC() throws Exception {
		String browserName=pu.getPropertyData("browser");
		driver=wu.launchBrowser(browserName);
		localDriver.set(driver);
		wu.maximizeBrowser(driver);
		wu.implicitWait(driver);
		
		driver.get(pu.getPropertyData("url"));
	}
	
	@BeforeMethod(groups = {"integrationTest","smokeTest"})
	public void configBM() {
		HomePage hp=new HomePage(driver);
		hp.userSignIn(driver);
	}
	
	@AfterMethod(groups = {"integrationTest","smokeTest"})
	public void configAM() {
		HomePage hp=new HomePage(driver);
		hp.userSignOut(driver);
	}
	
	@AfterClass(groups = {"integrationTest","smokeTest"})
	public void configAC() {
		driver.quit();
	}
	
	
	
	
	
	
	
}
