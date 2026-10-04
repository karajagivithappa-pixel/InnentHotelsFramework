package com.Innent.HotelsTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import businessUtility.HomePage;
import businessUtility.HotelDetailPage;
import businessUtility.HotelsPage;
import genericUtility.BaseUtility;
import genericUtility.ListenerUtility;

public class SampleTest1 extends BaseUtility {
	@Test(groups = { "systemTest" }, invocationCount = 0)
	public void submitReviewHotelTest() throws Exception {
		ListenerUtility.test.get().log(Status.INFO, "navigate to hotels module");
		HomePage hp = new HomePage(driver);
		hp.getHotelsLink().click();
		Thread.sleep(3000);

		ListenerUtility.test.get().log(Status.INFO, "click on view hotel button");
		HotelsPage hotels = new HotelsPage(driver);
		hotels.getViewHotelBtn().click();

		HotelDetailPage hotelDetail = new HotelDetailPage(driver);
		hotelDetail.getOverallRatingInput().sendKeys("10");
		Thread.sleep(3000);

		hotelDetail.getOurReviewInput().sendKeys("goodhoteloverall");

		hotelDetail.getSubmitReviewBtn().click();
		Thread.sleep(3000);
		
		String actual=hotelDetail.getReviewSubmittedMessageText().getText();
		boolean status=actual.contains("reviewed");
		Assert.assertTrue(status);
	}
	
	@Test(groups = { "integrationTest" },invocationCount = 0)
	public void officialHotelPageTest() throws Exception {
		
		ListenerUtility.test.get().log(Status.INFO, "navigate to hotels module");
		HomePage hp = new HomePage(driver);
		hp.getHotelsLink().click();
		wu.invisibilityOfElement(driver);
		
		ListenerUtility.test.get().log(Status.INFO, "navigate to hotel detail page");
		HotelsPage hotels = new HotelsPage(driver);
		hotels.getViewHotelBtn().click();
		
		String parentId = driver.getWindowHandle();
		ListenerUtility.test.get().log(Status.INFO, "click on official hotel url");
		HotelDetailPage hotelDetail = new HotelDetailPage(driver);
		String officialHotel = hotelDetail.getHotelHyperLink().getText().replace("https://", "").replace("http://", "");
		hotelDetail.getHotelHyperLink().click();
		
		ListenerUtility.test.get().log(Status.INFO, "switch to official hotel tab");
		wu.switchToChildWindow(driver, parentId);
		String actual = driver.getCurrentUrl().replace("https://", "").replace("http://", "");
		
		ListenerUtility.test.get().log(Status.INFO, "switch back to parent tab");
		driver.switchTo().window(parentId);
		boolean status = actual.contains(officialHotel);
		Assert.assertTrue(status);

	}
}
