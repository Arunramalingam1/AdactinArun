package com.stepdefinition;

import org.openqa.selenium.WebElement;

import com.manager.PageobjectManager;

import io.cucumber.java.en.Then;
import junit.framework.Assert;

public class CommonStep {
	PageobjectManager pom = new PageobjectManager();

	
	@Then("User should verify after login success message {string}")
	public void userShouldVerifyAfterLoginSuccessMessage(String expLoginsuccessMsg) {
		WebElement sucessMsg = pom.getSearchHotelPage().getSucessMsg();
		String actsucessMsg = sucessMsg.getAttribute("Value");
		Assert.assertEquals("Verify afterLogin sucessMsg", expLoginsuccessMsg, actsucessMsg);
		
	}
}
