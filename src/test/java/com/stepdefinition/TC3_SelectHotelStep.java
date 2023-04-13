package com.stepdefinition;

import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.manager.PageobjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class TC3_SelectHotelStep extends BaseClass{

	PageobjectManager pom = new PageobjectManager();
	/**
	 * @see Used to Perform select and click continue
	 */
	@When("User Perform select and click continue")
	public void userPerformSelectAndClickContinue() {
		pom.getSelectHotelPage().selectHotelname();
	}
	/**
	 * @see   User should navigate to Book A Hotel page and verify the success message 
	 * @param expBookaHotelsucessMsg
	 */
	
	@Then("User should navigate to Book A Hotel page and verify the success message {string}")
	public void userShouldNavigateToBookAHotelPageAndVerifyTheSuccessMessage(String expBookaHotelsucessMsg) {
		String actBookaHotelsucessMsg = txtfromWebpage(pom.getBookHotelPage().getExpBookAHotelSucessMsg());
		Assert.assertEquals("Verify after Continue SucessMsg Msg", expBookaHotelsucessMsg, actBookaHotelsucessMsg);
		
		
	}
/**
 * @see Used to Perform continue
 */


	@When("User Perform continue")
	public void userPerformContinue() {
		pom.getSelectHotelPage().clickContinue();
	}
	/**
	 * @see   Used to verify after continue with the error message 
	 * @param expPleaseSelectaHotelErrorMsg
	 */
	@Then("User should verify after continue with the error message {string}")
	public void userShouldVerifyAfterContinueWithTheErrorMessage(String expPleaseSelectaHotelErrorMsg) {
		String actPleaseSelectHotelErrorMsg = txtfromWebpage(pom.getSelectHotelPage().getExpPleaseSelectHotelErrorMsg());
		Assert.assertEquals("Verify after Search Error Msg", expPleaseSelectaHotelErrorMsg, actPleaseSelectHotelErrorMsg);
		
	}




}
