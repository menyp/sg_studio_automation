import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.xml.sax.SAXException;

import winium.elements.desktop.ComboBox;
import winium.elements.desktop.ListBox;
import winium.elements.desktop.extensions.WebElementExtensions;




import com.applitools.eyes.Eyes;
import com.gargoylesoftware.htmlunit.javascript.host.html.Image;
import com.google.common.base.Function;

public class StudioMethods {

	WiniumDriver driver;
	StudioElements sgData;
	// StudioMethods genMeth;
	Eyes eyes = new Eyes();
	Boolean useEye = true;

	public void cleanLogin(StudioMethods genMeth) throws ParserConfigurationException, SAXException,
			IOException, InterruptedException {
		
		genMeth.clearId(genMeth, sgData.TextFieldUsername);
		genMeth.sendId(genMeth, sgData.TextFieldUsername, sgData.userQA);

		genMeth.clearId(genMeth, sgData.TextFieldPassword);
		genMeth.sendId(genMeth, sgData.TextFieldPassword, sgData.passwordQA);

		genMeth.clickId(genMeth, sgData.BtnSignIn);
	//	genMeth.takeScreenShot(driver, genMeth,"");
	}

	public void eyesCheckWindow(Eyes eyes, String testName, Boolean useEye)
			throws InterruptedException, IOException {

		if (useEye) {


			eyes.setApiKey("Hbh6716cKDCgn8a9bMAREPM105nbW109PQe0993So5GwFpNM110");
			BufferedImage img;
		//	eyes.open(driver, "Studio testing", testName);

			File scrFile = (driver.getScreenshotAs(OutputType.FILE));
            img = ImageIO.read(scrFile);
  //          eyes.checkImage(img, "Temp test");

            
			// Now you can do whatever you need to do with it, for example copy
			// somewhere
			
		
			
/*
			eyes.open(driver, "Studio testing", testName);
			eyes.setMatchTimeout(2);
			eyes.checkWindow("Sample Screen");
*/
			boolean skipfailure = true;
			if (skipfailure) {
				// Use the below code instead of eyes.close(); --> It will allow
				// to continue the test even if the UI testing will fail
				com.applitools.eyes.TestResults testResult = eyes.close(false);

			} else {

				eyes.close();
			}

		}

	}

	public WiniumDriver setDesktopOptions(StudioMethods genMeth)
			throws IOException, ParserConfigurationException, SAXException,
			InterruptedException {

		DesktopOptions options = new DesktopOptions();
		options.setApplicationPath("C:\\Program Files (x86)\\SkyGiraffe\\Studio\\Studio.exe");

		try {

			driver = new WiniumDriver(new URL("http://localhost:9999"), options);
		}

		catch (MalformedURLException e) {

			genMeth.takeScreenShot(driver, genMeth,
					"Faliled to open Winum driver");
			org.testng.Assert.fail("WebElement"
					+ " Faliled to open Winium driver");
		}

		return driver;
	}

	public StudioElements setElements(String webElementXmlPath,
			String webElementXmlLang) throws ParserConfigurationException,
			jdk.internal.org.xml.sax.SAXException, IOException,
			InterruptedException, SAXException {

		sgData = new StudioElements(webElementXmlLang, webElementXmlPath);

		return sgData;
	}

	public void signOutFromStartup(StudioMethods genMeth, StudioElements sgSata)
			throws InterruptedException, IOException {

	}

	public String getValueFromPropFile(String key) {
		Properties properties = new Properties();
		String value = "";
		try {

			properties.load(getClass().getResourceAsStream(
					"/resources/config.properties"));
			// properties.load(getClass().getResourceAsStream("/resources/webui.properties"));
			{
				value = properties.getProperty(key);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return value;
	}

	public void takeScreenShot(WiniumDriver driver, StudioMethods genMeth,
			String imageName) throws IOException {

		File scrFile = (driver.getScreenshotAs(OutputType.FILE));
		String currentTime = genMeth.currentTime();
		String currentDate = genMeth.currentDate();

		// Now you can do whatever you need to do with it, for example copy
		// somewhere
		String imagePath = genMeth.getValueFromPropFile("screenshotPath")
				+ currentDate + "/" + currentTime + "_" + imageName + ".JPG";
		FileUtils.copyFile(scrFile, new File(imagePath));

	}

	public void takeScreenShotSG(StudioMethods genMeth, String imageName)
			throws IOException {
		//String currentTime = genMeth.currentTime();
		File scrFile = (driver.getScreenshotAs(OutputType.FILE));
		//String currentDate = genMeth.currentDate();

		// Now you can do whatever you need to do with it, for example copy
		// somewhere
		String imagePath = genMeth
				.getValueFromPropFile("screenshotPathPositive")
				
				+ "/"  + "_" + imageName + ".JPG";
		FileUtils.copyFile(scrFile, new File(imagePath));
		
	}

	/*
	 * ***************************************************
	 * Web Element Handling *
	 * ***************************************************
	 */

	// ==================== RETURN ELEMENT

	public WebElement returnCss(WiniumDriver driver, String cssSelector)
			throws InterruptedException {

		StudioMethods genMeth = new StudioMethods();
		try {

			genMeth.fluentwait(driver, By.cssSelector(cssSelector));

		}

		catch (Exception e) {

			org.testng.Assert.fail("WebElement 'by css' can't be located");

		}

		WebElement myElement = genMeth.fluentwait(driver,
				By.cssSelector(cssSelector));
		return myElement;
	}

	public WebElement returnId(WiniumDriver driver, StudioMethods genMeth,
			String id) throws InterruptedException {

		try {

			genMeth.fluentwait(driver, By.id(id));

		}

		catch (Exception e) {

			org.testng.Assert.fail(id + " didn't display");

		}

		WebElement myElement = genMeth.fluentwait(driver, By.id(id));
		return myElement;

	}

	public WebElement returnClassName(WiniumDriver driver,
			StudioMethods genMeth, String className)
			throws InterruptedException {

		try {

			genMeth.fluentwait(driver, By.className(className));
		}

		catch (Exception e) {

			org.testng.Assert.fail(className + " didn't display");

		}

		WebElement myElement = genMeth.fluentwait(driver,
				By.className(className));
		return myElement;
	}

	public WebElement returnXpth(WiniumDriver driver, StudioMethods genMeth,
			String xpth) throws InterruptedException {

		try {

			genMeth.fluentwait(driver, By.xpath(xpth));

		}

		catch (Exception e) {

			org.testng.Assert.fail(xpth + " didn't display");
		}

		WebElement myElement = genMeth.fluentwait(driver, By.xpath(xpth));
		return myElement;

	}

	public WebElement returnName(WiniumDriver driver, StudioMethods genMeth,
			String name) throws InterruptedException {

		try {

			genMeth.fluentwait(driver, By.name(name));

		}

		catch (Exception e) {

			org.testng.Assert.fail(name + " didn't display");

		}

		WebElement myElement = genMeth.fluentwait(driver, By.name(name));
		return myElement;

	}

	public WebElement returnBy(StudioMethods genMeth, By by)
			throws InterruptedException {

		try {

			genMeth.fluentwait(driver, by);

		}

		catch (Exception e) {

			org.testng.Assert.fail(by + " didn't display");

		}

		WebElement myElement = genMeth.fluentwait(driver, by);
		return myElement;

	}

	// ========= CLICK an ELEMENT
	// =========================================================================

	public void clickBy(WiniumDriver driver, StudioMethods genMeth, By by)
			throws InterruptedException {

		try {

			WebElement myElement = genMeth.fluentwait(driver, by);
			myElement.click();
		}

		catch (Exception e) {

			org.testng.Assert.fail("WebElement can't be located");

		}

	}

	public void clickCss(WiniumDriver driver, StudioMethods genMeth,
			String cssSelector) throws InterruptedException {

		try {

			WebElement myElement = genMeth.fluentwait(driver,
					By.cssSelector(cssSelector));
			myElement.click();

		}

		catch (Exception e) {

			org.testng.Assert.fail(cssSelector + " didn't display");

		}

	}


	public void clickId(StudioMethods genMeth, String id)
			throws InterruptedException, IOException {

		try {
			WebElement myElement = genMeth.fluentwait(driver, By.id(id));
			myElement.click();

			// driver.findElementById(id).click();

		}

		catch (Exception e) {

			genMeth.takeScreenShot(driver, genMeth, id);
			org.testng.Assert.fail(id + " didn't display");

		}
	}

	public void clickClassName(WiniumDriver driver, StudioMethods genMeth,
			String className) throws InterruptedException {

		try {

			genMeth.fluentwait(driver, By.className(className)).click();

		}

		catch (Exception e) {

			org.testng.Assert.fail(className + " didn't display");

		}

	}

	public void clickXpth(StudioMethods genMeth, String xpth)
			throws InterruptedException, IOException {

		By by = By.xpath(xpth);

		try {

			WebElement myElement = genMeth.fluentwait(driver, by);
			myElement.click();
			// driver.findElementByXPath(xpth).click();

		}

		catch (Exception e) {
			genMeth.takeScreenShot(driver, genMeth, xpth);
			org.testng.Assert.fail(xpth + " didn't display");

		}

	}

	public void clickName(StudioMethods genMeth, String name)
			throws InterruptedException, IOException {

		try {

			WebElement myElement = genMeth.fluentwait(driver, By.name(name));
			myElement.click();
		}

		catch (Exception e) {
			// String testName = new
			// Object(){}.getClass().getEnclosingMethod().getName();
			genMeth.takeScreenShot(driver, genMeth, name);
			org.testng.Assert.fail(name + " didn't display");

		}

	}

	// ======================== SEND ELEMENT
	// =========================================

	public void sendBy(WiniumDriver driver, StudioMethods genMeth, By by,
			String send) throws InterruptedException, IOException {

		try {

			WebElement myElement = genMeth.fluentwait(driver, by);
			myElement.sendKeys(send);

		}

		catch (Exception e) {

			genMeth.takeScreenShot(driver, genMeth, send);
			org.testng.Assert.fail("WebElement'send by' can't be located");

		}

	}

	public void sendCss(WiniumDriver driver, StudioMethods genMeth,
			String cssSelector, String send) throws InterruptedException {

		try {

			WebElement myElement = genMeth.fluentwait(driver,
					By.cssSelector(cssSelector));
			myElement.sendKeys(send);
		}

		catch (Exception e) {

			org.testng.Assert.fail("Css selector " + cssSelector
					+ " can't be located");

		}

	}

	public void sendId(StudioMethods genMeth, String id, String send)
			throws InterruptedException, IOException {

		try {

			WebElement myElement = genMeth.fluentwait(driver, By.id(id));
			myElement.sendKeys(send);

		}

		catch (Exception e) {

			genMeth.takeScreenShot(driver, genMeth, send);
			org.testng.Assert.fail(id + "didn't displayed");

		}

	}

	public void sendClassName(WiniumDriver driver, StudioMethods genMeth,
			String className, String send) throws InterruptedException {

		try {

			genMeth.fluentwait(driver, By.className(className)).sendKeys(send);

		}

		catch (Exception e) {

			org.testng.Assert.fail(className + "didn't displayed");

		}

	}

	public void sendXpth(StudioMethods genMeth, String xpth, String send)
			throws InterruptedException, IOException {

		try {

			WebElement myElement = genMeth.fluentwait(driver, By.xpath(xpth));
			myElement.sendKeys(send);

		}

		catch (Exception e) {

			genMeth.takeScreenShot(driver, genMeth, send);
			org.testng.Assert.fail(xpth + "didn't displayed");

		}

	}

	/*
	 * public void sendXpth(WiniumDriver driver, IosMethods genMeth, String
	 * xpth, String send) throws IOException {
	 * 
	 * try {
	 * 
	 * WebElement myElement = genMeth.fluentwait(driver, By.xpath(xpth));
	 * myElement.sendKeys(send);
	 * 
	 * }
	 * 
	 * catch (Exception e) {
	 * 
	 * genMeth.takeScreenShot(driver, genMeth, xpth);
	 * org.testng.Assert.fail(xpth + "didn't displayed");
	 * 
	 * }
	 * 
	 * }
	 */
	public void sendName(StudioMethods genMeth, String name, String send)
			throws IOException {

		try {

			WebElement myElement = genMeth.fluentwait(driver, By.name(name));
			myElement.sendKeys(send);
		}

		catch (Exception e) {

			genMeth.takeScreenShot(driver, genMeth, name);
			org.testng.Assert.fail(name + "didn't displayed");

		}

	}

	// =========================Clear
	// WebElements=====================================================================

	public void clearXpth(WiniumDriver driver, StudioMethods genMeth,
			String xpath) throws InterruptedException {

		try {

			WebElement myElement = genMeth.fluentwait(driver, By.xpath(xpath));
			myElement.clear();

		}

		catch (Exception e) {

			org.testng.Assert.fail(xpath + "didn't displayed");

		}

	}

	public void clearClassName(WiniumDriver driver, StudioMethods genMeth,
			String className) throws InterruptedException {

		try {

			WebElement myElement = genMeth.fluentwait(driver,
					By.className(className));
			myElement.clear();

		}

		catch (Exception e) {

			org.testng.Assert.fail(className + "didn't displayed");

		}

	}

	public void clearId(StudioMethods genMeth, String id)
			throws InterruptedException {

		try {

			WebElement myElement = genMeth.fluentwait(driver, By.id(id));
			myElement.clear();

		}

		catch (Exception e) {

			org.testng.Assert.fail(id + "didn't displayed");

		}

	}

	public void clearCss(WiniumDriver driver, StudioMethods genMeth,
			String cssSelector) throws InterruptedException {

		try {

			WebElement myElement = genMeth.fluentwait(driver,
					By.cssSelector(cssSelector));
			myElement.clear();

		}

		catch (Exception e) {

			org.testng.Assert.fail(cssSelector + " can't be located");
		}

	}

	/*
	 * ******************************************************************************
	 * Avoid the Element not found exception *
	 * **********************************
	 * *******************************************
	 */

	// Look for an element in a few tries (with counter)
	public void waitForElementToBeInvisible(WiniumDriver driver, By byType,
			int numAttempts) throws IOException, ParserConfigurationException,
			SAXException {

		int count = 0;
		Boolean isInvisible = false;
		while (count < numAttempts) {

			try {
				isInvisible = new FluentWait<WiniumDriver>(driver)
						.withTimeout(60, TimeUnit.SECONDS)
						.pollingEvery(5, TimeUnit.SECONDS)
						.ignoring(NoSuchElementException.class)
						.until(ExpectedConditions
								.invisibilityOfElementLocated(byType));

				if (isInvisible == true) {

					count = numAttempts;

				}

			}

			catch (Exception e) {
				count++;

			}

		}

		if (isInvisible == false) {
			StudioMethods genMeth = new StudioMethods();
			// str = new genData();
			String imageName = "Element isn't Invisible";
			genMeth.takeScreenShot(driver, genMeth, imageName);
			org.testng.Assert.fail("WebElement" + " is not Invisible");
		}

	}

	public void waitForElementToBeVisible(WiniumDriver driver, By By,
			int numAttempts) throws IOException, ParserConfigurationException,
			SAXException {

		StudioMethods genMeth = new StudioMethods();
		int count = 0;
		WebElement elementToBeVisible = null;
		while (count < numAttempts) {
			try {
				elementToBeVisible = new FluentWait<WiniumDriver>(driver)
						.withTimeout(60, TimeUnit.SECONDS)
						.pollingEvery(5, TimeUnit.SECONDS)
						.ignoring(NoSuchElementException.class)
						.until(ExpectedConditions.elementToBeClickable(By));

				if (elementToBeVisible != null) {

					count = numAttempts;

				}

			}

			catch (Exception e) {
				count++;
				// genMeth.takeScreenShot (driver, genMeth,
				// "Elelement not visible");
			}

		}

		if (elementToBeVisible == null) {
			String imageName = "Element isn't Visible";
			genMeth.takeScreenShot(driver, genMeth, imageName);
			org.testng.Assert.fail("WebElement" + " is not Visible");
		}

	}

	@SuppressWarnings("rawtypes")
	public WebElement fluentwait(WiniumDriver driver, final By byType) {
		Wait<WiniumDriver> wait = new FluentWait<WiniumDriver>(driver)

		.withTimeout(10, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);

		WebElement foo = (WebElement) wait
				.until(new Function<WiniumDriver, WebElement>() {
					public WebElement apply(WiniumDriver driver) {
						return (WebElement) driver.findElement(byType);
					}
				});

		wait.until(ExpectedConditions.elementToBeClickable(byType));

		return foo;
	}

	public void isElementInvisible(By By) throws ParserConfigurationException,
			SAXException, IOException {

		try {

			(new WebDriverWait(driver, 45)).until(ExpectedConditions
					.invisibilityOfElementLocated(By));

		}

		catch (Exception e) {

			StudioMethods genMeth = new StudioMethods();
			String imageName = " Element is visible";
			genMeth.takeScreenShot(driver, genMeth, imageName);
			org.testng.Assert.fail("WebElement" + " still visible");

		}

	}

	public void isElementVisible(By By) throws ParserConfigurationException,
			SAXException, IOException {

		try {

			// (new WebDriverWait(driver,
			// 20)).until(ExpectedConditions.visibilityOfElementLocated(by));
			new FluentWait<WiniumDriver>(driver)
					.withTimeout(30, TimeUnit.SECONDS)
					.pollingEvery(5, TimeUnit.SECONDS)
					.ignoring(NoSuchElementException.class)
					.until(ExpectedConditions.visibilityOfElementLocated(By));

		}

		catch (Exception e) {
			StudioMethods genMeth = new StudioMethods();
			String imageName = "Element is invisible";
			genMeth.takeScreenShot(driver, genMeth, imageName);
			org.testng.Assert.fail("WebElement" + " is not visible");

		}

	}

	public boolean checkIsElementVisible(By By)
			throws ParserConfigurationException, SAXException, IOException {

		boolean isWebElementVisible = false;
		WebElement element = null;
		try {

			// (new WebDriverWait(driver,
			// 20)).until(ExpectedConditions.visibilityOfElementLocated(by));
			element = new FluentWait<WiniumDriver>(driver)
					.withTimeout(5, TimeUnit.SECONDS)
					.pollingEvery(1, TimeUnit.SECONDS)
					.ignoring(NoSuchElementException.class)
					.until(ExpectedConditions.visibilityOfElementLocated(By));
			Thread.sleep(1000);

		}

		catch (Exception e) {

			// GenericMethods genMeth = new GenericMethods();
			// genData str = new genData();
			// String imageName = str.screenShotPath + " Element is invisible "
			// + genMeth.currentTime() + ".png";
			// genMeth.takeScreenShotNative(driver, imageName );
			// org.testng.Assert.fail("WebElement" + " is not visible");

		}
		if (element != null) {
			return isWebElementVisible = true;
		}

		else {
			return isWebElementVisible;

		}

	}

	public boolean fastCheckIsElementVisible(By By)
			throws ParserConfigurationException, SAXException, IOException {

		boolean isWebElementVisible = false;
		WebElement element = null;
		try {

			// (new WebDriverWait(driver,
			// 20)).until(ExpectedConditions.visibilityOfElementLocated(by));
			element = new FluentWait<WiniumDriver>(driver)
					.withTimeout(5, TimeUnit.SECONDS)
					.pollingEvery(1, TimeUnit.SECONDS)
					.ignoring(NoSuchElementException.class)
					.until(ExpectedConditions.visibilityOfElementLocated(By));

		}

		catch (Exception e) {

		}
		if (element != null) {
			return isWebElementVisible = true;
		}

		else {
			return isWebElementVisible;

		}

	}

	public void isElementInvisibleText(By By, String Text)
			throws ParserConfigurationException, SAXException, IOException {

		try {

			(new WebDriverWait(driver, 45)).until(ExpectedConditions
					.invisibilityOfElementWithText(By, Text));

		}

		catch (Exception e) {

			StudioMethods genMeth = new StudioMethods();
			// String imageName = genMeth.getValueFromPropFile(key) + text +
			// " still visible "
			// + genMeth.currentTime() + ".png";
			genMeth.takeScreenShot(driver, genMeth, Text);
			org.testng.Assert.fail(Text + " still visible");

		}

	}

	public final class SessionIdentifierGenerator {
		private SecureRandom random = new SecureRandom();

		public String nextSessionId() {

			return new BigInteger(130, random).toString(32);

		}

	};

	public int getRandomInt() {
		Random rand = new Random();
		int n = rand.nextInt(50) + 1;
		return n;
	}

	// Creates a Random string
	public String randomString() {

		String text;
		SessionIdentifierGenerator x = new SessionIdentifierGenerator();
		text = x.nextSessionId();
		return text;
	}

	// Create a string with current date
	public String currentDate() {

		String curDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		return curDate;
	}

	public String currentTime() {

		// String curDate = new
		// SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
		String curDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(new Date());

		return curDate;
	}

	public void rightClickElement(By by, StudioMethods genMeth)
			throws InterruptedException {

		Actions action = new Actions(driver);
		WebElement Element = genMeth.returnBy(genMeth, by);
		action.contextClick(Element).sendKeys(Keys.ARROW_DOWN).perform();

	}

	public void doubleClickElement(By by, StudioMethods genMeth)
			throws InterruptedException {

		Actions action = new Actions(driver);
		WebElement Element = genMeth.returnBy(genMeth, by);
		action.doubleClick(Element).perform();
	}

	public void pressF5(By by, StudioMethods genMeth)
			throws InterruptedException {

		Actions action = new Actions(driver);
		action.sendKeys(Keys.F5).perform();
	}

	public void sendIdF5(StudioMethods genMeth, String id, Keys f5)
			throws IOException {
		// TODO Auto-generated method stub
		try {

			WebElement myElement = genMeth.fluentwait(driver, By.id(id));
			myElement.sendKeys(f5);
		}

		catch (Exception e) {

			genMeth.takeScreenShot(driver, genMeth, id);
			org.testng.Assert.fail(id + "didn't displayed");

		}
	}

	public void refresh(StudioMethods genMeth) throws InterruptedException,
			IOException {

		genMeth.rightClickElement(By.id(sgData.BtnSGISRootTextBlock), genMeth);
		genMeth.clickName(genMeth, "Refresh");
		Thread.sleep(5000);

	}

	
	public void createGoldenAutomation(StudioMethods genMeth) throws InterruptedException, IOException{

		//Create Golden App Automation
		//genMeth.rightClickElement(By.name("Applications"), genMeth);
		genMeth.rightClickElement(By.id("ApplicationsTreeViewTextBlock"), genMeth);

		//genMeth.clickName(genMeth, "New Application");
		genMeth.clickId(genMeth, "NewApp");

		//Create a new app & save it
		genMeth.sendId(genMeth, sgData.TextFieldApplicationName_ID, sgData.GoldenAppAuto);		
		genMeth.clickId(genMeth, sgData.BtnSave);
		genMeth.clickId(genMeth, sgData.BtnCloseTabItem);

	}
	
	
	public void clickComboBox(StudioMethods genMeth, By byCombo, By byLocator) throws InterruptedException{

		//This method will open a combo, scroll to the specific element & click it
		ComboBox combo;
		WebElement el = genMeth.returnBy(genMeth, byCombo);
		combo = WebElementExtensions.toComboBox(el);
		combo.expand();
		combo.findElement(byLocator).click();
		//combo.scrollTo(byLocator).click();
	
	}
	
	
	public void listBox(StudioMethods genMeth, By by, By byClickElement) throws InterruptedException{

		//This method will open a combo, scroll to the specific element & click it
		ListBox list;
		WebElement el = genMeth.returnBy(genMeth, by);
		list = WebElementExtensions.toListBox(el);
		list.scrollTo(byClickElement);
	}
		
	
	/*
	 * public void locationServicesHadle(IosMethods genMeth) throws
	 * ParserConfigurationException, SAXException, IOException,
	 * InterruptedException { boolean isLocationDisplay =
	 * genMeth.checkIsElementVisible(By .name("Allow")); if (isLocationDisplay)
	 * {
	 * 
	 * genMeth.clickName(genMeth, "Allow"); }
	 * 
	 * }
	 * 
	 * public void accessToContactsHandle(IosMethods genMeth) throws
	 * ParserConfigurationException, SAXException, IOException,
	 * InterruptedException { boolean isLocationDisplay =
	 * genMeth.checkIsElementVisible(By.name(iosData.CameraPemissions_ID));
	 * boolean isLocationDisplay = genMeth
	 * .checkIsElementVisible(By.name("OK"));
	 * 
	 * if (isLocationDisplay) {
	 * 
	 * genMeth.clickName(genMeth, "OK"); }
	 * 
	 * }
	 */
	/*
	 * public void accessToCameraHandle(IosMethods genMeth) throws
	 * ParserConfigurationException, SAXException, IOException,
	 * InterruptedException { // boolean accessToCamera = //
	 * genMeth.checkIsElementVisible(By.name(iosData.CameraPemissions_ID));
	 * boolean accessToCamera = genMeth.checkIsElementVisible(By
	 * .name("Don't Allow"));
	 * 
	 * if (accessToCamera) {
	 * 
	 * genMeth.clickName(genMeth, iosData.BTNokName); }
	 * 
	 * }
	 * 
	 * public void sendNotificationHandle(IosMethods genMeth) throws
	 * ParserConfigurationException, SAXException, IOException,
	 * InterruptedException { // boolean isLocationDisplay = //
	 * genMeth.checkIsElementVisible(By.name(iosData.CameraPemissions_ID));
	 * boolean isLocationDisplay = genMeth
	 * .checkIsElementVisible(By.name("OK"));
	 * 
	 * if (isLocationDisplay) {
	 * 
	 * genMeth.clickName(genMeth, "OK"); }
	 * 
	 * }
	 * 
	 * public void openStratupScreen(StudioMethods genMeth, StudioElements
	 * sgData) throws ParserConfigurationException, SAXException, IOException,
	 * InterruptedException{
	 * 
	 * 
	 * // boolean isStartupScreenDisplay =
	 * genMeth.checkIsElementVisible(By.name(iosData.Appium_Startup));
	 * 
	 * boolean isStartupScreenDisplay =
	 * genMeth.checkIsElementVisible(By.name("Applications"));
	 * 
	 * if (isStartupScreenDisplay != true ) {
	 * 
	 * 
	 * }
	 * 
	 * } // public void changeConnectionType(String mode) { // //
	 * NetworkConnection mobileDriver = (NetworkConnection) driver; // if (mode
	 * == "AIRPLANE_MODE") { // //
	 * mobileDriver.setNetworkConnection(NetworkConnection
	 * .ConnectionType.AIRPLANE_MODE); // } // // else if (mode == "WIFI") { //
	 * //
	 * mobileDriver.setNetworkConnection(NetworkConnection.ConnectionType.WIFI);
	 * // // } // // else if (mode == "DATA") { // //
	 * mobileDriver.setNetworkConnection(NetworkConnection.ConnectionType.DATA);
	 * // // } // // else if (mode == "ALL") { // //
	 * mobileDriver.setNetworkConnection(NetworkConnection.ConnectionType.ALL);
	 * // // } // // } // /* public void setAirplainMode() {
	 * 
	 * driver.setNetworkConnection(new NetworkConnectionSetting(true, false,
	 * false));
	 * 
	 * }
	 * 
	 * public void setWifiOn() {
	 * 
	 * driver.setNetworkConnection(new NetworkConnectionSetting(false, true,
	 * false));
	 * 
	 * }
	 * 
	 * public void pressHomeButton() { int Home = AndroidKeyCode.HOME;
	 * driver.sendKeyEvent(Home);
	 * 
	 * }
	 * 
	 * public void pressBackButton() { int Back = AndroidKeyCode.BACK;
	 * driver.sendKeyEvent(Back);
	 * 
	 * }
	 * 
	 * public void pressEnter() { int Enter = AndroidKeyCode.ENTER;
	 * driver.sendKeyEvent(Enter);
	 * 
	 * }
	 */

}
