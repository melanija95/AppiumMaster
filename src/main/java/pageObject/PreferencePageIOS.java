package pageObject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class PreferencePageIOS implements PreferencePage {
	
	public PreferencePageIOS(AppiumDriver driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@iOSXCUITFindBy(xpath="//android.widget.TextView[@text='3. Preference dependencies']")
	private WebElement dependencies;
	
	@iOSXCUITFindBy(id="android:id/checkbox")
	private WebElement wiFiOption;
	
	@iOSXCUITFindBy(xpath="(//android.widget.RelativeLayout)[2]")
	private WebElement editField;
	
	@iOSXCUITFindBy(className="android.widget.EditText")
	private WebElement nameField;
	
	@iOSXCUITFindBy(className="android.widget.Button")
	private List<WebElement> ds;
	
	public void navigateToDependencies()
	{
		dependencies.click();
	}
	
	public void checkWiFiOption()
	{
		wiFiOption.click();
	}
	
	public void navigateToEditField()
	{
		editField.click();
	}
	
	public void setName(String name)
	{
		nameField.sendKeys(name);
		
	}
	
	public void clickOK()
	{
		ds.get(1).click();
	}
}
