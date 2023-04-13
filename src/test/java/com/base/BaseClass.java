package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author ARUN
 * @see class contains reusable methods
 * @Date 16/02/2023
 *
 */

public class BaseClass {
	// initiate Driver Here
	public static WebDriver driver;

	/**
	 * @see Used to read the celldata
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @return String
	 * @throws IOException
	 */

	// Readcell Data
	public String readcellData(String sheetname, int rownum, int cellnum) throws IOException {
		String res = "";
		File file = new File("C:\\Users\\Lenovo\\eclipse-workspace\\FrameWorks\\Excel1\\Blazedemo.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(sheetname);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		CellType cellType = cell.getCellType();
		switch (cellType) {
		case STRING:
			res = cell.getStringCellValue();

			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateformat = new SimpleDateFormat("dd/MMM/yy");
				res = dateformat.format(dateCellValue);
			} else {
				double numericCellValue = cell.getNumericCellValue();
				long round = Math.round(numericCellValue);
				if (round == numericCellValue) {
					res = String.valueOf(round);
					break;
				}

			}
		default:
			break;

		}
		return res;
	}

	// update the value in cell
	/**
	 * @see Used to update the value in cell
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @param olddata
	 * @param newdata
	 * @throws IOException
	 */

	public void updatecellData(String sheetname, int rownum, int cellnum, String olddata, String newdata)
			throws IOException {

		File file = new File("C:\\Users\\Lenovo\\eclipse-workspace\\FrameWorks\\Excel1\\AdactinTestNG1.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(sheetname);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);

		String stringCellValue = cell.getStringCellValue();
		if (stringCellValue.equals(olddata)) {
			cell.setCellValue(newdata);

		}
		FileOutputStream output = new FileOutputStream(file);
		workbook.write(output);

	}

	/**
	 * @see To Write the Value in cell
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @param data
	 * @throws IOException
	 */

	// Write Cell Data
	public void writecellData(String sheetname, int rownum, int cellnum, String data) throws IOException {
		File file = new File("C:\\Users\\Lenovo\\eclipse-workspace\\FrameWorks\\Excel1\\Blazedemo.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(sheetname);
		Row row = sheet.getRow(rownum);
		// Cell cell = row.getCell(cellnum);
		Cell Cell = row.createCell(cellnum);
		Cell.setCellValue(data);
		FileOutputStream output = new FileOutputStream(file);
		workbook.write(output);

	}

	/**
	 * @see Used to Write the data in excel continuosly
	 * @param elements1
	 * @param sheetname
	 * @param filepath
	 * @throws IOException
	 */

	// wriecelldatacontinuosly
	public void writecellDataContinuosly(List<WebElement> elements1, String sheetname, String filepath)
			throws IOException {
		File file1 = new File(filepath);
		Workbook workbook = new XSSFWorkbook();
		Sheet createSheet = workbook.createSheet(sheetname);

		for (int i = 0; i < elements1.size(); i++) {
			WebElement webElement = elements1.get(i);
			String text = webElement.getText();
			Row createRow = createSheet.createRow(i);
			Cell createCell = createRow.createCell(0);
			createCell.setCellValue(text);
		}
		FileOutputStream out = new FileOutputStream(file1);
		workbook.write(out);
	}

	/**
	 * @see Used to get the Browser Using Switch statement
	 * @param browsertype
	 */

	// getBrowser
	public void getBrowser(String browsertype) {
		// WebDriver driver;
		switch (browsertype) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "FireFox":

			driver = new FirefoxDriver();
			break;

		case "Edge":

			driver = new EdgeDriver();
			break;
		case "Inernetexplorer":

			driver = new InternetExplorerDriver();
			break;

		default:
			break;
		}
	}

	/**
	 * @see Used to get Driver
	 */

	// 1 GetDriver
	public static void getDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	/**
	 * @see Used to get URL
	 * @param url
	 */
	// 2get URL
	public static void enterapplicationUrl(String url) {
		driver.get(url);
		// 3.maximize window
	}

	/**
	 * @see Used to maximize the Window
	 */

	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}

	// 4.Insert The value in text box using send keys
	/**
	 * @see Used to send Values in txtbox
	 * @param element
	 * @param data
	 */

	public void sendKeys(WebElement element, String data) {
		element.sendKeys(data);

	}

	// 5.click button
	/**
	 * @see Used to Click the element
	 * @param element
	 */
	public void clickButton(WebElement element) {
		element.click();
	}

	/**
	 * @see Used to get the txt from WebPage
	 * @param element
	 * @return
	 */

	// 7. get text from web page

	public String txtfromWebpage(WebElement element) {
		String text2 = element.getText();

		return text2;
	}

	/**
	 * @see Used to get the inserted value form the txt box
	 * @param element
	 * @return
	 */
	// 8.get the inserted value from the text box
	public String getAtrribute(WebElement element) {
		String attribute = element.getAttribute("Value");
		return attribute;

	}

	/**
	 * Used to wait or sleep for given seconds
	 * 
	 * @param second
	 * @throws InterruptedException
	 */

	public void ThreadSleep(long second) throws InterruptedException {
		Thread.sleep(second);
	}

	/**
	 * @see Used to Kill the Driver
	 */
	// 9. Kill all the window
	public void quite() {
		driver.quit();
	}

	/**
	 * @see Used to Close the current driver
	 */

	// 10.close current window
	public void close() {
		driver.close();
	}

	/**
	 * @see Used to get the title
	 * @return
	 */

	// 11. Get title
	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	/**
	 * @see Used to get the Entered Url
	 * @return
	 */
	// 12.Get EnteredUrl

	public String getEnteredUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;

	}

	/**
	 * @see Used to select dropdownby using visibletxt
	 * @param element
	 * @param text
	 */

	// 13.Select DropDownOption by text
	public void dropdownOptionbytext(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	/**
	 * @see Used to Select Dropdown by Attribute
	 * @param element
	 * @param value
	 */

	// 14.Select DropDownbyAttribute
	public void dropdownoptionbyAttribute(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	/**
	 * @see Used to Select DropDown by Index
	 * @param element
	 * @param index
	 */

	// 15.Select DropDownoptionby index
	public void dropdownoptionbyIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);

	}

	/**
	 * @see Used to insert the values using java script
	 * @param element
	 * @param data
	 */

	// 16.insertvalue.textbox using java script
	public void javascriptExcutor(WebElement element, String data) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("argument[0].setAttribute('value','" + data + "')", element);
	}

	/**
	 * @see Used Click the button using javascript excecutor
	 * @param element
	 */

	// 17.Click button in javascriptexcecutor
	public void javascriptexcecutorClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("argument[0].click()", element);
	}

	/**
	 * @see Used to Switch to Child Window
	 */

	// 19.Switch to Child Window
	public void switchtoChildWindow() {
		String parentid = driver.getWindowHandle();
		Set<String> allwindow = driver.getWindowHandles();
		for (String childid : allwindow) {
			if (!parentid.equals(childid))
				;
			driver.switchTo().window(childid);

		}
		

	}
	/**
	 * @see Used to switch frame by index
	 */

	// 20.Switch to FrameByINDEX
	public void switchtoframebyIndex(int index) {
		driver.switchTo().frame(index);

	}
	/**
	 * @see Used to locate the element by id
	 * @param id
	 * @return
	 */

	// 21.Find Locator by id
	public WebElement locatorbyID(String id) {
		WebElement Element = driver.findElement(By.id(id));
		return Element;
	}
	/**
	 * @see Used to switch frame by frame id
	 * @param name
	 */

	// 22.Switchto Frame by Frame ID
	public void switchtoFrambyframeID(String name) {
		driver.switchTo().frame(name);
	}
/**
 * @see Used to Locate the element by name
 * @param name
 * @return
 */
	// 23.find Locator byname
	public WebElement locatorbyname(String name) {
		WebElement Element = driver.findElement(By.name(name));
		return Element;
	}
	/**
	 * @see Used to locate the eleement by classname
	 * @param name
	 * @return
	 */

	// 24.Locator by classname
	public WebElement locatorbyClassName(String name) {
		WebElement Element = driver.findElement(By.className(name));
		return Element;
	}
/**
 * @see Used to Find elements using tagname
 * @param tagName
 * @return
 */
	// 24.1 to findElemts
	public List<WebElement> findElementsbytagnamXpath(String tagName) {
		List<WebElement> findElements = driver.findElements(By.tagName(tagName));
		for (int i = 0; i < findElements.size(); i++) {
			WebElement webElement = findElements.get(i);
			String text = webElement.getText();
			System.out.println(text);

		}
		return findElements;

	}
	/**
	 * @see Used to locate the elment by xpath
	 * @param xpath
	 * @return
	 */

	// 25.find Locator by Xpath
	public WebElement locatorbyXpath(String xpath) {
		WebElement Element = driver.findElement(By.xpath(xpath));

		return Element;
	}
/**
 * @see USed to get all the option using dropdown
 * @param element
 * @return
 */
	// 26.Get all the options fromdropdown
	public String alldropdownoptionsbytext(WebElement element) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		for (int i = 0; i < options.size(); i++) {
			WebElement webElement = options.get(i);
			String text = webElement.getText();
			return text;
		}
		return null;
	}
	/**
	 * @see Used to get all the options by using Attribute value
	 * @param element
	 * @return
	 */

	// 27. Get all the options fromdropdown as Attribute value
	public String alldropdownoptionsbyAttribute(WebElement element) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		for (int i = 0; i < options.size(); i++) {
			WebElement webElement = options.get(i);
			String attribute = webElement.getAttribute("value");
			return attribute;
		}
		return null;

	}
	/**
	 * @see Used to get the first selected option in Dropdown
	 * @param element
	 * @return
	 */

	// 28. Get first selected optiontextindropdown
	public String fistselectedoptioninDropdown(WebElement element) {
		Select select = new Select(element);
		WebElement firstSelectedOption = select.getFirstSelectedOption();
		String text = firstSelectedOption.getText();
		return text;
	}
/**
 * @see Used to verify the Dropdown is multiple
 * @param element
 * @return
 */
	// 29.verify Dropdown is multiple
	public boolean verifudropDownIsmultiple(WebElement element) {
		Select select = new Select(element);
		boolean multiple = select.isMultiple();
		return multiple;
	}
	/**
	 * Used for implicitwait
	 * @param time
	 */

	// 30.Implicit wait
	public void implicitWait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	//// 31.Explicit Wait
//		public void explicitWait(long timeout) {
//			WebDriver wait = (WebDriver) new WebDriverWait(driver, timeout);
//		}
	//
	//// 32.Fluent Wait
//		private void fuentWait(String input) {
//			WebDriver wait = (WebDriver) new FluentWait(input);
//		}
	/**
	 *@see Used to verify the element is Displayed
	 * @param element
	 * @return
	 */

	// 33.VerifyisDisplayed
	public boolean isDisplayed(WebElement element) {
		boolean isdisplayed = element.isDisplayed();
		return isdisplayed;
	}
	/**
	 * @see Used to verify the elemet is Enabled
	 * @param element
	 * @return
	 */

	// 34.verify is Enabled
	public boolean isEnabled(WebElement element) {
		boolean enabled = element.isEnabled();
		return enabled;
	}
	// 35.Verify is Selected
	/**
	 * @see USed to verify the elemet is selected
	 * @param element
	 * @return
	 */

	public boolean isSelected(WebElement element) {
		boolean selected = element.isSelected();

		return selected;
	}
/**
 * @see Used to deselect by index
 * @param element
 * @param index
 */
	// 36.Deselect byIndex
	public void deSelectbyIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.deselectByIndex(index);
	}
	/**
	 * @see Used to deselect by attribute
	 * @param element
	 * @param value
	 */

	// 37.DeSelect By Attribute
	public void deSelectbyAttribute(WebElement element, String value) {
		Select select = new Select(element);
		select.deselectByValue(value);
	}
	/**
	 * @see Used to deselect bytext
	 * @param element
	 * @param text
	 */

	// 37.DeSelect By Text
	public void deSelectbyText(WebElement element, String text) {
		Select select = new Select(element);
		select.deselectByVisibleText(text);
	}
	/**
	 * @see USed to deselect all
	 * @param element
	 */

	// 39.DeSelectAll
	public void deSelectAllt(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();
	}
	/**
	 * @see Used to get the parent window
	 * @return
	 */

	// 40.gettheparent Window
	public String getParentwindow() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}
	/**
	 * @see Used to get all the window
	 * @return
	 */

	// 41.GetAll the Window
	public Set<String> getAllwindow() {
		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;
	}
	/**
	 * @see Used to clear textbox
	 * @param element
	 */

	// 42.ClearextBox
	public void clearTextbox(WebElement element) {
		element.clear();

	}
	/**
	 * @see Used to take screenshot
	 * @param path
	 */

	// 43.TakeScreenShot
	public void Takescreenshot(String path) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File ScreenshotAs = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(ScreenshotAs, new File(path));
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	/**
	 * @see USed to find the locators using Switchcase
	 * @param Value
	 * @param locator
	 * @return
	 */

	// 44.Switch case for Locators
	public WebElement locatorsforallfindelement(String Value, String locator) {
		WebElement element = null;
		switch (locator) {
		case "ID":
			element = driver.findElement(By.id(Value));

			break;
		case "name":
			element = driver.findElement(By.name(Value));

			break;
		case "Xpath":
			element = driver.findElement(By.xpath(Value));

			break;
		case "tagname":
			element = driver.findElement(By.tagName(Value));

			break;

		default:
			break;
		}
		return element;
	}
/**
 * @see Used to get the projectpath
 * @return
 */

//getprojectpath		
	public static String getProjectPath() {
		String path = System.getProperty("user.dir");
		return path;

	}
	/**
	 * @see Used to get the propertyfile
	 * @param key
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */

//getpropertyfilevalue
	public static String getPropertyfilevalue(String key) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(getProjectPath() + "\\Config\\Config1.Properties"));
		Object object = properties.get(key);
		String value = (String) object;
		return value;

	}
	/**
	 * @see Used to handle alertwith accept
	 */

	public void handleAlertWithAccept() {

		Alert alert = driver.switchTo().alert();
		alert.accept();

	}
/**
 * @see Used to handle alert with dismiss
 */
	public void handleAlertWithDismiss() {

		Alert alert = driver.switchTo().alert();
		alert.dismiss();

	}
	/**
	 * @see Used Handle alert with sendkeys
	 * @param name
	 */

	public void handleAlertWithSendKeys(String name) {

		Alert alert = driver.switchTo().alert();
		alert.sendKeys(name);
		alert.accept();

	}
	/**
	 * @see Used to Screenshot 
	 * @return
	 */

	public byte[] screenShot() {

		TakesScreenshot ts = (TakesScreenshot) driver;
		byte[] screenshotAs = ts.getScreenshotAs(OutputType.BYTES);
		return screenshotAs;

	}

}
