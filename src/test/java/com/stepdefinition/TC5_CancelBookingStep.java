package com.stepdefinition;

import com.base.BaseClass;
import com.manager.PageobjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class TC5_CancelBookingStep extends BaseClass {

	PageobjectManager pom = new PageobjectManager();

	/**
	 * @see Used to performs cancellation of generated orderid
	 * @throws InterruptedException
	 */

	@When("User performs cancellation of generated orderid")
	public void userPerformsCancellationOfGeneratedOrderid() throws InterruptedException {
		String orderId = pom.getBookingConfirmationPage().getOrderId();
		pom.getCancelBookingPage().cancelOrderID(orderId);

	}

	/**
	 * @see Used to perform Booked Itinerary and search {string} to cancel the
	 *      existing Order Id
	 * @param orderId
	 * @throws InterruptedException
	 */

	@When("User perform Booked Itinerary and search {string} to cancel the existing Order Id")
	public void userPerformBookedItineraryAndSearchToCancelTheExistingOrderId(String orderId)
			throws InterruptedException {
		pom.getCancelBookingPage().cancelOrderID(orderId);
	}

	/**
	 * @see Used to Should verify after cancel sucess message
	 * @param expThebookinghasbeencancelledErrorMsg
	 */

	@Then("User Should verify after cancel sucess message {string}")
	public void userShouldVerifyAfterCancelSucessMessage(String expThebookinghasbeencancelledErrorMsg) {
		String actTheBookingHasBeenCancelledErrorMsg = txtfromWebpage(
				pom.getCancelBookingPage().getExpTheBookingHasBeenCancelled());
		Assert.assertEquals(expThebookinghasbeencancelledErrorMsg, actTheBookingHasBeenCancelledErrorMsg);

	}

}
