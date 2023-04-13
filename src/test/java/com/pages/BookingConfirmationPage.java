package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class BookingConfirmationPage extends BaseClass {
	public BookingConfirmationPage() {
		PageFactory.initElements(driver, this);
	}

	@FindAll({ @FindBy(name = "order_no"), @FindBy(xpath = "//input[@id='order_no']") })
	private WebElement txtOrderno;
	@FindBy(xpath="//td[text()='Booking Confirmation ']")
	private WebElement expBookingConfirmationSucessMsg;

	public WebElement getExpBookingConfirmationSucessMsg() {
		return expBookingConfirmationSucessMsg;
	}

	public WebElement getTxtorderno() {
		return txtOrderno;
	}
/**
 * @see Used to get the orderID
 * @return
 */
	public String getOrderId() {
		String orderID = getTxtorderno().getAttribute("Value");
		System.out.println(orderID);
		return orderID;

	}

}
