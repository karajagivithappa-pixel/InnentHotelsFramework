package com.Innent.DashboardTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import businessUtility.ChangePasswordPage;
import businessUtility.DashboardPage;
import businessUtility.FeedbackPage;
import businessUtility.HomePage;
import genericUtility.BaseUtility;
import genericUtility.ListenerUtility;

@Listeners(genericUtility.ListenerUtility.class)

public class DashboardTest extends BaseUtility {

	@Test(groups = { "systemTest" },invocationCount = 0)
	public void resetPasswordTest() throws Exception {
		
		ListenerUtility.test.get().log(Status.INFO, "navigate to dashboard module");
		HomePage home = new HomePage(driver);
		wu.moveToElementMethod(driver, home.getSignInIcon());
		wu.clickOnElementMethod(driver, home.getDashboardLink());
		
		ListenerUtility.test.get().log(Status.INFO, "navigate to change password tab");
		DashboardPage dashboard = new DashboardPage(driver);
		dashboard.getChangePasswordTabLink().click();
		
		ListenerUtility.test.get().log(Status.INFO, "fill the details");
		ChangePasswordPage password = new ChangePasswordPage(driver);
		password.getCurrentPasswordInput().sendKeys("shivansh@123");
		password.getNewPasswordInput().sendKeys("shivansh@123");
		password.getRepeatPasswordInput().sendKeys("shivansh@123");

		ListenerUtility.test.get().log(Status.INFO, "click on save button");
		password.getSaveChangesBtn().click();
		
		wu.visibilityOfElement(driver,password.getSuccessMessageText());
		String actual = password.getSuccessMessageText().getText();
		boolean status = actual.contains("updated successfully");
		Assert.assertTrue(status);

	}

	@Test(groups = { "systemTest" })
	public void submitFeedbackTest() throws Exception {
		
		ListenerUtility.test.get().log(Status.INFO, "navigate to dashboard module");
		HomePage home = new HomePage(driver);
		wu.moveToElementMethod(driver, home.getSignInIcon());
		wu.clickOnElementMethod(driver, home.getDashboardLink());
		
		ListenerUtility.test.get().log(Status.INFO, "navigate to feedback tab");
		DashboardPage dashboard = new DashboardPage(driver);
		dashboard.getFeedbackTabLink().click();
		
		ListenerUtility.test.get().log(Status.INFO, "fill the details");
		FeedbackPage feedback = new FeedbackPage(driver);
		feedback.getStarRatingBtn().click();

		wu.selectDropdown(feedback.getFeedbackDropdownEle(),feedback.getDropdownOptionEle().getText());
		feedback.getFeedbackMessageInput().sendKeys("experience with innent is good");
		
		ListenerUtility.test.get().log(Status.INFO, "click on submit button");
		feedback.getFeedbackSubmitBtn().click();
		
		wu.visibilityOfElement(driver,feedback.getFeedbackReceivedText());
		String actual = feedback.getFeedbackReceivedText().getText();
		boolean status=actual.contains("feedback");
		Assert.assertTrue(status);

	}

}
