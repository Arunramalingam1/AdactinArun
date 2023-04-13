package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class LoginPage extends BaseClass {
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	private WebElement txtUserName;

	@FindBy(id = "password")
	private WebElement txtPassWord;

	@FindBy(id = "login")
	private WebElement btnLogin;
	@FindBy(xpath="//div[@class='auth_error']")
	private WebElement errorMsg;
	
	

	public WebElement getErrorMsg() {
		return errorMsg;
	}

	public WebElement gettxtUserName() {
		return txtUserName;
	}

	public WebElement gettxtPassWord() {
		return txtPassWord;
	}

	public WebElement getbtnLogin() {
		return btnLogin;
	}
	/**
	 * @see Used to perform login using userNmae ane passWord
	 * @param userName
	 * @param passWord
	 */
	
	

	public void login(String userName, String passWord) {
		sendKeys(gettxtUserName(), userName);
		sendKeys(gettxtPassWord(), passWord);
		clickButton(getbtnLogin());

	}
	/**
	 * @see Used to perform login using enterkey
	 * @param userName
	 * @param passWord
	 * @throws AWTException
	 */

	public void loginwithEnter(String userName, String passWord) throws AWTException {
		sendKeys(gettxtUserName(), userName);
		sendKeys(gettxtPassWord(), passWord);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}
}
