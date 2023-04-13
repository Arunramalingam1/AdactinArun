package com.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class CancelBookingPage extends BaseClass {

	public CancelBookingPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Booked Itinerary']")
	private WebElement lnkBookedItinerary;

	@FindBy(xpath = "//input[@name='order_id_text']")
	private WebElement btnSearch;

	@FindBy(xpath = "//input[@name='search_hotel_id']")
	private WebElement btnGo;

	@FindBy(xpath = "(//input[@type='button'])[1]")
	private WebElement btnCancelselected;

//	@FindBy(xpath = "//input[@value='Cancel Selected']")
//	private WebElement btnCancelselected;
	
	@FindBy(xpath = "//label[@class='reg_error']")
	private WebElement expTheBookingHasBeenCancelled;

	

	public WebElement getExpTheBookingHasBeenCancelled() {
		return expTheBookingHasBeenCancelled;
	}

	

	public WebElement getLnkBookedItinerary() {
		return lnkBookedItinerary;
	}

	public WebElement getBtnsearch() {
		return btnSearch;
	}

	public WebElement getBtngo() {
		return btnGo;
	}

//	public WebElement getCheckcheckBox() {
//		return checkCheckBox;
//	}

	public WebElement getBtncancelselected() {
		return btnCancelselected;
	}

	/**
	 * @see Used to cancel the orderID
	 * @param orderId
	 * @throws InterruptedException
	 */

	public void cancelOrderID(String orderId) throws InterruptedException {
		clickButton(getLnkBookedItinerary());
		sendKeys(getBtnsearch(), orderId);
		clickButton(getBtngo());
		clickButton(getBtncancelselected());
		Thread.sleep(500);
		handleAlertWithAccept();

	}
}
