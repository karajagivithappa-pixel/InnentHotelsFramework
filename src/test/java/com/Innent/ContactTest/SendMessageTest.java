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
		
		String name=eu.readDataExcel("contact",1,0);
		String email=eu.readDataExcel("contact",1,1);
		String phone=eu.readDataExcel("contact",1,2);
		String issue=eu.readDataExcel("contact",1,3);
		String expected=eu.readDataExcel("contact",1,4);
		
		ListenerUtility.test.get().log(Status.INFO, "click on contact module");
		HomePage home = new HomePage(driver);
		home.getContactLink().click();
		ContactPage contact = new ContactPage(driver);
		
		ListenerUtility.test.get().log(Status.INFO, "fill all the details");
		contact.getNameInput().sendKeys(name);
		contact.getEmailInput().sendKeys(email);
		contact.getPhoneInput().sendKeys(phone);
		contact.getMessageInput().sendKeys(issue);
		
		ListenerUtility.test.get().log(Status.INFO, "click on send message btn");
		contact.getSendMessageBtn().click();
		
		wu.visibilityOfElement(driver,contact.getEnquirySubmittedText());
		String actual = contact.getEnquirySubmittedText().getText();
		boolean status = actual.contains(expected);
		Assert.assertTrue(status);

	}
}
