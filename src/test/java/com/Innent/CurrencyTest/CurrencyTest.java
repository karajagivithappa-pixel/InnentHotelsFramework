package com.Innent.CurrencyTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import businessUtility.HomePage;
import businessUtility.HotelsPage;
import genericUtility.BaseUtility;
import genericUtility.ListenerUtility;

@Listeners(genericUtility.ListenerUtility.class)
public class CurrencyTest extends BaseUtility {

	@Test(groups = { "smokeTest" })
	public void currencyTest() throws Exception {

		ListenerUtility.test.get().log(Status.INFO, "click on currency button");
		HomePage home = new HomePage(driver);
		home.getCurrencyBtn().click();

		ListenerUtility.test.get().log(Status.INFO, "click on us dollar currency");
		home.getUSdollarLink().click();

		String actual = home.getCurrencyVisibleText().getText();
		Assert.assertEquals(actual, "USD");
	}
	
	@Test(groups = { "integrationTest" })
	public void currencyIntegrationTest() throws Exception {
		
		ListenerUtility.test.get().log(Status.INFO, "navigate to hotels module");
		HomePage hp = new HomePage(driver);
		hp.getHotelsLink().click();
		
		HotelsPage hotels=new HotelsPage(driver);
		String actual1=hotels.getHotelPriceCurrencyText().getText();
		boolean status1=actual1.contains("CAD");
		Assert.assertTrue(status1);
		
		hp.getCurrencyBtn().click();
		
		hp.getUSdollarLink().click();
		
		String actual2=hotels.getHotelPriceCurrencyText().getText();
		boolean status2=actual2.contains("USD");
		Assert.assertTrue(status2);
		
		
		
	}
}
