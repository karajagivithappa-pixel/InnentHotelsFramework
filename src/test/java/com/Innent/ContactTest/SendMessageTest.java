package com.Innent.ContactTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import businessUtility.ContactPage;
import businessUtility.HomePage;
import genericUtility.BaseUtility;
import genericUtility.ListenerUtility;

@Listeners(genericUtility.ListenerUtility.class)

public class SendMessageTest extends BaseUtility {

	@Test(groups = { "smokeTest" })
	public void sendMessageTest() throws Exception {

		ListenerUtility.test.get().log(Status.INFO, "click on contact module");
		HomePage home = new HomePage(driver);
		//home.getContactLink().click();
		wu.javascriptClickElement(driver,home.getContactLink());

		ContactPage contact = new ContactPage(driver);
		
		ListenerUtility.test.get().log(Status.INFO, "fill all the details");
		contact.getNameInput().sendKeys("shivansh");
		contact.getEmailInput().sendKeys("shivanshinfotech123@gmail.com");
		contact.getPhoneInput().sendKeys("6363986874");
		contact.getMessageInput().sendKeys("there is an issue with smart stay service");
		
		ListenerUtility.test.get().log(Status.INFO, "click on send message btn");
		contact.getSendMessageBtn().click();
		
		wu.visibilityOfElement(driver,contact.getEnquirySubmittedText());
		String actual = contact.getEnquirySubmittedText().getText();
		boolean status = actual.contains("submitted");
		Assert.assertTrue(status);

	}
}
