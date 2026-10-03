package com.Innent.CurrencyTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import businessUtility.HomePage;
import genericUtility.BaseUtility;
import genericUtility.ListenerUtility;
@Listeners(genericUtility.ListenerUtility.class)
public class CurrencyTest extends BaseUtility {
	
	@Test(groups = {"smokeTest"})
	public void currencyTest() throws Exception {

		ListenerUtility.test.get().log(Status.INFO,"click on currency button");
		HomePage home=new HomePage(driver);
		home.getCurrencyBtn().click();
		
		ListenerUtility.test.get().log(Status.INFO,"click on us dollar currency");
		home.getUSdollarLink().click();

		String actual=home.getCurrencyVisibleText().getText();
		Assert.assertEquals(actual,"USD");
		
	}
	
	
	
}
