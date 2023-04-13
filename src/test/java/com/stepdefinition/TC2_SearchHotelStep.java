package com.stepdefinition;

import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.manager.PageobjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class TC2_SearchHotelStep extends BaseClass {
	PageobjectManager pom = new PageobjectManager();

	/**
	 * @see Used to sEnterAllTheFields
	 * @param location
	 * @param hotels
	 * @param roomType
	 * @param numberofRooms
	 * @param checkinDate
	 * @param checkoutDate
	 * @param adultPerroom
	 * @param childperRoom
	 */

	@When("User enter all the fields {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void userEnterAllTheFieldsAnd(String location, String hotels, String roomType, String numberofRooms,
			String checkinDate, String checkoutDate, String adultPerroom, String childperRoom) {
		pom.getSearchHotelPage().searchHotel(location, hotels, roomType, numberofRooms, checkinDate, checkoutDate,
				adultPerroom, childperRoom);

	}
	/**
	 * @see   Used to verify the page should navigate to Select Hotel and verify the success message
	 * @param expSelectHotelsucessMsg
	 */

	@Then("User should navigate to Select Hotel and verify the success message {string}")
	public void userShouldNavigateToSelectHotelAndVerifyTheSuccessMessage(String expSelectHotelsucessMsg) {
		String actSelectHotelsucessMsg = txtfromWebpage(pom.getSelectHotelPage().getExpSelectHotelSucessmsg());
		Assert.assertEquals("Verify afterSearch sucessMsg", expSelectHotelsucessMsg, actSelectHotelsucessMsg);
	}
	/**
	 * @see   Used to enter only the mandatory fields
	 * @param location
	 * @param numberofRooms
	 * @param checkinDate
	 * @param checkoutDate
	 * @param adultPerroom
	 */

	@When("User enter only the mandatory fields {string},{string},{string},{string} and {string}")
	public void userEnterOnlyTheMandatoryFieldsAnd(String location, String numberofRooms, String checkinDate,
			String checkoutDate, String adultPerroom) {
		pom.getSearchHotelPage().searchHotel(location, numberofRooms, checkinDate, checkoutDate, adultPerroom);
	}
	/**
	 * @see   Used to verify after search with the error message
	 * @param expCheckInDateerrorMsg
	 * @param expCheckOutDateerrorMsg
	 */

	@Then("User should verify after search with the error message {string} and {string}")
	public void userShouldVerifyAfterSearchWithTheErrorMessageAnd(String expCheckInDateerrorMsg,
			String expCheckOutDateerrorMsg) {
		String actCheckInDateErrorMsgMsg = txtfromWebpage(pom.getSearchHotelPage().getExpCheckinDateErrorMsgMsg());
		Assert.assertEquals("Verify after Search ChecInDateErrorMsg", expCheckInDateerrorMsg,
				actCheckInDateErrorMsgMsg);
		String actCheckOutDateErrorMsg = txtfromWebpage(pom.getSearchHotelPage().getExpCheckOutDateErrorMsgMsg());
		Assert.assertEquals("Verify after Search ChecOutDateErrorMsg", expCheckOutDateerrorMsg,
				actCheckOutDateErrorMsg);

	}
	
	/**
	 * @see Used to click the search option
	 */

	@When("User click the search option")
	public void userClickTheSearchOption() {
		pom.getSearchHotelPage().searchHotel();
	}
	/**
	 * @see Used to verify after search hotel with the errormessage
	 * @param exppleaseselectalocationerrorMsg
	 */

	@Then("User should verify after search hotel with the errormessage {string}")
	public void userShouldVerifyAfterSearchHotelWithTheErrormessage(String exppleaseselectalocationerrorMsg) {
		String actPleaseSelectaLocationSucessMsgMsg = txtfromWebpage(pom.getSearchHotelPage().getExpPleaseSelectaLocationSucessMsgMsg());
		Assert.assertEquals("Verify afterSerach Please select a Hotel Error Msg", exppleaseselectalocationerrorMsg,
				actPleaseSelectaLocationSucessMsgMsg);
	}

}
