
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.winium.WiniumDriver;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.xml.sax.SAXException;

import winium.elements.desktop.ComboBox;
import winium.elements.desktop.ListBox;
import winium.elements.desktop.extensions.WebElementExtensions;

import com.applitools.eyes.Eyes;



public class SanityTestStudio {

	WiniumDriver  driver;

	StudioElements sgData;
	StudioMethods genMeth = new StudioMethods();
	Eyes eyes = new Eyes();
	Boolean useEye = true;
	String webElementXmlPath;
	String webElementXmlLang;
	
	@BeforeSuite(alwaysRun = true)
	public void setupBeforeSuite(ITestContext context) throws ParserConfigurationException, SAXException, IOException, InterruptedException, jdk.internal.org.xml.sax.SAXException {
		
		webElementXmlPath = genMeth.getValueFromPropFile("webElementXmlPath");
		webElementXmlLang = genMeth.getValueFromPropFile("webElementXmlLang");
		
		sgData = genMeth.setElements(webElementXmlPath, webElementXmlLang);
		driver = genMeth.setDesktopOptions(genMeth);
		
		genMeth.cleanLogin(genMeth);
		Thread.sleep(6000);		
		
		// Create golden automation app if not exist
		boolean goldenAppExist = genMeth.checkIsElementVisible(By.name(sgData.GoldenAppAuto));
		if (goldenAppExist == !true) {

			genMeth.createGoldenAutomation(genMeth);
			genMeth.refresh(genMeth);
			Thread.sleep(6000);		
		}

	}
	@BeforeMethod (alwaysRun = true)
	public void checkHomeScreen() throws InterruptedException, IOException, ParserConfigurationException, SAXException, jdk.internal.org.xml.sax.SAXException{


		// Check if the client still logged in & in StartUp screen before each test
			boolean StartUpScreenDisplay = genMeth.checkIsElementVisible( By.name(sgData.GoldenAppAuto));
			boolean UpperTabsAreOpen = genMeth.checkIsElementVisible( By.id(sgData.BtnCloseTabItem));

			if (StartUpScreenDisplay != true || UpperTabsAreOpen == true) {
				
				driver.quit();
				driver = genMeth.setDesktopOptions(genMeth);
				genMeth.cleanLogin(genMeth);
				Thread.sleep(6000);
		

			}
			
		}


	@Test (enabled = true ,testName = "", description = "" ,
			groups= {"Sanity Studio2"}  /*dependsOnMethods={"testLogin"}*/)	

	public void CreateGoldenAppWithURL() throws ParserConfigurationException,
			SAXException, IOException, InterruptedException {

		//genMeth.eyesCheckWindow(eyes, "Login Screen", useEye);

		//Open app
		genMeth.refresh(genMeth);
		Thread.sleep(6000);
		genMeth.rightClickElement(By.name(sgData.GoldenAppAuto), genMeth);
		genMeth.clickId(genMeth, sgData.BtnEditApplication);
		
		//Create DI_service calls 4
		genMeth.clickId(genMeth, sgData.TabItemDataItems);
		genMeth.clickId(genMeth, sgData.BtnAddDataItem);
		genMeth.sendId(genMeth, sgData.TextFieldDataItemName, "DI_service calls 4");
		genMeth.sendId(genMeth, sgData.TextFieldDataItemDescription, "DI_service calls 4");

		//Add Query
		genMeth.clickId(genMeth, sgData.TabItemQuery);
		genMeth.sendId(genMeth, sgData.TextFieldQuery, "SELECT  *,  'Gauge'  =  50 from [dbo].[TBL_ServiceCalls]");
		genMeth.clickId(genMeth, sgData.BtnSave);
		Thread.sleep(3000);
		
		//Close upper Tabs
//		genMeth.clickId(genMeth, sgData.BtnCancel);
//		genMeth.clickId(genMeth, sgData.BtnCancel);

		//Create "URL" Report
		genMeth.clickId(genMeth, sgData.TabItemReports);
		genMeth.clickId(genMeth, sgData.BtnAddReport);
		
		// Set Report Icon
		genMeth.clickId(genMeth, sgData.BtnReportIcon);
		genMeth.clickId(genMeth, "#FFBB803B");
		genMeth.clickId(genMeth, "e92d");
				
		genMeth.sendId(genMeth, sgData.TextFieldReportName, "URL");
		genMeth.sendId(genMeth, sgData.ComboDropdowReportFolder, "All Tabs");
		genMeth.clickId(genMeth, sgData.ComboDropdowReportFolder);
		//genMeth.sendId(genMeth, sgData.TextFieldReportDescription, "All Tabs Report Description");

		genMeth.clickId(genMeth, sgData.BtnReportIcon);

		genMeth.clickId(genMeth, sgData.BtnSave);


		//Create URL Tab (Constant)
		genMeth.clickId(genMeth, sgData.TabItemTabs);
		genMeth.clickId(genMeth, sgData.BtnAddTabButton);
		genMeth.clickName(genMeth, "New Tab - URL");
		genMeth.clickId(genMeth, sgData.RDBCustomNameRB);
		genMeth.sendId(genMeth, sgData.TextFieldTabName, "URL Constant");
		
		genMeth.clickId(genMeth, sgData.URLTabItem);
		genMeth.sendId(genMeth, "SgTextBox", "http://www.milliondollarhomepage.com/");
		genMeth.clickId(genMeth, sgData.BtnSave);
		Thread.sleep(4000);
		genMeth.clickId(genMeth, sgData.BtnCancel);
		genMeth.clickId(genMeth, sgData.BtnCancel);
		genMeth.clickId(genMeth, sgData.BtnCancel);
		
		
		//Create URL tab (Data)
		genMeth.doubleClickElement(By.name(sgData.GoldenAppAuto), genMeth);
		genMeth.doubleClickElement(By.name("Reports"), genMeth);

		genMeth.rightClickElement(By.name("URL"), genMeth);
		genMeth.clickName(genMeth, "Edit");
		genMeth.clickId(genMeth, sgData.TabItemTabs);
		genMeth.clickId(genMeth, sgData.BtnAddTabButton);
		genMeth.clickName(genMeth, "New Tab - URL");

		genMeth.clickId(genMeth, sgData.RDBCustomNameRB);
		genMeth.sendId(genMeth, sgData.TextFieldTabName, "URL Data Item");
		genMeth.clickId(genMeth, sgData.URLTabItem);
		
		genMeth.clickId(genMeth, sgData.RDBDataItem);
		
		genMeth.clickId(genMeth, sgData.ComboDataItemsCMB);
		genMeth.clickId(genMeth, "DI_service calls 4");
		genMeth.clickId(genMeth, sgData.ComboComboSourceColumn);
		genMeth.clickName(genMeth, "KPI");
		genMeth.clickId(genMeth, "ComboSourceColumn");
		genMeth.clickName(genMeth, "ItemID");
		genMeth.clickId(genMeth, "ComboSourceColumn");
		genMeth.clickName(genMeth, "Phone");
		genMeth.clickId(genMeth, "ComboSourceColumn");
		genMeth.clickName(genMeth, "URL");
		genMeth.clickId(genMeth, sgData.BtnSave);

		Thread.sleep(5000);

		genMeth.clickId(genMeth, sgData.BtnCancel);
		genMeth.clickId(genMeth, sgData.BtnCancel);
		
	}

	
	@Test(enabled = true, testName = "", description = "", groups = { "Sanity Studio" } /*dependsOnMethods = {"testLogin"}*/)
																						 
																				
	public void CreateMap() throws ParserConfigurationException, SAXException,
			IOException, InterruptedException {

		genMeth.refresh(genMeth);
		// Create DI for map
		genMeth.doubleClickElement(By.name(sgData.GoldenAppAuto), genMeth);
		genMeth.rightClickElement(By.name("Data Items"), genMeth);
		genMeth.clickId(genMeth, sgData.BtnNewDataItemApplication);
		genMeth.sendId(genMeth, sgData.TextFieldDataItemName,"Branches Address/GPS");
		genMeth.sendId(genMeth, sgData.TextFieldDataItemDescription,"Branches Address/GPS");

		// Add Query
		genMeth.clickId(genMeth, sgData.TabItemQuery);
		genMeth.sendId(genMeth, sgData.TextFieldQuery,"SELECT * from [dbo].[TBL_Branches]");
		genMeth.clickId(genMeth, sgData.BtnSave );

		// Close upper Tabs
		genMeth.clickId(genMeth, sgData.BtnCancel);
		
		// Create "Map" Report from LSM
		genMeth.rightClickElement(By.name("Reports"), genMeth);
		genMeth.clickId(genMeth, sgData.BtnNewReport);
		genMeth.sendId(genMeth, "TextFieldReportName", "Map");
		genMeth.sendId(genMeth, "TextFieldReportFolder", "All Tabs");
		genMeth.sendId(genMeth, sgData.TextFieldReportDescription,"All Tabs Report");
		
		// genMeth.clickId(genMeth, sgData.BtnReportIcon);
		genMeth.clickId(genMeth, sgData.BtnSave);
		genMeth.clickId(genMeth, sgData.BtnCloseTabItem);

		// Create Tab - Map by address 
		genMeth.doubleClickElement(By.name("Reports"), genMeth);
		genMeth.doubleClickElement(By.name("Map"), genMeth);

		genMeth.rightClickElement(By.name("Tabs"), genMeth);
		genMeth.clickName(genMeth, "New Tab - Map");
		genMeth.clickId(genMeth, sgData.RDBCustomNameRB);
		genMeth.sendId(genMeth, sgData.TextFieldTabName, "Map By GPS");
		
		//Set DI 
		genMeth.clickId(genMeth, sgData.TabItemDataItems);
		genMeth.clickId(genMeth, sgData.ComboDataItemsCMB);
		genMeth.clickId(genMeth, "Branches Address/GPS");


		//Configure the map columns
		genMeth.clickId(genMeth, sgData.MapTabItem);
		//genMeth.clickId(genMeth, sgData.RDBGpsLocationRB);
		genMeth.clickId(genMeth, "GpsLocationRb");

		
		genMeth.clickId(genMeth, "AddressColumnCB");
		genMeth.clickId(genMeth, "Branch Long Lat");
		genMeth.clickId(genMeth, "SubjectColumnCB");
		genMeth.clickId(genMeth, "Branch Name");

	}


	@Test(enabled = true, testName = "", description = "", groups = { "Sanity Studio1" } /*dependsOnMethods = {"testLogin"}*/)
	 
	
	public void List() throws ParserConfigurationException, SAXException,
			IOException, InterruptedException {

		genMeth.refresh(genMeth);
		// Create DI for List tab
		genMeth.doubleClickElement(By.name(sgData.GoldenAppAuto), genMeth);
		genMeth.doubleClickElement(By.name("Data Items"), genMeth);
		
		//Check if DI was created
		boolean isDIDisplayed = genMeth.checkIsElementVisible(By.name("DI_service calls 1"));
		
		if(isDIDisplayed != true){
			
			genMeth.rightClickElement(By.name("Data Items"), genMeth);
			genMeth.clickId(genMeth, "BtnNew Data Item");
			genMeth.sendId(genMeth, sgData.TextFieldDataItemName,"DI_service calls 1");
			genMeth.sendId(genMeth, sgData.TextFieldDataItemDescription,"DI_service calls 1");

			// Add Query
			genMeth.clickId(genMeth, sgData.TabItemQuery);
			genMeth.sendId(genMeth, sgData.TextFieldQuery,"SELECT * from [dbo].[TBL_ServiceCalls]");
			genMeth.clickId(genMeth, sgData.BtnSave );

			// Close upper Tabs
			genMeth.clickId(genMeth, sgData.BtnCloseTabItem);

		}
		
		//Check if Report was created
		genMeth.doubleClickElement(By.name("Reports"), genMeth);

		isDIDisplayed = genMeth.checkIsElementVisible(By.name("List / Grid"));
		if (isDIDisplayed != true) {
			// Create "List / Grid" Report from LSM
			genMeth.rightClickElement(By.name("Reports"), genMeth);
			genMeth.clickId(genMeth, sgData.BtnNewReport);
			genMeth.sendId(genMeth, "TextFieldReportName", "List / Grid");
			genMeth.sendId(genMeth, sgData.ComboDropdowReportFolder, "All Tabs");
			genMeth.sendId(genMeth, sgData.TextFieldReportDescription,"All Tabs Report");
			genMeth.clickId(genMeth, sgData.BtnReportIcon);
			genMeth.clickId(genMeth, "e92d");
			genMeth.clickId(genMeth, "#FFB95DFF");

			// genMeth.clickId(genMeth, sgData.BtnReportIcon);
			genMeth.clickId(genMeth, sgData.BtnSave);
			Thread.sleep(5000);
			genMeth.clickId(genMeth, sgData.BtnCloseTabItem);
			
		}
		
		
		// Create List Tab
		genMeth.doubleClickElement(By.name("List / Grid"), genMeth);
		genMeth.doubleClickElement(By.name("Tabs"), genMeth);

		// Create "List / Grid" Report from LSM
		genMeth.rightClickElement(By.name("Tabs"), genMeth);
		genMeth.clickId(genMeth, "BtnNew Tab - List");
		genMeth.clickId(genMeth, sgData.RDBCustomNameRB);
		genMeth.sendId(genMeth, sgData.TextFieldTabName, "List");

		genMeth.clickId(genMeth, sgData.TabItemDataItems);

		//Set DI 
		genMeth.clickId(genMeth, sgData.TabItemDataItems);
		genMeth.clickComboBox(genMeth, By.id(sgData.ComboDataItemsCMB), By.id("DI_service calls 1"));
		
		//save & Close the tab
		genMeth.clickId(genMeth, sgData.BtnSave);
		genMeth.clickId(genMeth, sgData.BtnRefresh);
		genMeth.clickId(genMeth, sgData.BtnCloseTabItem);
		
		//reopen the tab
		genMeth.doubleClickElement(By.name("List"), genMeth);
		genMeth.clickId(genMeth, sgData.TabItemColumns);

		//Configure the advanced columns
		//Jump to slicer report (need to create the slicer report test first)
		/*
		genMeth.clickId(genMeth, "Jump to report");
		genMeth.clickId(genMeth, "Jump to report");
		*/
		
		
		genMeth.clickId(genMeth, "Branch ID");
		genMeth.sendId(genMeth, sgData.TextFieldFriendlyName, "BranchID-Not Primary");
		genMeth.clickId(genMeth, sgData.PrimaryToogleButton);
		
		
		genMeth.clickId(genMeth, "Open Date");
		genMeth.clickId(genMeth, sgData.ExpenderFormat);
		genMeth.clickComboBox(genMeth, By.id(sgData.ComboFormatsCMB), By.id("MMM-dd-yyyy"));
		
		genMeth.clickId(genMeth, sgData.PageLeft);

		genMeth.clickId(genMeth, "Icon");
		genMeth.clickId(genMeth, sgData.ExpenderAdvanced);
		genMeth.clickComboBox(genMeth, By.id("AdvancedColumnTypeCMB"), By.id("IconSet"));
		
		
	}


	
	@Test (enabled = true ,testName = "", description = "" ,
			groups= {"Sanity Studio"}  /*dependsOnMethods={"testLogin"}*/)	

	public void ApplicationTesting() throws ParserConfigurationException,
			SAXException, IOException, InterruptedException {

//		genMeth.eyesCheckWindow(eyes, "Login Screen", useEye);
		
		//Create a new app with empty name
		genMeth.rightClickElement(By.name(sgData.BtnLsmApplicationsName), genMeth);
		genMeth.clickName(genMeth, "New Application");
		genMeth.clickId(genMeth, sgData.BtnSave);
		genMeth.clickId(genMeth, sgData.BtnX);
//		genMeth.eyesCheckWindow(eyes, "SG Studio - Application testing", useEye);


		//Create a new app & save it
		genMeth.sendId(genMeth, sgData.TextFieldApplicationName_ID, "Test app 1");		
		genMeth.clickId(genMeth, sgData.BtnSave);
		
		//Add description
		genMeth.sendId(genMeth, sgData.TextFieldApplicationDescription, "This is test app 1");
		
		//Add Application Icon & color & save
		genMeth.clickId(genMeth, sgData.BtnApplicationIcon);
		
		//choose blue color
		genMeth.clickId(genMeth, "#FF57DBB8");
		//Change app icon
		genMeth.clickId(genMeth, "e92d");
		
//		genMeth.eyesCheckWindow(eyes, "SG Studio - Application testing- App icon & color", useEye);
		

		
		//Refresh the screen
		genMeth.clickId(genMeth, sgData.BtnRefresh);
//		genMeth.eyesCheckWindow(eyes, "SG Studio - Application testing- App icon & color", useEye);
		genMeth.clickId(genMeth, sgData.BtnSave);

		
		
		//Delete name & attempt to save
		genMeth.clearId(genMeth, sgData.TextFieldApplicationName_ID);
		genMeth.clickId(genMeth, sgData.BtnSave);
		genMeth.clickId(genMeth, sgData.BtnX);
		
		//Close the app & reopen
		genMeth.clickId(genMeth, sgData.BtnCancel);
		

		//Edit the App
		genMeth.rightClickElement(By.name("Test app 1"), genMeth);
		genMeth.clickId(genMeth, sgData.BtnEditApplication);
		
		//Change app name
		genMeth.sendId(genMeth, sgData.TextFieldApplicationName_ID, "Test app 1- edit");
		//Close without save
		genMeth.clickId(genMeth, sgData.BtnCancel);
		
		//reopen the app make sure that the changes without save were not saved
		genMeth.rightClickElement(By.name("Test app 1"), genMeth);
		genMeth.clickId(genMeth, sgData.BtnEditApplication);
		
		
		//Now edit the name & save it making sure the name was saved successfully 
		genMeth.sendId(genMeth, sgData.TextFieldApplicationName_ID, "Test app 1- edit");
		genMeth.clickId(genMeth, sgData.BtnSave);
		genMeth.clickId(genMeth, sgData.BtnCloseTabItem);
		
		genMeth.rightClickElement(By.name("Test app 1- edit"), genMeth);
		genMeth.clickId(genMeth, sgData.BtnEditApplication);
		
		//Add A new DI
		genMeth.clickId(genMeth, sgData.TabItemDataItems);
		genMeth.clickId(genMeth, sgData.BtnAddDataItem);

		genMeth.sendId(genMeth, sgData.TextFieldDataItemName, "Di Service Calls");
		genMeth.clickId(genMeth,sgData.TabItemQuery);
		genMeth.sendId(genMeth, sgData.TextFieldQuery, sgData.DIserviceCallsDemo);
		genMeth.clickId(genMeth, sgData.BtnSave);
//		genMeth.clickId(genMeth, sgData.BtnCancel);

		//Add a sample report
		genMeth.clickId(genMeth, sgData.TabItemReports);
		genMeth.clickId(genMeth, sgData.BtnAddReport);
		
		genMeth.sendId(genMeth, sgData.TextFieldReportName, "Rep1");
		genMeth.clickId(genMeth, sgData.BtnSave);
		

		//Add tab
		genMeth.clickId(genMeth, sgData.TabItemTabs);
		genMeth.clickId(genMeth, sgData.BtnAddTabButton);
		genMeth.clickName(genMeth, "New Tab - List");
		genMeth.clickId(genMeth, sgData.BtnSave);
		genMeth.clickId(genMeth, sgData.BtnCancel);
		genMeth.clickId(genMeth, sgData.BtnCancel);
		genMeth.clickId(genMeth, sgData.BtnCancel);
				
		//Publish the application
		
		
		//Publish the app
		genMeth.rightClickElement(By.name("Test app 1- edit"), genMeth);
		genMeth.clickId(genMeth, sgData.BtnPublishApplication);
		genMeth.clickId(genMeth, sgData.BtnCloseTabItem);

		//Make sure that the publish finished successfully
		
		//Delete the app while screen is open
		genMeth.rightClickElement(By.name("Test app 1- edit"), genMeth);
		genMeth.clickId(genMeth, sgData.BtnDeleteApplication);
		genMeth.clickId(genMeth, sgData.BtnCancellationButton);
		
		genMeth.rightClickElement(By.name("Test app 1- edit"), genMeth);
		genMeth.clickId(genMeth, sgData.BtnDeleteApplication);
		genMeth.clickId(genMeth, sgData.BtnApprovalButton);
		genMeth.refresh(genMeth);
		boolean isAppDisplay = genMeth.checkIsElementVisible(By.name("Test app 1- edit"));

		if (isAppDisplay) {

			org.testng.Assert.fail("Test app 1- edit" + " still visible");
		}

		
		
		
	}
}
