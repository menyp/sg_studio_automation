
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.winium.WiniumDriver;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.By;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.xml.sax.SAXException;

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
		//boolean goldenAppExist = genMeth.checkIsElementVisible(By.id("ApplicationGolden App AutoTreeViewItem"));

		
		if (goldenAppExist != true) {

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

	@Test(priority = 0, groups = { "Sanity Studio1" } ,enabled = true, testName = "URL Tab")
	public void CreateURLTab() throws ParserConfigurationException,
			SAXException, IOException, InterruptedException {

		//genMeth.eyesCheckWindow(eyes, "Login Screen", useEye);
		genMeth.refresh(genMeth);

		genMeth.doubleClickElement(By.name(sgData.GoldenAppAuto), genMeth);
		genMeth.doubleClickElement(By.id(sgData.LsmDataItems), genMeth);

			//Create DI_service calls 4
			genMeth.rightClickElement(By.name(sgData.GoldenAppAuto), genMeth);
			genMeth.clickId(genMeth, sgData.BtnEdit);

			genMeth.clickId(genMeth, sgData.TabItemDataItems);
			genMeth.clickId(genMeth, sgData.BtnAddDataItem);
			genMeth.sendId(genMeth, sgData.TextFieldDataItemName, "DI_service calls 4");
			genMeth.sendId(genMeth, sgData.TextFieldDataItemDescription, "DI_service calls 4");

			//Add Query
			genMeth.clickId(genMeth, sgData.TabItemQuery);
			genMeth.sendId(genMeth, sgData.TextFieldQuery, "SELECT  *,  'Gauge'  =  50 from [dbo].[TBL_ServiceCalls]");
			genMeth.clickId(genMeth, sgData.BtnSave);
			Thread.sleep(3000);
			genMeth.clickId(genMeth, sgData.BtnCloseTabItem);
			genMeth.clickId(genMeth, sgData.BtnCloseTabItem);
		
		genMeth.doubleClickElement(By.name("Reports"), genMeth);

			//Create "URL / News" Report from application screen
			genMeth.refresh(genMeth);
			Thread.sleep(2000);
			genMeth.rightClickElement(By.name(sgData.GoldenAppAuto), genMeth);
			genMeth.clickId(genMeth, sgData.BtnEdit);

			genMeth.clickId(genMeth, sgData.TabItemReports);
			genMeth.clickId(genMeth, sgData.BtnAddReport);
			
			// Set Report Icon (waiting for automation id)
			genMeth.clickId(genMeth, sgData.BtnReportIcon);
		//	genMeth.clickId(genMeth, "#FFBB803B");
			genMeth.clickId(genMeth, "e92d");
					
			genMeth.sendId(genMeth, sgData.TextFieldReportName, "URL / News");
			genMeth.sendId(genMeth, sgData.ComboDropdowReportFolder, "All Tabs");
			genMeth.clickId(genMeth, sgData.ComboDropdowReportFolder);
			//genMeth.sendId(genMeth, sgData.TextFieldReportDescription, "All Tabs Report Description");

			genMeth.clickId(genMeth, sgData.BtnReportIcon);

			genMeth.clickId(genMeth, sgData.BtnSave);		

		//Create URL Tab (URL source = Constant)
		genMeth.clickId(genMeth, sgData.TabItemTabs);
		genMeth.clickId(genMeth, sgData.BtnAddTabButton);
		genMeth.clickId(genMeth, "BtnAddURLTabButton");
		genMeth.clickId(genMeth, sgData.RDBCustomNameRB);
		genMeth.sendId(genMeth, sgData.TextFieldTabName, "URL Constant");
		
		genMeth.clickId(genMeth, sgData.URLTabItem);
		genMeth.sendId(genMeth, "SgTextBox", "http://www.milliondollarhomepage.com/");
		genMeth.clickId(genMeth, sgData.BtnSave);
		Thread.sleep(4000);
		genMeth.clickId(genMeth, sgData.BtnCancel);
		genMeth.clickId(genMeth, sgData.BtnCloseTabItem);
		genMeth.clickId(genMeth, sgData.BtnCloseTabItem);
		
		
		//Create URL tab (URL source = Data item)
		genMeth.doubleClickElement(By.name(sgData.GoldenAppAuto), genMeth);
		//genMeth.doubleClickElement(By.id(sgData.LsmReports), genMeth);
		genMeth.doubleClickElement(By.name("Reports"), genMeth);

		genMeth.rightClickElement(By.name("URL / News"), genMeth);
		genMeth.clickId(genMeth,sgData.BtnEdit);
		genMeth.clickId(genMeth, sgData.TabItemTabs);
		genMeth.clickId(genMeth, sgData.BtnAddTabButton);
		genMeth.clickName(genMeth, "New Tab - URL");		
		
		genMeth.clickId(genMeth, sgData.RDBCustomNameRB);
		genMeth.sendId(genMeth, sgData.TextFieldTabName, "URL Data Item");
		genMeth.clickId(genMeth, sgData.URLTabItem);
		
		genMeth.clickId(genMeth, sgData.RDBDataItem);
		
		genMeth.clickId(genMeth, sgData.ComboDataItemsCMB);
		genMeth.clickComboBox(genMeth, By.id(sgData.ComboDataItemsCMB), By.id("DI_service calls 4"));
		
		genMeth.clickComboBox(genMeth, By.id(sgData.ComboComboSourceColumn), By.name("UpdateDate"));
		genMeth.clickComboBox(genMeth, By.id(sgData.ComboComboSourceColumn), By.name("URL"));
		genMeth.clickId(genMeth, sgData.BtnSave);
		Thread.sleep(2000);
		genMeth.clickId(genMeth, sgData.BtnCloseTabItem);
		genMeth.clickId(genMeth, sgData.BtnCloseTabItem);
		

	}

	@Test(priority = 3, groups = { "Sanity Studio1" } ,enabled = true, testName = "URL Tab")
	public void CreateNews() throws ParserConfigurationException,
			SAXException, IOException, InterruptedException {

		//genMeth.eyesCheckWindow(eyes, "Login Screen", useEye);
		genMeth.refresh(genMeth);

		genMeth.doubleClickElement(By.name(sgData.GoldenAppAuto), genMeth);
		genMeth.doubleClickElement(By.id(sgData.LsmDataItems), genMeth);

			//Create DI News
			genMeth.rightClickElement(By.name(sgData.GoldenAppAuto), genMeth);
			genMeth.clickId(genMeth, sgData.BtnEdit);
			genMeth.clickId(genMeth, sgData.TabItemDataItems);
			genMeth.clickId(genMeth, sgData.BtnAddDataItem);
			genMeth.sendId(genMeth, sgData.TextFieldDataItemName, "News");
			genMeth.sendId(genMeth, sgData.TextFieldDataItemDescription, "News DI");
			//Add Query
			genMeth.clickId(genMeth, sgData.TabItemQuery);
			genMeth.sendId(genMeth, sgData.TextFieldQuery, "SELECT * from [dbo].[TBL_News]");
			genMeth.clickId(genMeth, sgData.BtnSave);
			Thread.sleep(3000);
			genMeth.clickId(genMeth, sgData.BtnCloseTabItem);
			genMeth.clickId(genMeth, sgData.BtnCloseTabItem);
		
			
			//Create News tab
			genMeth.refresh(genMeth);
			genMeth.doubleClickElement(By.name(sgData.GoldenAppAuto), genMeth);
			genMeth.doubleClickElement(By.name("Reports"), genMeth);
			genMeth.doubleClickElement(By.name("URL / News"), genMeth);
			genMeth.rightClickElement(By.name("Tabs"), genMeth);
			genMeth.clickId(genMeth, "BtnNew Tab - News");
			genMeth.clickId(genMeth, sgData.RDBCustomNameRB);
			genMeth.sendId(genMeth, sgData.TextFieldTabName, "News");
			genMeth.clickId(genMeth, sgData.TabItemDataItem);
			genMeth.clickComboBox(genMeth, By.id("DropdownNewsDataItem"), By.id("News"));
			genMeth.clickId(genMeth, "ColumnsTabItem");
			genMeth.clickComboBox(genMeth, By.id("DropdownNewsCategorySourceColumns"), By.id("Category"));

			//Get values
			genMeth.clickId(genMeth, "BtnGetCategoriesValues");
			//Delete Values
			genMeth.clickId(genMeth, "BtnDeleteCategorySoccer");
			genMeth.clickId(genMeth, "BtnDeleteCategoryOther");
			genMeth.clickId(genMeth, "BtnDeleteCategoryThe Million Dollar Page");
			
			//Add Values
			genMeth.clickId(genMeth, "BtnAddCagegory");
			genMeth.sendId(genMeth, "SgTextBox", "Soccer");
			
			genMeth.clickId(genMeth, "BtnAddCagegory");
			genMeth.sendId(genMeth, "SgTextBox", "Other");
			genMeth.clickId(genMeth, "E90D");
			genMeth.clickId(genMeth, "E900");

			genMeth.clickId(genMeth, "BtnAddCagegory");
			genMeth.sendId(genMeth, "SgTextBox", "The Million Dollar Page");
			genMeth.clickId(genMeth, "E90D");
			genMeth.clickId(genMeth, "E90E");
			
			genMeth.clickId(genMeth, "BtnAddCagegory");

			
			

			
					
			
	}


	
	@Test(priority = 1, groups = { "Sanity Studio1" }, enabled = true, testName = "Map tab")
																						 
																				
	public void CreateMap() throws ParserConfigurationException, SAXException,
			IOException, InterruptedException {

		genMeth.refresh(genMeth);
		
		// Create DI for map
		genMeth.doubleClickElement(By.name(sgData.GoldenAppAuto), genMeth);
		genMeth.rightClickElement(By.name("Data Items"), genMeth);
	//	genMeth.rightClickElement(By.id("DataItemsTreeViewItem"), genMeth);
		genMeth.clickId(genMeth, sgData.BtnNewDataItem);
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
		//genMeth.rightClickElement(By.id(sgData.LsmReports), genMeth);
		genMeth.clickId(genMeth, sgData.BtnNewReport);
		genMeth.sendId(genMeth, "TextFieldReportName", "Map");
		//genMeth.sendId(genMeth, sgData.TextFieldReportName, "Map");

		genMeth.sendId(genMeth, sgData.ComboReportFolder, "All Tabs");
		genMeth.sendId(genMeth, sgData.TextFieldReportDescription,"All Tabs Report");
		
		// genMeth.clickId(genMeth, sgData.BtnReportIcon);
		genMeth.clickId(genMeth, sgData.BtnSave);
		genMeth.clickId(genMeth, sgData.BtnCloseTabItem);

		// Create Tab - Map by Address 
		genMeth.doubleClickElement(By.name("Reports"), genMeth);
		//genMeth.doubleClickElement(By.id(sgData.LsmReports), genMeth);
		genMeth.doubleClickElement(By.name("Map"), genMeth);

		genMeth.rightClickElement(By.name("Tabs"), genMeth);
		//genMeth.rightClickElement(By.id(sgData.LsmTabsTreeViewItem), genMeth);
		genMeth.clickName(genMeth, "New Tab - Map");
		genMeth.clickId(genMeth, sgData.RDBCustomNameRB);
		genMeth.sendId(genMeth, sgData.TextFieldTabName, "Map By Address");
		
		//Set DI 	
		genMeth.clickId(genMeth, sgData.TabItemDataItem);
		genMeth.clickComboBox(genMeth, By.id("DropdownDataItem"), By.id("Branches Address/GPS"));

		//Configure the map columns
		genMeth.clickId(genMeth, sgData.MapTabItem);

		genMeth.clickId(genMeth, "AddressLocationRb");

		genMeth.clickComboBox(genMeth, By.id("DropdownAddress"), By.id("Branch Address"));
		
		genMeth.clickComboBox(genMeth, By.id("DropdownSubject"), By.id("Branch Name"));

		genMeth.clickComboBox(genMeth, By.id("DropdownAdditionalInfo"), By.id("Branch Address"));

		genMeth.clickComboBox(genMeth, By.id("DropdownPhone"), By.id("Branch Phone"));

		genMeth.clickComboBox(genMeth, By.id("DropdownPinColorConstant"), By.id("#69cf9d"));

		//Add Navigation
		genMeth.clickId(genMeth, sgData.ToggleButtonAllowNavigation);
		genMeth.clickComboBox(genMeth, By.id("DropdownReports"), By.id("URL / News"));
		
		genMeth.clickId(genMeth, sgData.BtnSave);
		genMeth.clickId(genMeth, sgData.BtnCloseTabItem);
		genMeth.clickId(genMeth, sgData.BtnCloseTabItem);


		
		
	}


	@Test(priority = 4 ,enabled = true, testName = "", description = "", groups = { "Sanity Studio1" } /*dependsOnMethods = {"testLogin"}*/)
	 
	
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
//			genMeth.clickId(genMeth, "#FFB95DFF");

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

		genMeth.clickId(genMeth, sgData.TabItemDataItem);

		//Set DI 
		genMeth.clickId(genMeth, sgData.TabItemDataItem);
		genMeth.clickComboBox(genMeth, By.id("DropdownDataItem"), By.id("DI_service calls 1"));
		
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
		
		//genMeth.clickComboBox(genMeth, By.id("SectionSourceColumnCMB"), By.id("Service Call ID"));   waiting for automation id
		
		genMeth.clickId(genMeth, "Branch ID");
		genMeth.sendId(genMeth, sgData.TextFieldFriendlyName, "BranchID-Not Primary");
		genMeth.clickId(genMeth, sgData.PrimaryToogleButton);
		
		
		genMeth.clickId(genMeth, "Open Date");
		genMeth.clickId(genMeth, sgData.ExpenderFormat);
		genMeth.clickComboBox(genMeth, By.id(sgData.ComboFormatsCMB), By.id("MMM-dd-yyyy"));
		
	//	genMeth.clickId(genMeth, sgData.PageLeft);

		genMeth.clickId(genMeth, "Icon");
		genMeth.clickId(genMeth, sgData.ExpenderAdvanced);
		genMeth.clickComboBox(genMeth, By.id("AdvancedColumnTypeCMB"), By.id("IconSet"));
		//genMeth.clickId(genMeth, sgData.PageLeft);
		
		
		genMeth.clickId(genMeth, "Precentage");
		genMeth.clickComboBox(genMeth, By.id("AdvancedColumnTypeCMB"), By.id("Percentage"));
		//genMeth.clickId(genMeth, sgData.PageLeft);

		genMeth.clickId(genMeth, "Currency");
		//genMeth.sendId(genMeth, sgData.TextFieldFriendlyName, "Currency1");
		genMeth.clickComboBox(genMeth, By.id("AdvancedColumnTypeCMB"), By.id("Currency"));
		//genMeth.clickId(genMeth, sgData.PageLeft);

		
		genMeth.clickId(genMeth, "Address");
		genMeth.clickComboBox(genMeth, By.id("AdvancedColumnTypeCMB"), By.id("Address"));
		//genMeth.clickId(genMeth, "PageDown");

		
		genMeth.clickId(genMeth, "Phone");
		genMeth.clickComboBox(genMeth, By.id("AdvancedColumnTypeCMB"), By.id("PhoneColumn"));
		genMeth.sendId(genMeth, "BtnSMS", "Hello service call  [Service Call ID] under Branch [Branch ID] has finished successfully");
		genMeth.clickId(genMeth, "BtnPreview");
	
		genMeth.clickId(genMeth, "Landline");
		genMeth.clickComboBox(genMeth, By.id("AdvancedColumnTypeCMB"), By.id("PhoneColumn"));
		genMeth.clickId(genMeth, "LandlinePhoneRb");

		genMeth.clickId(genMeth, "Email");
		genMeth.clickComboBox(genMeth, By.id("AdvancedColumnTypeCMB"), By.id("EmailColumn"));
		genMeth.sendId(genMeth, "TextFieldEmail", "Hello, C1 number  [Service Call ID] has finished");
		genMeth.clickId(genMeth, "BtnPreview");

		genMeth.clickId(genMeth, "URL");
		genMeth.clickComboBox(genMeth, By.id("AdvancedColumnTypeCMB"), By.id("URL"));
		
		genMeth.clickId(genMeth, "Folder");
		genMeth.clickId(genMeth, sgData.ToogleVisible);
		
		//Actions
		genMeth.clickId(genMeth, sgData.TabItemActions);
		//waiting for automation id
		
				
		
		
		/*
		 * waiting for automation id for the radio button
		 
		genMeth.clickId(genMeth, "Address Mini Map");
		genMeth.sendId(genMeth, sgData.TextFieldFriendlyName, "Currency1");
		genMeth.clickComboBox(genMeth, By.id("AdvancedColumnTypeCMB"), By.id("Address Mini Map"));
		
		*/
		
		genMeth.clickId(genMeth, sgData.BtnCloseTabItem);

	}


	
	@Test (enabled = true ,testName = "", description = "" ,
			groups= {"Sanity Studio"}  /*dependsOnMethods={"testLogin"}*/)	

	public void ApplicationTesting() throws ParserConfigurationException,
			SAXException, IOException, InterruptedException {

//		genMeth.eyesCheckWindow(eyes, "Login Screen", useEye);
		
		//Create a new app with empty name
		genMeth.rightClickElement(By.id(sgData.LsmApplications), genMeth);

		genMeth.clickId(genMeth, sgData.LsmNewApp);
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
		genMeth.clickId(genMeth, sgData.BtnEdit);
		
		//Change app name
		genMeth.sendId(genMeth, sgData.TextFieldApplicationName_ID, "Test app 1- edit");
		//Close without save
		genMeth.clickId(genMeth, sgData.BtnCancel);
		
		//reopen the app make sure that the changes without save were not saved
		genMeth.rightClickElement(By.name("Test app 1"), genMeth);
		genMeth.clickId(genMeth, sgData.BtnEdit);
		
		
		//Now edit the name & save it making sure the name was saved successfully 
		genMeth.sendId(genMeth, sgData.TextFieldApplicationName_ID, "Test app 1- edit");
		genMeth.clickId(genMeth, sgData.BtnSave);
		genMeth.clickId(genMeth, sgData.BtnCloseTabItem);
		
		genMeth.rightClickElement(By.name("Test app 1- edit"), genMeth);
		genMeth.clickId(genMeth, sgData.BtnEdit);
		
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
