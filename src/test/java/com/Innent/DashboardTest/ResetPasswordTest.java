package com.Innent.DashboardTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import businessUtility.ChangePasswordPage;
import businessUtility.DashboardPage;
import businessUtility.HomePage;
import genericUtility.BaseUtility;
import genericUtility.ListenerUtility;

@Listeners(genericUtility.ListenerUtility.class)

public class ResetPasswordTest extends BaseUtility {

	@Test(groups = { "systemTest" })
	public void resetPasswordTest() throws Exception {

		ListenerUtility.test.get().log(Status.INFO, "navigate to dashboard module");
		HomePage home = new HomePage(driver);
		wu.moveToElementMethod(driver, home.getSignInIcon());
		wu.clickOnElementMethod(driver, home.getDashboardLink());
		Thread.sleep(1000);

		DashboardPage dashboard = new DashboardPage(driver);
		dashboard.getChangePasswordTabLink().click();

		ChangePasswordPage password = new ChangePasswordPage(driver);
		password.getCurrentPasswordInput().sendKeys("shivansh@123");

		password.getNewPasswordInput().sendKeys("shivansh@123");

		password.getRepeatPasswordInput().sendKeys("shivansh@123");

		password.getSaveChangesBtn().click();
		Thread.sleep(3000);

		String actual = password.getSuccessMessageText().getText();
		System.out.println(actual);
		boolean status = actual.contains("updated successfully");
		Assert.assertTrue(status);

	}

}
