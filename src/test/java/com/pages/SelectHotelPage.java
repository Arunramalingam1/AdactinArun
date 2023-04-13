package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class SelectHotelPage extends BaseClass {

	public SelectHotelPage() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='radiobutton_0']")
	private WebElement rdoRadiobtn;

	@FindBy(name = "continue")
	private WebElement btnSearch;
	
	@FindBy(xpath = "//td[text()='Select Hotel ']")
	private WebElement expSelectHotelSucessmsg;
	
	@FindBy(id = "radiobutton_span")
	private WebElement expPleaseSelectHotelErrorMsg;
	
	
	
	
	

	public WebElement getExpPleaseSelectHotelErrorMsg() {
		return expPleaseSelectHotelErrorMsg;
	}

	public WebElement getExpSelectHotelSucessmsg() {
		return expSelectHotelSucessmsg;
	}

	public WebElement getRdoradiobtn() {
		return rdoRadiobtn;
	}

	public WebElement getBtnsearch() {
		return btnSearch;
	}

	/**
	 * @see Used to select the Hotel Nmae
	 */

	public void selectHotelname() {
		clickButton(getRdoradiobtn());
		clickButton(getBtnsearch());

	}
/**
 * Used to click the continue buttoen with out selecting field
 */
	public void clickContinue() {
		clickButton(getBtnsearch());

	}

}