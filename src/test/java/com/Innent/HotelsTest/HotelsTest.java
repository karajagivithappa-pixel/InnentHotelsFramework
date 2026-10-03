package com.Innent.HotelsTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import businessUtility.HomePage;
import businessUtility.HotelBookingPage;
import businessUtility.HotelDetailPage;
import businessUtility.HotelsPage;
import genericUtility.BaseUtility;
import genericUtility.ListenerUtility;


@Listeners(genericUtility.ListenerUtility.class)
public class HotelsTest extends BaseUtility{
	
	@Test(groups = {"integrationTest"})
	public void officialHotelPageTest() throws Exception {
		
		ListenerUtility.test.get().log(Status.INFO,"navigate to hotels module");
		HomePage hp=new HomePage(driver);
		hp.getHotelsLink().click();
		
		ListenerUtility.test.get().log(Status.INFO,"click on view hotel button");
		HotelsPage hotels=new HotelsPage(driver);
		hotels.getViewHotelBtn().click();
		
		String parentId=driver.getWindowHandle();
		Thread.sleep(5000);
		ListenerUtility.test.get().log(Status.INFO,"navigate to official hotel page");
		HotelDetailPage hotelDetail=new HotelDetailPage(driver);
		String officialHotel=hotelDetail.getHotelHyperLink().getText().replace("https://", "").replace("http://", "");
		hotelDetail.getHotelHyperLink().click();
		
		wu.switchToChildWindow(driver,parentId);
		
		String actual=driver.getCurrentUrl().replace("https://", "").replace("http://", "");
		driver.switchTo().window(parentId);
		System.out.println(actual);
		boolean status=actual.contains(officialHotel);
		Assert.assertTrue(status);
		
				
	}
	
	@Test(groups = {"integrationTest"})
	public void defaultCityTest() throws Exception {
		
		ListenerUtility.test.get().log(Status.INFO,"navigate to hotels module");
		HomePage hp=new HomePage(driver);
		hp.getHotelsLink().click();
		Thread.sleep(2000);
		ListenerUtility.test.get().log(Status.INFO,"clear city name");
		HotelsPage hotels=new HotelsPage(driver);
		hotels.getClearCityBtn().click();
		
		ListenerUtility.test.get().log(Status.INFO,"click on search hotel");
		hotels.getHotelSearchBtn().click();
		Thread.sleep(2000);
		String hotelAddress=hotels.getHotelAddress().getText();
		System.out.println(hotelAddress);
		boolean status=hotelAddress.contains("Vancouver");
		Assert.assertTrue(status);
	}
	
	@Test(groups = {"systemTest"})
	public void bookHotelTest() throws Exception {
		ListenerUtility.test.get().log(Status.INFO,"navigate to hotels module");
		HomePage hp=new HomePage(driver);
		hp.getHotelsLink().click();
		
		HotelsPage hotels=new HotelsPage(driver);
		hotels.getChooseTraveller().click();
		
		hotels.getDecrementAdultTravellerBtn().click();
		
		hotels.getTravellerDoneBtn().click();
		
		hotels.getHotelSearchBtn().click();
		Thread.sleep(3000);
		hotels.getViewHotelBtn().click();
		
		HotelDetailPage hotelDetail=new HotelDetailPage(driver);
		hotelDetail.getReserveNowBtn().click();
		
		HotelBookingPage hotelBook=new HotelBookingPage(driver);
		hotelBook.getCountryCodeInput().clear();
		hotelBook.getCountryCodeInput().sendKeys("+91");
		Thread.sleep(3000);
	}
	
	@Test(groups = {"systemTest"})
	public void submitReviewHotelTest() throws Exception {
		ListenerUtility.test.get().log(Status.INFO,"navigate to hotels module");
		HomePage hp=new HomePage(driver);
		hp.getHotelsLink().click();
		Thread.sleep(3000);

		ListenerUtility.test.get().log(Status.INFO,"click on view hotel button");
		HotelsPage hotels=new HotelsPage(driver);
		hotels.getViewHotelBtn().click();
		
		HotelDetailPage hotelDetail=new HotelDetailPage(driver);
		hotelDetail.getOverallRatingInput().sendKeys("10");
		Thread.sleep(3000);
		
		hotelDetail.getOurReviewInput().sendKeys("goodhoteloverall");
		
		hotelDetail.getSubmitReviewBtn().click();
		Thread.sleep(3000);
	}
	
	@Test(groups = {"smokeTest"})
	public void reserveHotelRoomTest() throws Exception {
		ListenerUtility.test.get().log(Status.INFO,"navigate to hotels module");
		HomePage hp=new HomePage(driver);
		hp.getHotelsLink().click();
		Thread.sleep(3000);
		
		HotelsPage hotels=new HotelsPage(driver);
		hotels.getViewHotelBtn().click();
		
		HotelDetailPage hotelDetail=new HotelDetailPage(driver);
		hotelDetail.getReserveNowBtn().click();
		
		HotelBookingPage hotelBook=new HotelBookingPage(driver);
		String actual=hotelBook.getGuestDetailsHeadingText().getText();

		Assert.assertEquals(actual,"Guest Details");
	}
	
}
