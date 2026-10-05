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

	@Test(groups = { "integrationTest" },invocationCount = 0)
	public void autofillGuestDetailTest() {
		ListenerUtility.test.get().log(Status.INFO, "navigate to hotels module");
		HomePage home = new HomePage(driver);
		//home.getHotelsLink().click();
		wu.javascriptClickElement(driver,home.getHotelsLink());
		
		ListenerUtility.test.get().log(Status.INFO, "navigate to hotel detail page");
		HotelsPage hotels = new HotelsPage(driver);
		//wu.invisibilityOfElement(driver);
		//wu.waitUntilClickable(driver,hotels.getViewHotelBtn());
		//hotels.getViewHotelBtn().click();
		wu.javascriptClickElement(driver,hotels.getViewHotelBtn());
		
		ListenerUtility.test.get().log(Status.INFO, "navigate to hotel booking page");
		HotelDetailPage hotelDetail = new HotelDetailPage(driver);
		//wu.scrollToElementMethod(driver,hotelDetail.getReserveNowBtn());
		//hotelDetail.getReserveNowBtn().click();
		wu.javascriptClickElement(driver,hotelDetail.getReserveNowBtn());
		
		HotelBookingPage hotelBook=new HotelBookingPage(driver);
		wu.visibilityOfElement(driver,hotelBook.getEmailAddressValue());
		String actual=hotelBook.getEmailAddressValue().getAttribute("value");
		Assert.assertEquals(actual,"shivanshinfotech123@gmail.com");
		
	}
	
	@Test(groups = { "integrationTest" })
	public void defaultCityTest() throws Exception {

		ListenerUtility.test.get().log(Status.INFO, "navigate to hotels module");
		HomePage home = new HomePage(driver);
		//home.getHotelsLink().click();
		wu.javascriptClickElement(driver,home.getHotelsLink());
		
		ListenerUtility.test.get().log(Status.INFO, "clear city name");
		HotelsPage hotels = new HotelsPage(driver);
		//wu.invisibilityOfElement(driver);
		//wu.waitUntilClickable(driver,hotels.getClearCityBtn());
		//hotels.getClearCityBtn().click();
		wu.javascriptClickElement(driver,hotels.getClearCityBtn());

		ListenerUtility.test.get().log(Status.INFO, "click on search hotel");
		//wu.waitUntilClickable(driver,hotels.getHotelSearchBtn());
		//hotels.getHotelSearchBtn().click();
		wu.javascriptClickElement(driver,hotels.getHotelSearchBtn());
		Thread.sleep(4000);
		
		String hotelAddress = hotels.getHotelAddress().getText();
		boolean status = hotelAddress.contains("BC");
		Assert.assertTrue(status);
		
	}

	@Test(groups = { "systemTest" })
	public void bookHotelTest() throws Exception {
		ListenerUtility.test.get().log(Status.INFO, "navigate to hotels module");
		HomePage home = new HomePage(driver);
		//home.getHotelsLink().click();
		wu.javascriptClickElement(driver,home.getHotelsLink());
		
		ListenerUtility.test.get().log(Status.INFO, "choose traveller");
		HotelsPage hotels = new HotelsPage(driver);
		//wu.invisibilityOfElement(driver);
		//wu.waitUntilClickable(driver,hotels.getChooseTraveller());
		//hotels.getChooseTraveller().click();
		wu.javascriptClickElement(driver,hotels.getChooseTraveller());
		hotels.getDecrementAdultTravellerBtn().click();
		hotels.getTravellerDoneBtn().click();
		
		ListenerUtility.test.get().log(Status.INFO, "click on hotel search button");
		hotels.getHotelSearchBtn().click();
		wu.javascriptClickElement(driver,hotels.getHotelSearchBtn());
		
		ListenerUtility.test.get().log(Status.INFO, "navigate to hotel detail page");
		//wu.invisibilityOfElement(driver);
		//wu.waitUntilClickable(driver,hotels.getViewHotelBtn());
		//hotels.getViewHotelBtn().click();
		wu.javascriptClickElement(driver,hotels.getViewHotelBtn());
		
		ListenerUtility.test.get().log(Status.INFO, "navigate to hotel booking page");
		HotelDetailPage hotelDetail = new HotelDetailPage(driver);
		//wu.scrollToElementMethod(driver,hotelDetail.getReserveNowBtn());
		//hotelDetail.getReserveNowBtn().click();
		wu.javascriptClickElement(driver,hotelDetail.getReserveNowBtn());
		
		ListenerUtility.test.get().log(Status.INFO, "fill the details");
		HotelBookingPage hotelBook = new HotelBookingPage(driver);
		hotelBook.getCountryCodeInput().clear();
		hotelBook.getCountryCodeInput().sendKeys("+91");
		wu.javascriptClickElement(driver,hotelBook.getCheckboxBtn());
		
		ListenerUtility.test.get().log(Status.INFO, "navigate to billing address page");
		//hotelBook.getProceedBillingBtn().click();
		wu.javascriptClickElement(driver,hotelBook.getProceedBillingBtn());
		
		ListenerUtility.test.get().log(Status.INFO, "fill the details");
		hotelBook.getCountryText().sendKeys("india");
		hotelBook.getStateText().sendKeys("karnataka");
		hotelBook.getCityText().sendKeys("bengaluru");
		hotelBook.getPostalCodeText().sendKeys("560016");
		hotelBook.getStreetText().sendKeys("kasturi nagar");
		
		ListenerUtility.test.get().log(Status.INFO, "navigate to payment page");
		wu.javascriptClickElement(driver,hotelBook.getProceedPaymentBtn());
		
		wu.visibilityOfElement(driver,hotelBook.getPayNowText());
		String actual = hotelBook.getPayNowText().getText();
		Assert.assertEquals(actual, "Pay Now");
	}

	@Test(groups = { "smokeTest" })
	public void reserveHotelRoomTest() throws Exception {
		ListenerUtility.test.get().log(Status.INFO, "navigate to hotels module");
		HomePage home = new HomePage(driver);
		//home.getHotelsLink().click();
		wu.javascriptClickElement(driver,home.getHotelsLink());
		
		ListenerUtility.test.get().log(Status.INFO, "navigate to hotel detail page");
		HotelsPage hotels = new HotelsPage(driver);
		//wu.invisibilityOfElement(driver);
		//wu.waitUntilClickable(driver,hotels.getViewHotelBtn());
		//hotels.getViewHotelBtn().click();
		wu.javascriptClickElement(driver,hotels.getViewHotelBtn());

		ListenerUtility.test.get().log(Status.INFO, "click on reserve now button");
		HotelDetailPage hotelDetail = new HotelDetailPage(driver);
		//wu.scrollToElementMethod(driver,hotelDetail.getReserveNowBtn());
		//hotelDetail.getReserveNowBtn().click();
		wu.javascriptClickElement(driver,hotelDetail.getReserveNowBtn());
		
		HotelBookingPage hotelBook = new HotelBookingPage(driver);
		wu.visibilityOfElement(driver,hotelBook.getGuestDetailsHeadingText());
		String actual = hotelBook.getGuestDetailsHeadingText().getText();
		Assert.assertEquals(actual, "Guest Details");
		
	}

}
