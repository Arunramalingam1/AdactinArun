package com.pages;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

import io.cucumber.datatable.DataTable;

public class BookHotelPage extends BaseClass {
	public BookHotelPage() {

		PageFactory.initElements(driver, this);
	}

	@FindAll({ @FindBy(name = "first_name"), @FindBy(xpath = "//input[@id='first_name']") })
	private WebElement txtFirstName;
	@FindAll({ @FindBy(name = "last_name"), @FindBy(xpath = "//input[@id='first_name']") })
	private WebElement txtLastName;
	@FindAll({ @FindBy(name = "address"), @FindBy(xpath = "//input[@id='address']") })
	private WebElement txtAddress;
	@FindAll({ @FindBy(name = "cc_num"), @FindBy(xpath = "//input[@id='cc_num']") })
	private WebElement txtCcnum;
	@FindAll({ @FindBy(name = "cc_type"), @FindBy(xpath = "//input[@id='cc_type']") })
	private WebElement ddnCctype;
	@FindAll({ @FindBy(name = "cc_exp_month"), @FindBy(xpath = "//input[@id='cc_exp_month']") })
	private WebElement ddnExpmnth;
	@FindAll({ @FindBy(name = "cc_exp_year"), @FindBy(xpath = "//input[@id='cc_exp_year']") })
	private WebElement ddnExpyear;
	@FindAll({ @FindBy(name = "cc_cvv"), @FindBy(xpath = "//input[@id='cc_cvv']") })
	private WebElement txtCvv;
	@FindAll({ @FindBy(name = "book_now"), @FindBy(xpath = "//input[@id='book_now']") })
	private WebElement btnBooknow;
	@FindBy(xpath = "//td[text()='Book A Hotel ']")
	private WebElement expBookAHotelSucessMsg;
	@FindBy(xpath = "//label[text()='Please Enter your First Name']")
	private WebElement expPleaseEnterYourFirstNameErrorMsg;
	@FindBy(xpath = "//label[text()='Please Enter you Last Name']")
	private WebElement expPleaseEnterYourLastNameErrorMsg;
	@FindBy(xpath = "//label[text()='Please Enter your Address']")
	private WebElement expPleaseEnterYourAddressErrorMsg;
	@FindBy(xpath = "//label[text()='Please Enter your 16 Digit Credit Card Number']")
	private WebElement expPleaseEnteryour16DigitCreditCardNumberErrorMsg;
	@FindBy(xpath = "//label[text()='Please Select your Credit Card Type']")
	private WebElement expPleaseSelectyourCreditCardTypeErrorMsg;
	@FindBy(xpath = "//label[text()='Please Select your Credit Card Expiry Month']")
	private WebElement expPleaseSelectyourCreditCardExpiryMonthErrorMsg;
	@FindBy(xpath = "//label[text()='Please Enter your Credit Card CVV Number']")
	private WebElement expPleaseEnteryourCreditCardCVVNumberErrorMsg;
	

	public WebElement getExpPleaseEnterYourFirstNameErrorMsg() {
		return expPleaseEnterYourFirstNameErrorMsg;
	}

	public WebElement getExpPleaseEnterYourLastNameErrorMsg() {
		return expPleaseEnterYourLastNameErrorMsg;
	}

	public WebElement getExpPleaseEnterYourAddressErrorMsg() {
		return expPleaseEnterYourAddressErrorMsg;
	}

	public WebElement getExpPleaseEnteryour16DigitCreditCardNumberErrorMsg() {
		return expPleaseEnteryour16DigitCreditCardNumberErrorMsg;
	}

	public WebElement getExpPleaseSelectyourCreditCardTypeErrorMsg() {
		return expPleaseSelectyourCreditCardTypeErrorMsg;
	}

	public WebElement getExpPleaseSelectyourCreditCardExpiryMonthErrorMsg() {
		return expPleaseSelectyourCreditCardExpiryMonthErrorMsg;
	}

	public WebElement getExpPleaseEnteryourCreditCardCVVNumberErrorMsg() {
		return expPleaseEnteryourCreditCardCVVNumberErrorMsg;
	}

	public WebElement getExpBookAHotelSucessMsg() {
		return expBookAHotelSucessMsg;
	}

	public WebElement getTxtFirstname() {
		return txtFirstName;
	}

	public WebElement getTxtlastname() {
		return txtLastName;
	}

	public WebElement getTxtaddress() {
		return txtAddress;
	}

	public WebElement getTxtccnum() {
		return txtCcnum;
	}

	public WebElement getDdncctype() {
		return ddnCctype;
	}

	public WebElement getDdnexpmnth() {
		return ddnExpmnth;
	}

	public WebElement getDdnexpyear() {
		return ddnExpyear;
	}

	public WebElement getTxtcvv() {
		return txtCvv;
	}

	public WebElement getBtnbooknow() {
		return btnBooknow;
	}
	/**
	 * @see Used to book a hotel by fetching all the fields
	 * @param firstName
	 * @param lastName
	 * @param billingAddress
	 * @param datatable
	 */

	public void bookHotel(String firstName, String lastName, String billingAddress, 
			DataTable datatable) {
		sendKeys(getTxtFirstname(), firstName);
		sendKeys(getTxtlastname(), lastName);
		sendKeys(getTxtaddress(), billingAddress);
		
		
		List<Map<String, String>> payment = datatable.asMaps();
		Map<String, String> details = payment.get(1);
		String ccNo = details.get("creditcardNo");
		String cardType = details.get("creditcardType");
		String selectMonth = details.get("selectMonth");
		String selectYear = details.get("selectYear");
		String cvv = details.get("cvv");
		getTxtccnum().sendKeys(ccNo);
		getDdncctype().sendKeys(cardType);
		getDdnexpmnth().sendKeys(selectMonth);
		getDdnexpyear().sendKeys(selectYear);
		getTxtcvv().sendKeys(cvv);
		
		getBtnbooknow().click();

	}
	/**
	 * @see Used o book a hotel by click
	 */

	public void bookHotel() {
		getBtnbooknow().click();

	}

}
