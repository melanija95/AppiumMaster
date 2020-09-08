package environment.AppiumMaster;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObject.DateWidgetsPage;
import pageObject.DateWidgetsPageAndroid;
import pageObject.DragAndDropPage;
import pageObject.DragAndDropPageAndroid;
import pageObject.ExpandableListsPage;
import pageObject.ExpandableListsPageAndroid;
import pageObject.HomePage;
import pageObject.HomePageAndroid;
import pageObject.HomePageIOS;
import pageObject.PreferencePage;
import pageObject.PreferencePageAndroid;
import pageObject.PreferencePageIOS;
import pageObject.SearchViewPage;
import pageObject.SearchViewPageAndroid;
import pageObject.TextPage;
import pageObject.TextPageAndroid;
import pageObject.TextSwitcherPage;
import pageObject.TextSwitcherPageAndroid;
import pageObject.ViewsPage;
import pageObject.ViewsPageAndroid;
import pageObject.VisibilityPage;
import pageObject.VisibilityPageAndroid;

public class BaseTestClass {
	
	HomePage homePage;
	PreferencePage preferencePage;
	ViewsPage viewsPage;
	DragAndDropPage dragAndDropPage;
	ExpandableListsPage expListsPage;
	TextSwitcherPage textSwitcherPage;
	VisibilityPage visibilityPage;
	DateWidgetsPage dateWidgetsPage;
	SearchViewPage searchViewPage;
	TextPage textPage;
	
	@BeforeTest
	public void killAllNodes() throws IOException, InterruptedException
	{
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException
	{
		
		AppiumController.instance.startServer();
		AppiumDriver driver = AppiumController.instance.createDriver();
		
		switch (AppiumController.executionOS) {
			case ANDROID:
				homePage = new HomePageAndroid(driver);
				preferencePage = new PreferencePageAndroid(driver);
				viewsPage = new ViewsPageAndroid(driver);
				dragAndDropPage = new DragAndDropPageAndroid(driver);
				expListsPage = new ExpandableListsPageAndroid(driver);
				textSwitcherPage = new TextSwitcherPageAndroid(driver);
				visibilityPage = new VisibilityPageAndroid(driver);
				dateWidgetsPage = new DateWidgetsPageAndroid(driver);
				searchViewPage = new SearchViewPageAndroid(driver);
				textPage = new TextPageAndroid(driver);
				break;
			case IOS:
				homePage = new HomePageIOS(driver);
				preferencePage = new PreferencePageIOS(driver);
				break;
		}
	}
	
	@AfterMethod
	public void stop()
	{
		AppiumController.instance.stop();
		AppiumController.service.stop();	
	}
	
	public void scrollToText(String text) throws IOException, InterruptedException {
		
		((AndroidDriver<AndroidElement>) AppiumController.instance.createDriver()).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));");
	}
}
