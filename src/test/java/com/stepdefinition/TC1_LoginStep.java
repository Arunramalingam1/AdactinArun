package com.stepdefinition;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.manager.PageobjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
/**
 *@author Arun 
 *@see Loginstep
 *@Date   17/02/23
 *
 */

public class TC1_LoginStep extends BaseClass{
	/**
	 * @see User is on Adactinpage
	 */
	PageobjectManager pom = new PageobjectManager();

	@Given("User is on Adactinpage")
	public void userIsOnAdactinpage() throws FileNotFoundException, IOException {
//		getBrowser(getPropertyfilevalue("browser"));
////		getDriver();
//		enterapplicationUrl(getPropertyfilevalue("url"));
//		maximizeWindow();
//		implicitWait(1000);
//		
	}
	/**
	 * @see   User perform login
	 * @param string
	 * @param string2
	 */

	@When("User perform login {string},{string}")
	public void userPerformLogin(String userName, String passWord) {
		pom.getLoginPage().login(userName, passWord);
	}
	/**
	 * @see   User perform login withEnter
	 * @param string
	 * @param string2
	 * @throws AWTException 
	 */
	@When("User perform login {string},{string} with enterkey")
	public void userPerformLoginWithEnterkey(String userName, String passWord) throws AWTException {
		pom.getLoginPage().loginwithEnter(userName, passWord);
	}
	/**
	 * @see   User should verify the login error message
	 * @param expInvalidLogindetailsorYourPasswordmighthaveexpirederrorMsg
	 */

	@Then("User should verify the login error message contains {string}.")
	public void userShouldVerifyTheLoginErrorMessageContains(
			String expLoginerrorMsg) {
	   String actLoginerrorMsg = txtfromWebpage(pom.getLoginPage().getErrorMsg());
	   System.out.println(actLoginerrorMsg);
		Assert.assertEquals("Verify afterLogin errorMsg", expLoginerrorMsg, actLoginerrorMsg);
		
		
		
		
	}

}
