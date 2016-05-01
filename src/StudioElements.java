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
	String BtnSGISRootTextBlock;
	String BtnX;
	String BtnLsmApplicationsName;
	String BtnEditApplication;
	String BtnPublishApplication;
	String BtnExportApplication;
	String BtnDuplicateApplication;
	String BtnDeleteApplication;
	String BtnUnpublishApplication;
	String BtnCloseTabItem;
	String BtnCancellationButton;
	String BtnApprovalButton;
	String BtnAddTabButton;
	String BtnNewDataItemApplication;
	String BtnNewReport;
	
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
	String TextFieldReportDescription;
	String TextFieldTabName;
	String TextFieldFriendlyName;
	
	
	//Checkbox
	String CheckBoxRememberMe;
	String CheckBoxDoNotPublish;
	String CheckBoxNotInMobile;
	
	
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
	String TabItemTabs;
	String URLTabItem;
	String MapTabItem;
	String TabItemActions;
	String TabItemColumns;
	
	
	
	//Combo
	String ComboDataSource;
	String ComboDataItemType;
	String ComboStorageLocation;
	String ComboRetrieveDataFrom;
	String ComboReportType;
	String ComboTabType;
	String ComboDataItemsCMB;
	String ComboComboSourceColumn;
	String ComboDropdowReportFolder;
	String ComboFormatsCMB;
	
	//Radio Buttons
	String RDBDataItem;
	String RDBCustomNameRB;
	String RDBGpsLocationRB;
	String RDBAddressLocationRB;
	
	//Toogle
	String PrimaryToogleButton;
	
	
	//Expander
	String ExpenderFormat;
	String ExpenderAdvanced;
	String ExpenderJumpToReport;

	
	//General
	String DIserviceCallsDemo;
	String userQA;
	String passwordQA;
	String GoldenAppAuto;
	String PageRight;
	String PageLeft;

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
		this.BtnSGISRootTextBlock = XmlHandel.readAndroidXml("BtnSGISRootTextBlock", langXml, xmlPath);
		this.BtnX = XmlHandel.readAndroidXml("BtnX", langXml, xmlPath);
		this.BtnLsmApplicationsName = XmlHandel.readAndroidXml("BtnLsmApplicationsName", langXml, xmlPath);
		
		this.BtnEditApplication = XmlHandel.readAndroidXml("BtnEditApplication", langXml, xmlPath);
		this.BtnPublishApplication = XmlHandel.readAndroidXml("BtnPublishApplication", langXml, xmlPath);
		this.BtnExportApplication = XmlHandel.readAndroidXml("BtnExportApplication", langXml, xmlPath);
		this.BtnDuplicateApplication = XmlHandel.readAndroidXml("BtnDuplicateApplication", langXml, xmlPath);
		this.BtnDeleteApplication = XmlHandel.readAndroidXml("BtnDeleteApplication", langXml, xmlPath);
		this.BtnUnpublishApplication = XmlHandel.readAndroidXml("BtnUnpublishApplication", langXml, xmlPath);
		this.BtnCloseTabItem = XmlHandel.readAndroidXml("BtnCloseTabItem", langXml, xmlPath);
		this.BtnCancellationButton = XmlHandel.readAndroidXml("BtnCancellationButton", langXml, xmlPath);
		this.BtnApprovalButton = XmlHandel.readAndroidXml("BtnApprovalButton", langXml, xmlPath);
		this.BtnAddTabButton = XmlHandel.readAndroidXml("BtnAddTabButton", langXml, xmlPath);
		this.BtnNewDataItemApplication = XmlHandel.readAndroidXml("BtnNewDataItemApplication", langXml, xmlPath);
		this.BtnNewReport = XmlHandel.readAndroidXml("BtnNewReport", langXml, xmlPath);

		
		
		
		
		
		
		this.TextFieldUsername = XmlHandel.readAndroidXml("TextFieldUsername", langXml, xmlPath);
		this.TextFieldPassword = XmlHandel.readAndroidXml("TextFieldPassword", langXml, xmlPath);
		this.TextFieldApplicationName_ID = XmlHandel.readAndroidXml("TextFieldApplicationName_ID", langXml, xmlPath);
		this.TextFieldApplicationDescription = XmlHandel.readAndroidXml("TextFieldApplicationDescription", langXml, xmlPath);
		this.TextFieldDataItemName = XmlHandel.readAndroidXml("TextFieldDataItemName", langXml, xmlPath);
		this.TextFieldDataItemDescription = XmlHandel.readAndroidXml("TextFieldDataItemDescription", langXml, xmlPath);
		this.TextFieldMaxNumberOfRows = XmlHandel.readAndroidXml("TextFieldMaxNumberOfRows", langXml, xmlPath);
		this.TextFieldQuery = XmlHandel.readAndroidXml("TextFieldQuery", langXml, xmlPath);
		this.TextFieldReportName = XmlHandel.readAndroidXml("TextFieldReportName", langXml, xmlPath);
		this.TextFieldReportDescription = XmlHandel.readAndroidXml("TextFieldReportDescription", langXml, xmlPath);
		this.TextFieldTabName = XmlHandel.readAndroidXml("TextFieldTabName", langXml, xmlPath);
		this.TextFieldFriendlyName = XmlHandel.readAndroidXml("TextFieldFriendlyName", langXml, xmlPath);

		
		
		
		this.CheckBoxRememberMe = XmlHandel.readAndroidXml("CheckBoxRememberMe", langXml, xmlPath);
		this.CheckBoxDoNotPublish = XmlHandel.readAndroidXml("CheckBoxDoNotPublish", langXml, xmlPath);
		this.CheckBoxNotInMobile = XmlHandel.readAndroidXml("CheckBoxNotInMobile", langXml, xmlPath);
		
		


		
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
		this.TabItemTabs = XmlHandel.readAndroidXml("TabItemTabs", langXml, xmlPath);
		this.URLTabItem = XmlHandel.readAndroidXml("URLTabItem", langXml, xmlPath);
		this.MapTabItem = XmlHandel.readAndroidXml("MapTabItem", langXml, xmlPath);
		this.TabItemActions = XmlHandel.readAndroidXml("TabItemActions", langXml, xmlPath);
		this.TabItemColumns = XmlHandel.readAndroidXml("TabItemColumns", langXml, xmlPath);

		
		
		
		this.ComboDataSource = XmlHandel.readAndroidXml("ComboDataSource", langXml, xmlPath);
		this.ComboDataItemType = XmlHandel.readAndroidXml("ComboDataItemType", langXml, xmlPath);
		this.ComboStorageLocation = XmlHandel.readAndroidXml("ComboStorageLocation", langXml, xmlPath);
		this.ComboRetrieveDataFrom = XmlHandel.readAndroidXml("ComboRetrieveDataFrom", langXml, xmlPath);
		this.ComboReportType = XmlHandel.readAndroidXml("ComboReportType", langXml, xmlPath);
		this.ComboTabType = XmlHandel.readAndroidXml("ComboTabType", langXml, xmlPath);
		this.ComboDataItemsCMB = XmlHandel.readAndroidXml("ComboDataItemsCMB", langXml, xmlPath);
		this.ComboComboSourceColumn = XmlHandel.readAndroidXml("ComboComboSourceColumn", langXml, xmlPath);
		this.ComboDropdowReportFolder = XmlHandel.readAndroidXml("ComboDropdowReportFolder", langXml, xmlPath);
		this.ComboFormatsCMB = XmlHandel.readAndroidXml("ComboFormatsCMB", langXml, xmlPath);

		
		
		
		this.PrimaryToogleButton = XmlHandel.readAndroidXml("PrimaryToogleButton", langXml, xmlPath);

		this.ExpenderFormat = XmlHandel.readAndroidXml("ExpenderFormat", langXml, xmlPath);
		this.ExpenderAdvanced = XmlHandel.readAndroidXml("ExpenderAdvanced", langXml, xmlPath);
		this.ExpenderJumpToReport = XmlHandel.readAndroidXml("ExpenderJumpToReport", langXml, xmlPath);

		
		
		
		
		
		
		
		this.RDBCustomNameRB = XmlHandel.readAndroidXml("RDBCustomNameRB", langXml, xmlPath);
		this.RDBDataItem = XmlHandel.readAndroidXml("RDBDataItem", langXml, xmlPath);
		this.RDBGpsLocationRB = XmlHandel.readAndroidXml("RDBGpsLocationRB", langXml, xmlPath);
		this.RDBAddressLocationRB = XmlHandel.readAndroidXml("RDBAddressLocationRB", langXml, xmlPath);

		
	
		
		

		this.DIserviceCallsDemo = XmlHandel.readAndroidXml("DIserviceCallsDemo", langXml, xmlPath);
		this.userQA = XmlHandel.readAndroidXml("userQA", langXml, xmlPath);
		this.passwordQA = XmlHandel.readAndroidXml("passwordQA", langXml, xmlPath);
		this.GoldenAppAuto = XmlHandel.readAndroidXml("GoldenAppAuto", langXml, xmlPath);
		this.PageRight = XmlHandel.readAndroidXml("PageRight", langXml, xmlPath);
		this.PageLeft = XmlHandel.readAndroidXml("PageLeft", langXml, xmlPath);

		
		
		
		
		
		
	}
	

}
