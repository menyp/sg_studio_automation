
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.xml.sax.SAXException;

import com.applitools.eyes.Eyes;

import java.net.URL;
import java.net.MalformedURLException;


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
		
		//genMeth.cleanLogin(genMeth, sgData, "appium1@1.com");

		
		}
	

	@Test (enabled = true ,testName = "", description = "" ,
			groups= {"Sanity Studio"}  /*dependsOnMethods={"testLogin"}*/)	

	public void CreateGoldenApp() throws ParserConfigurationException,
			SAXException, IOException, InterruptedException {
		
		// Login to the studio
		//Thread.sleep(4000);
//		genMeth.eyesCheckWindow(eyes, "Login Screen", useEye);

		genMeth.clickId(genMeth, sgData.BtnSignIn);
		// Right click the Applications
		genMeth.rightClickElement(By.name("Applications"), genMeth);
//		Actions action = new Actions(driver);
//		WebElement AppElement = genMeth.returnName(driver, genMeth, "Applications");
//		action.contextClick(AppElement).sendKeys(Keys.ARROW_DOWN).perform();
		genMeth.clickName(genMeth, "New Application");

		//Create a new app & save it
		genMeth.sendId(genMeth, sgData.TextFieldApplicationName_ID, "Golden App 1");		
		genMeth.clickId(genMeth, sgData.BtnSave);
		
		//Create DI_service calls 4
		genMeth.clickId(genMeth, sgData.TabItemDataItems);
		genMeth.clickId(genMeth, sgData.BtnAddDataItem);
		genMeth.sendId(genMeth, sgData.TextFieldDataItemName, "DI_service calls 4");
		genMeth.sendId(genMeth, sgData.TextFieldDataItemDescription, "DI_service calls 4");

		//Add Query tab
		genMeth.clickId(genMeth, sgData.TabItemQuery);
		genMeth.sendId(genMeth, sgData.TextFieldQuery, "SELECT  *,  'Gauge'  =  50 from [dbo].[TBL_ServiceCalls]");
		genMeth.clickName(genMeth, "Save");
		
		//Close Tabs
		genMeth.clickName(genMeth, "Cancel");
		genMeth.clickName(genMeth, "Cancel");

		
		//Create "URL" Report
		genMeth.clickId(genMeth, sgData.TabItemReports);
		genMeth.clickId(genMeth, sgData.BtnAddReport);
		genMeth.sendId(genMeth, "TextFieldReportName", "URL");
		genMeth.sendId(genMeth, "TextFieldReportFolder", "All Tabs");
		genMeth.sendId(genMeth, sgData.TextFieldReportDescription, "All Tabs Report");
		
		//Set Report Icon
		//genMeth.clickId(genMeth, sgData.BtnReportIcon);

		
		genMeth.clickId(genMeth, sgData.BtnSave);

		//Create URL Tab (Constant)
		genMeth.clickId(genMeth, "TabItemTabs");
		genMeth.clickId(genMeth, "BtnAddTab");
		genMeth.clickName(genMeth, "New Tab - URL");
		genMeth.clickId(genMeth, "CustomNameRB");
		genMeth.sendId(genMeth, "TextFieldTabName", "URL Constant");
		
		genMeth.clickId(genMeth, "URLTabItem");
		//genMeth.clickId(genMeth, "RDBDataItem");
		//genMeth.sendId(genMeth, "DataItemsCMB", "URL Data Item");
		genMeth.sendId(genMeth, "SgTextBox", "http://www.milliondollarhomepage.com/");
		genMeth.clickName(genMeth, "Save");
		Thread.sleep(4000);
		genMeth.clickId(genMeth, sgData.BtnCancel);
		genMeth.clickId(genMeth, sgData.BtnCancel);
		genMeth.clickId(genMeth, sgData.BtnCancel);
		
		
		//Create URL tab (Data)
		genMeth.doubleClickElement(By.name("Golden App 1"), genMeth);
		genMeth.doubleClickElement(By.name("Reports"), genMeth);

		genMeth.rightClickElement(By.name("URL"), genMeth);
		genMeth.clickName(genMeth, "Edit");
		genMeth.clickId(genMeth, "TabItemTabs");
		genMeth.clickId(genMeth, "BtnAddTab");
		genMeth.clickName(genMeth, "New Tab - URL");

		genMeth.clickId(genMeth, "CustomNameRB");
		genMeth.sendId(genMeth, "TextFieldTabName", "URL Data Item");
		genMeth.clickId(genMeth, "URLTabItem");
		
		genMeth.clickId(genMeth, "RDBDataItem");
		
		genMeth.clickId(genMeth, "DataItemsCMB");
		genMeth.clickId(genMeth, "DI_service calls 4");
		genMeth.clickId(genMeth, "ComboSourceColumn");
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
		genMeth.clickId(genMeth, sgData.BtnCancel);
		genMeth.clickId(genMeth, sgData.BtnCancel);

		
		
		//Scroll to URL column
		/*TouchActions action = new TouchActions(driver);
		action.scroll(700, 300).perform();
		WebElement el = genMeth.returnId(driver, genMeth, "ComboSourceColumn");
		action.scroll(el, 700, 300).perform();
		*/
		Thread.sleep(1000);
		
		

		


				

		
	}
	
	
}
