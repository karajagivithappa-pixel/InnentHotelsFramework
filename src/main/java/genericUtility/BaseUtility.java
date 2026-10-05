package genericUtility;

import org.openqa.selenium.By;
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
	
	/*
	@BeforeClass(groups = {"integrationTest","smokeTest","systemTest"})
	public void configBC() throws Exception {
		String browserName=pu.getPropertyData("browser");
		driver=wu.launchBrowser(browserName);
		localDriver.set(driver);
		wu.maximizeBrowser(driver);
		wu.implicitWait(driver);
		driver.get(pu.getPropertyData("url"));
	}
	*/
	@BeforeMethod(groups = {"integrationTest","smokeTest","systemTest"})
	public void configBM() throws Exception {
		String browserName=pu.getPropertyData("browser");
		String username=pu.getPropertyData("username");
		String password=pu.getPropertyData("password");
		driver=wu.launchBrowser(browserName);
		localDriver.set(driver);
		wu.maximizeBrowser(driver);
		wu.implicitWait(driver);
		driver.get(pu.getPropertyData("url"));
		HomePage home=new HomePage(driver);
		home.userSignIn(driver,username,password);
		home.getCookieAcceptBtn().click();
		//driver.findElement(By.xpath("//button[@onclick='cookieAccept()']")).click();
	}
	
	@AfterMethod(groups = {"integrationTest","smokeTest","systemTest"})
	public void configAM() throws Exception {
		Thread.sleep(2000);
		HomePage hp=new HomePage(driver);
		hp.userSignOut(driver);
		driver.quit();
	}
	/*
	@AfterClass(groups = {"integrationTest","smokeTest","systemTest"})
	public void configAC() {
		driver.quit();	
	}
	*/
	
	
	
	
	
	
}
