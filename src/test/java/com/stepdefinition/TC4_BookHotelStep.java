package com.stepdefinition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.manager.PageobjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class TC4_BookHotelStep extends BaseClass {
	PageobjectManager pom = new PageobjectManager();

	/**
	 * @see Used to enter all the fields
	 * @param firstName
	 * @param lastName
	 * @param billingAddress
	 * @param dataTable
	 */

	@When("User enter all the fields {string},{string} and {string}")
	public void userEnterAllTheFieldsAnd(String firstName, String lastName, String billingAddress,
			io.cucumber.datatable.DataTable dataTable) {

		pom.getBookHotelPage().bookHotel(firstName, lastName, billingAddress, dataTable);

	}

	/**
	 * @see Used to should verify after the booknow the page navigates to
	 *      BookingConfirmation page
	 */
	@Then("User should verify after the booknow the page navigates to {string} and save orderid")
	public void userShouldVerifyAfterTheBooknowThePageNavigatesToAndSaveOrderid(
			String expBookingConfirmationSucessMsg) {
		String actBookingConfirmationSucessMsg = txtfromWebpage(
				pom.getBookingConfirmationPage().getExpBookingConfirmationSucessMsg());
		Assert.assertEquals(expBookingConfirmationSucessMsg, actBookingConfirmationSucessMsg);
	}

	/**
	 * @see Used to perform Booknow option
	 */

	@When("User perform Booknow option")
	public void userPerformBooknowOption() {
		pom.getBookHotelPage().bookHotel();
	}

	/**
	 * @see Used to verify after he booknow errormessage
	 * @param expFirstNameerroMsg
	 * @param expLastNameerroMsg
	 * @param expAddresserroMsg
	 * @param expPleaseEnteryour16DigitCreditCardNumbererroeMsg
	 * @param expPleaseSelectyourCreditCardTypeerorMsg
	 * @param expPleaseSelectyourCreditCardExpiryMontherrorMsg
	 * @param expPleaseEnteryourCreditCardCVVNumbererrorMsg
	 */

	@Then("User should verify after he booknow errormessage {string},{string},{string},{string},{string},{string} and {string}")
	public void userShouldVerifyAfterHeBooknowErrormessageAnd(String expFirstNameErroMsg, String expLastNameErroMsg,
			String expAddressErroMsg, String expCreditCardNumberErrorMsg, String expCreditCardTypeErorMsg,
			String expMonthYearErrorrMsg, String expCreditCardCVVNumberErrorMsg) {
		String actFirstNameErrorMsg = txtfromWebpage(pom.getBookHotelPage().getExpPleaseEnterYourFirstNameErrorMsg());
		Assert.assertEquals(expFirstNameErroMsg, actFirstNameErrorMsg);
		String actLastNameErrorMsg = txtfromWebpage(pom.getBookHotelPage().getExpPleaseEnterYourLastNameErrorMsg());
		Assert.assertEquals(expLastNameErroMsg, actLastNameErrorMsg);
		String actAddressErrorMsg = txtfromWebpage(pom.getBookHotelPage().getExpPleaseEnterYourAddressErrorMsg());
		Assert.assertEquals(expAddressErroMsg, actAddressErrorMsg);
		String actCcNumErrorMsg = txtfromWebpage(
				pom.getBookHotelPage().getExpPleaseEnteryour16DigitCreditCardNumberErrorMsg());
		Assert.assertEquals(expCreditCardNumberErrorMsg, expCreditCardNumberErrorMsg);
		String actCardcardTypeErrorMsg = txtfromWebpage(
				pom.getBookHotelPage().getExpPleaseSelectyourCreditCardTypeErrorMsg());
		Assert.assertEquals(expCreditCardTypeErorMsg, actCardcardTypeErrorMsg);
		String actMonthYearErrorMsg = txtfromWebpage(
				pom.getBookHotelPage().getExpPleaseSelectyourCreditCardExpiryMonthErrorMsg());
		Assert.assertEquals(expMonthYearErrorrMsg, actMonthYearErrorMsg);
		String actCreditCardCvvErrorMsg = txtfromWebpage(
				pom.getBookHotelPage().getExpPleaseEnteryourCreditCardCVVNumberErrorMsg());
		Assert.assertEquals(expCreditCardCVVNumberErrorMsg, actCreditCardCvvErrorMsg);
	}

}
