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
public class HotelsTest extends BaseUtility {

	@Test(groups = { "integrationTest" })
	public void autofillGuestDetailTest() {
		ListenerUtility.test.get().log(Status.INFO, "navigate to hotels module");
		HomePage hp = new HomePage(driver);
		hp.getHotelsLink().click();
		wu.invisibilityOfElement(driver);
		
		ListenerUtility.test.get().log(Status.INFO, "navigate to hotel detail page");
		HotelsPage hotels = new HotelsPage(driver);
		wu.waitUntilClickable(driver,hotels.getViewHotelBtn());
		hotels.getViewHotelBtn().click();
		
		ListenerUtility.test.get().log(Status.INFO, "navigate to hotel booking page");
		HotelDetailPage hotelDetail = new HotelDetailPage(driver);
		wu.scrollToElementMethod(driver,hotelDetail.getReserveNowBtn());
		hotelDetail.getReserveNowBtn().click();
		
		HotelBookingPage hotelBook=new HotelBookingPage(driver);
		String actual=hotelBook.getEmailAddressValue().getAttribute("value");
		Assert.assertEquals(actual,"shivanshinfotech123@gmail.com");
	}
	
	
	

	@Test(groups = { "integrationTest" })
	public void defaultCityTest() throws Exception {

		ListenerUtility.test.get().log(Status.INFO, "navigate to hotels module");
		HomePage hp = new HomePage(driver);
		hp.getHotelsLink().click();
		wu.invisibilityOfElement(driver);
		
		ListenerUtility.test.get().log(Status.INFO, "clear city name");
		HotelsPage hotels = new HotelsPage(driver);
		hotels.getClearCityBtn().click();

		ListenerUtility.test.get().log(Status.INFO, "click on search hotel");
		hotels.getHotelSearchBtn().click();
		Thread.sleep(3000);
		
		String hotelAddress = hotels.getHotelAddress().getText();
		boolean status = hotelAddress.contains("Vancouver");
		Assert.assertTrue(status);
	}

	@Test(groups = { "systemTest" })
	public void bookHotelTest() throws Exception {
		ListenerUtility.test.get().log(Status.INFO, "navigate to hotels module");
		HomePage hp = new HomePage(driver);
		hp.getHotelsLink().click();

		ListenerUtility.test.get().log(Status.INFO, "choose traveller");
		HotelsPage hotels = new HotelsPage(driver);
		wu.invisibilityOfElement(driver);
		wu.waitUntilClickable(driver,hotels.getChooseTraveller());
		hotels.getChooseTraveller().click();
		hotels.getDecrementAdultTravellerBtn().click();
		hotels.getTravellerDoneBtn().click();
		
		ListenerUtility.test.get().log(Status.INFO, "click on hotel search button");
		hotels.getHotelSearchBtn().click();
		wu.invisibilityOfElement(driver);
		
		ListenerUtility.test.get().log(Status.INFO, "navigate to hotel detail page");
		wu.waitUntilClickable(driver,hotels.getViewHotelBtn());
		hotels.getViewHotelBtn().click();
		
		ListenerUtility.test.get().log(Status.INFO, "navigate to hotel booking page");
		HotelDetailPage hotelDetail = new HotelDetailPage(driver);
		wu.scrollToElementMethod(driver,hotelDetail.getReserveNowBtn());
		hotelDetail.getReserveNowBtn().click();
		
		ListenerUtility.test.get().log(Status.INFO, "fill the details");
		HotelBookingPage hotelBook = new HotelBookingPage(driver);
		hotelBook.getCountryCodeInput().clear();
		hotelBook.getCountryCodeInput().sendKeys("+91");
		hotelBook.getCheckboxBtn().click();
		
		ListenerUtility.test.get().log(Status.INFO, "navigate to billing address page");
		hotelBook.getProceedBillingBtn().click();
		
		ListenerUtility.test.get().log(Status.INFO, "fill the details");
		hotelBook.getCountryText().sendKeys("india");
		hotelBook.getStateText().sendKeys("karnataka");
		hotelBook.getCityText().sendKeys("bengaluru");
		hotelBook.getPostalCodeText().sendKeys("560016");
		hotelBook.getStreetText().sendKeys("kasturi nagar");
		
		ListenerUtility.test.get().log(Status.INFO, "navigate to payment page");
		hotelBook.getProceedPaymentBtn().click();
		wu.visibilityOfElement(driver,hotelBook.getPayNowText());
		String actual = hotelBook.getPayNowText().getText();
		Assert.assertEquals(actual, "Pay Now");

	}

	@Test(groups = { "smokeTest" })
	public void reserveHotelRoomTest() throws Exception {
		ListenerUtility.test.get().log(Status.INFO, "navigate to hotels module");
		HomePage hp = new HomePage(driver);
		hp.getHotelsLink().click();
		wu.invisibilityOfElement(driver);
		
		ListenerUtility.test.get().log(Status.INFO, "navigate to hotel detail page");
		HotelsPage hotels = new HotelsPage(driver);
		wu.waitUntilClickable(driver,hotels.getViewHotelBtn());
		hotels.getViewHotelBtn().click();

		ListenerUtility.test.get().log(Status.INFO, "click on reserve now button");
		HotelDetailPage hotelDetail = new HotelDetailPage(driver);
		wu.scrollToElementMethod(driver,hotelDetail.getReserveNowBtn());
		hotelDetail.getReserveNowBtn().click();
	
		HotelBookingPage hotelBook = new HotelBookingPage(driver);
		wu.visibilityOfElement(driver,hotelBook.getGuestDetailsHeadingText());
		String actual = hotelBook.getGuestDetailsHeadingText().getText();
		Assert.assertEquals(actual, "Guest Details");
	}

}
