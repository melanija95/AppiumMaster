package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

// all the objects belonging to one page will be defined in one java class

public class HomePageAndroid implements HomePage {
	
	public HomePageAndroid(AppiumDriver driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	//@iOSFindBy
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Accessibility']")
	private WebElement accessibility;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Animation']")
	private WebElement animation;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='App']")
	private WebElement app;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Content']")
	private WebElement content;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Graphics']")
	private WebElement graphics;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Media']")
	private WebElement media;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='NFC']")
	private WebElement nfc;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='OS']")
	private WebElement os;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Preference']")
	private WebElement preferences;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Text']")
	private WebElement text;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Views']")
	private WebElement views;

	
	public void navigateToAccessibility() {
		accessibility.click();
	}

	public void navigateToAnimation() {
		animation.click();
	}

	public void navigateToApp() {
		app.click();
	}

	public void navigateToContent() {
		content.click();
	}

	public void navigateToGraphics() {
		graphics.click();
	}

	public void navigateToMedia() {
		media.click();
	}

	public void navigateToNFC() {
		nfc.click();
	}

	public void navigateToOS() {
		os.click();
	}
	
	public void navigateToPreferences() {
		preferences.click();
	}

	public void navigateToText() {
		text.click();
	}

	public void navigateToViews() {
		views.click();
	}
	
}
