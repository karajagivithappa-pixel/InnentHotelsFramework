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
	public void autofillGuestDetailTest() throws Exception {
		
		String expected=eu.readDataExcel("hotel",2,0);
		
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
		Assert.assertEquals(actual,expected);
		
	}
	
	@Test(groups = { "integrationTest" })
	public void defaultCityTest() throws Exception {

		String expected=eu.readDataExcel("hotel",6,0);
		
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
		boolean status = hotelAddress.contains(expected);
		Assert.assertTrue(status);
		
	}

	@Test(groups = { "systemTest" })
	public void bookHotelTest() throws Exception {
		
		String countryCode=eu.readDataExcel("hotel",10,0);
		String country=eu.readDataExcel("hotel",10,1);
		String state=eu.readDataExcel("hotel",10,2);
		String city=eu.readDataExcel("hotel",10,3);
		String postalCode=eu.readDataExcel("hotel",10,4);
		String street=eu.readDataExcel("hotel",10,5);
		String expected=eu.readDataExcel("hotel",10,6);
		
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
		//hotels.getHotelSearchBtn().click();
		wu.javascriptClickElement(driver,hotels.getHotelSearchBtn());
		Thread.sleep(2000);
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
		hotelBook.getCountryCodeInput().sendKeys(countryCode);
		wu.javascriptClickElement(driver,hotelBook.getCheckboxBtn());
		
		ListenerUtility.test.get().log(Status.INFO, "navigate to billing address page");
		//hotelBook.getProceedBillingBtn().click();
		wu.javascriptClickElement(driver,hotelBook.getProceedBillingBtn());
		
		ListenerUtility.test.get().log(Status.INFO, "fill the details");
		wu.waitUntilClickable(driver,hotelBook.getStateText());
		hotelBook.getCountryText().sendKeys(country);
		hotelBook.getStateText().sendKeys(state);
		hotelBook.getCityText().sendKeys(city);
		hotelBook.getPostalCodeText().sendKeys(postalCode);
		hotelBook.getStreetText().sendKeys(street);
		
		ListenerUtility.test.get().log(Status.INFO, "navigate to payment page");
		wu.javascriptClickElement(driver,hotelBook.getProceedPaymentBtn());
		
		wu.visibilityOfElement(driver,hotelBook.getPayNowText());
		String actual = hotelBook.getPayNowText().getText();
		Assert.assertEquals(actual,expected);
	}

	@Test(groups = { "smokeTest" })
	public void reserveHotelRoomTest() throws Exception {
		
		String expected=eu.readDataExcel("hotel",14,0);
		
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
		Assert.assertEquals(actual,expected);
		
	}

}
