import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import jdk.internal.org.xml.sax.SAXException;

public class StudioElements {

	// Buttons
	String BtnSignIn;
	String BTNnewApplicationName;
	String BtnApplicationIcon;
	String BtnRefresh;
	String BtnSave;
	String BtnCancel;
	String BtnAddDataItem;
	String BtnPreview;
	String BtnAddReport;
	String BtnReportIcon;


	
	//Text Fields
	String TextFieldUsername;
	String TextFieldPassword;
	String TextFieldApplicationName_ID;
	String TextFieldApplicationDescription;
	String TextFieldDataItemName;
	String TextFieldDataItemDescription;
	String TextFieldMaxNumberOfRows;
	String TextFieldQuery;
	String TextFieldReportName;
	String TextFieldReportFolder;
	String TextFieldReportDescription;

	
	
	//Checkbox
	String CheckBoxRememberMe;
	String CheckBoxDoNotPublish;
	String CheckBoxNotInMobile;
	String CustomNameRB;
	
	//Left Tabs
	
	String TabItemGeneral;
	String TabItemDataItems;
	String TabItemReports;
	String TabItemPermissions;
	String TabItemQuery;
	String DataItem_ResultTabItem;
	String DataItemColumnsTabItem;
	String SlicersTabItem;
	String SparkLineTabItem;
	String Action_TabItem;
	
	
	//Combo
	String ComboDataSource;
	String ComboDataItemType;
	String ComboStorageLocation;
	String ComboRetrieveDataFrom;
	String ComboReportType;
	String ComboTabType;
	
	

	public StudioElements(String langXml, String xmlPath)
			throws ParserConfigurationException, SAXException, IOException,
			InterruptedException, org.xml.sax.SAXException {		
		
		this.BtnSignIn = XmlHandel.readAndroidXml("BtnSignIn", langXml, xmlPath);
		this.BTNnewApplicationName = XmlHandel.readAndroidXml("BTNnewApplicationName", langXml, xmlPath);
		this.BtnApplicationIcon = XmlHandel.readAndroidXml("BtnApplicationIcon", langXml, xmlPath);
		this.BtnRefresh = XmlHandel.readAndroidXml("BtnRefresh", langXml, xmlPath);
		this.BtnSave = XmlHandel.readAndroidXml("BtnSave", langXml, xmlPath);
		this.BtnCancel = XmlHandel.readAndroidXml("BtnCancel", langXml, xmlPath);
		this.BtnAddDataItem = XmlHandel.readAndroidXml("BtnAddDataItem", langXml, xmlPath);
		this.BtnPreview = XmlHandel.readAndroidXml("BtnPreview", langXml, xmlPath);
		this.BtnAddReport = XmlHandel.readAndroidXml("BtnAddReport", langXml, xmlPath);
		this.BtnReportIcon = XmlHandel.readAndroidXml("BtnReportIcon", langXml, xmlPath);

		
		
		
		
		this.TextFieldUsername = XmlHandel.readAndroidXml("TextFieldUsername", langXml, xmlPath);
		this.TextFieldPassword = XmlHandel.readAndroidXml("TextFieldPassword", langXml, xmlPath);
		this.TextFieldApplicationName_ID = XmlHandel.readAndroidXml("TextFieldApplicationName_ID", langXml, xmlPath);
		this.TextFieldApplicationDescription = XmlHandel.readAndroidXml("TextFieldApplicationDescription", langXml, xmlPath);
		this.TextFieldDataItemName = XmlHandel.readAndroidXml("TextFieldDataItemName", langXml, xmlPath);
		this.TextFieldDataItemDescription = XmlHandel.readAndroidXml("TextFieldDataItemDescription", langXml, xmlPath);
		this.TextFieldMaxNumberOfRows = XmlHandel.readAndroidXml("TextFieldMaxNumberOfRows", langXml, xmlPath);
		this.TextFieldQuery = XmlHandel.readAndroidXml("TextFieldQuery", langXml, xmlPath);
		this.TextFieldReportName = XmlHandel.readAndroidXml("TextFieldReportName", langXml, xmlPath);
		this.TextFieldReportFolder = XmlHandel.readAndroidXml("TextFieldReportFolder", langXml, xmlPath);
		this.TextFieldReportDescription = XmlHandel.readAndroidXml("TextFieldReportDescription", langXml, xmlPath);

		
		this.CheckBoxRememberMe = XmlHandel.readAndroidXml("CheckBoxRememberMe", langXml, xmlPath);
		this.CheckBoxDoNotPublish = XmlHandel.readAndroidXml("CheckBoxDoNotPublish", langXml, xmlPath);
		this.CheckBoxNotInMobile = XmlHandel.readAndroidXml("CheckBoxNotInMobile", langXml, xmlPath);
		this.CustomNameRB = XmlHandel.readAndroidXml("CustomNameRB", langXml, xmlPath);

		
		this.TabItemGeneral = XmlHandel.readAndroidXml("TabItemGeneral", langXml, xmlPath);
		this.TabItemDataItems = XmlHandel.readAndroidXml("TabItemDataItems", langXml, xmlPath);
		this.TabItemReports = XmlHandel.readAndroidXml("TabItemReports", langXml, xmlPath);
		this.TabItemPermissions = XmlHandel.readAndroidXml("TabItemPermissions", langXml, xmlPath);
		this.TabItemQuery = XmlHandel.readAndroidXml("TabItemQuery", langXml, xmlPath);
		this.DataItem_ResultTabItem = XmlHandel.readAndroidXml("DataItem_ResultTabItem", langXml, xmlPath);
		this.DataItemColumnsTabItem = XmlHandel.readAndroidXml("DataItemColumnsTabItem", langXml, xmlPath);
		this.SlicersTabItem = XmlHandel.readAndroidXml("SlicersTabItem", langXml, xmlPath);
		this.SparkLineTabItem = XmlHandel.readAndroidXml("SparkLineTabItem", langXml, xmlPath);
		this.Action_TabItem = XmlHandel.readAndroidXml("Action_TabItem", langXml, xmlPath);

		
		this.ComboDataSource = XmlHandel.readAndroidXml("ComboDataSource", langXml, xmlPath);
		this.ComboDataItemType = XmlHandel.readAndroidXml("ComboDataItemType", langXml, xmlPath);
		this.ComboStorageLocation = XmlHandel.readAndroidXml("ComboStorageLocation", langXml, xmlPath);
		this.ComboRetrieveDataFrom = XmlHandel.readAndroidXml("ComboRetrieveDataFrom", langXml, xmlPath);
		this.ComboReportType = XmlHandel.readAndroidXml("ComboReportType", langXml, xmlPath);
		this.ComboTabType = XmlHandel.readAndroidXml("ComboTabType", langXml, xmlPath);

		
		
	}
	

}
