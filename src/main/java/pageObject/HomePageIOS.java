package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

// all the objects belonging to one page will be defined in one java class

public class HomePageIOS implements HomePage {
	
	public HomePageIOS(AppiumDriver driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@iOSXCUITFindBy(xpath="//android.widget.TextView[@text='Preference']")
	private WebElement preferences;
	
	public void navigateToAccessibility() {
		
	}

	public void navigateToAnimation() {
		
	}

	public void navigateToApp() {
		
	}

	public void navigateToContent() {
		
	}

	public void navigateToGraphics() {
		
	}

	public void navigateToMedia() {
		
	}

	public void navigateToNFC() {
		
	}

	public void navigateToOS() {
		
	}
	
	public void navigateToPreferences() {
		preferences.click();
	}

	public void navigateToText() {
		
	}

	public void navigateToViews() {
		
	}
	
	public void navigateToLinkify() {
		
	}
	
}
