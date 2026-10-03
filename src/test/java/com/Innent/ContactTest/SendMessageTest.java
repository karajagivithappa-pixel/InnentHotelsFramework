package com.Innent.ContactTest;

import org.testng.annotations.Listeners;

import org.testng.annotations.Test;

import businessUtility.HomePage;
import genericUtility.BaseUtility;

@Listeners(genericUtility.ListenerUtility.class)

public class SendMessageTest extends BaseUtility{
	
	@Test(groups = {"smokeTest"})
	public void sendMessageTest() throws Exception {
		
		HomePage home=new HomePage(driver);
		home.getContactLink().click();
		Thread.sleep(3000);
		
		
		
		
	}
}
