package com.Innent.ContactTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;

import org.testng.annotations.Test;

import businessUtility.ContactPage;
import businessUtility.HomePage;
import genericUtility.BaseUtility;

@Listeners(genericUtility.ListenerUtility.class)

public class SendMessageTest extends BaseUtility {

	@Test(groups = { "smokeTest" })
	public void sendMessageTest() throws Exception {

		HomePage home = new HomePage(driver);
		home.getContactLink().click();
		Thread.sleep(3000);

		ContactPage contact = new ContactPage(driver);

		contact.getNameInput().sendKeys("shivansh");

		contact.getEmailInput().sendKeys("shivanshinfotech123@gmail.com");

		contact.getPhoneInput().sendKeys("6363986874");

		contact.getMessageInput().sendKeys("there is an issue with smart stay service");

		contact.getSendMessageBtn().click();
		Thread.sleep(2000);

		String actual = contact.getEnquirySubmittedText().getText();
		Thread.sleep(2000);
		boolean status = actual.contains("submitted");
		Assert.assertTrue(status);

	}
}
