package com.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class SearchHotelPage extends BaseClass {

	public SearchHotelPage() {

		PageFactory.initElements(driver, this);
	}

	@FindBys({ @FindBy(id = "location"), @FindBy(xpath = "//select[@name='location']") })
	private WebElement ddnLocation;
	@FindBys({ @FindBy(name = "hotels"), @FindBy(xpath = "//select[@id='hotels']") })
	private WebElement ddnHotels;
	@FindBys({ @FindBy(name = "room_type"), @FindBy(xpath = "//select[@id='room_type']") })
	private WebElement ddnRoomType;
	@FindBys({ @FindBy(name = "room_nos"), @FindBy(xpath = "//select[@id='room_nos']") })
	private WebElement ddnRoomNo;
	@FindBys({ @FindBy(name = "datepick_in"), @FindBy(xpath = "//input[@id='datepick_in']") })
	private WebElement txtCheckIn;
	@FindBys({ @FindBy(name = "datepick_out"), @FindBy(xpath = "//input[@id='datepick_out']") })
	private WebElement txtCheckOut;
	@FindBys({ @FindBy(name = "adult_room"), @FindBy(xpath = "//select[@id='adult_room']") })
	private WebElement ddnAdultRoom;
	@FindBys({ @FindBy(name = "child_room"), @FindBy(xpath = "//select[@id='child_room']") })
	private WebElement ddnChildRoom;
	@FindBys({ @FindBy(name = "Submit"), @FindBy(xpath = "//input[@id='Submit']") })
	private WebElement btnSubmit;
	@FindBy(xpath="//input[@name='username_show']")
	private WebElement expLoginSucessMsg;
	@FindBy(id="checkin_span")
	private WebElement expCheckinDateErrorMsgMsg;
	@FindBy(id="checkout_span")
	private WebElement expCheckOutDateErrorMsgMsg;
	@FindBy(id="location_span")
	private WebElement expPleaseSelectaLocationSucessMsgMsg;
	

	public WebElement getExpCheckinDateErrorMsgMsg() {
		return expCheckinDateErrorMsgMsg;
	}

	public WebElement getExpPleaseSelectaLocationSucessMsgMsg() {
		return expPleaseSelectaLocationSucessMsgMsg;
	}

	public WebElement getExpCheckOutDateErrorMsgMsg() {
		return expCheckOutDateErrorMsgMsg;
	}

	public WebElement getSucessMsg() {
		return expLoginSucessMsg;
	}

	public WebElement getDdnlocation() {
		return ddnLocation;
	}

	public WebElement getDdnhotels() {
		return ddnHotels;
	}

	public WebElement getDdnroomtype() {
		return ddnRoomType;
	}

	public WebElement getDdnroomno() {
		return ddnRoomNo;
	}

	public WebElement getTxtcheckin() {
		return txtCheckIn;
	}

	public WebElement getTxtcheckout() {
		return txtCheckOut;
	}

	public WebElement getDdnadultroom() {
		return ddnAdultRoom;
	}

	public WebElement getDdnchildroom() {
		return ddnChildRoom;
	}

	public WebElement getBtnsubmit() {
		return btnSubmit;
	}
	/**
	 * @see Used to search the hotel by selecting all the fields
	 * @param location
	 * @param hotels
	 * @param roomType
	 * @param numberofRooms
	 * @param checkinDate
	 * @param checkoutDate
	 * @param adultPerroom
	 * @param childperRoom
	 */

	

	public void searchHotel(String location, String hotels, String roomType, String numberofRooms,
			String checkinDate, String checkoutDate, String adultPerroom, String childperRoom) {

		dropdownOptionbytext(getDdnlocation(), location);
		dropdownOptionbytext(getDdnhotels(), hotels);
		dropdownOptionbytext(getDdnroomtype(), roomType);
		dropdownOptionbytext(getDdnroomno(), numberofRooms);
		getTxtcheckin().clear();
		sendKeys(getTxtcheckin(), checkinDate);
		getTxtcheckout().clear();
		sendKeys(getTxtcheckout(), checkoutDate);
		dropdownOptionbytext(getDdnadultroom(), adultPerroom);
		dropdownOptionbytext(getDdnchildroom(), childperRoom);
		clickButton(getBtnsubmit());

	}
	/**
	 * @see Used to perform search hotel by selecting mandatory fields
	 * @param location
	 * @param numberofRooms
	 * @param checkinDate
	 * @param checkoutDate
	 * @param adultPerroom
	 */

	public void searchHotel(String location, String numberofRooms, String checkinDate, String checkoutDate,
			String adultPerroom) {

		dropdownOptionbytext(getDdnlocation(), location);
		dropdownOptionbytext(getDdnroomno(), numberofRooms);
		getTxtcheckin().clear();
		sendKeys(getTxtcheckin(), checkoutDate);
		getTxtcheckout().clear();
		sendKeys(getTxtcheckout(), checkoutDate);
		dropdownOptionbytext(getDdnadultroom(), adultPerroom);
		clickButton(getBtnsubmit());

	}
/**
 * @see Used to click the search button with out entering the fields
 */
	public void searchHotel() {

		clickButton(getBtnsubmit());

	}

}
