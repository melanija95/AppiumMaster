package pageObject;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PreferencePageAndroid implements PreferencePage {
	
	public PreferencePageAndroid(AppiumDriver driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='3. Preference dependencies']")
	private WebElement dependencies;
	
	@AndroidFindBy(id="android:id/checkbox")
	private WebElement wiFiOption;
	
	@AndroidFindBy(xpath="(//android.widget.RelativeLayout)[2]")
	private WebElement editField;
	
	@AndroidFindBy(className="android.widget.EditText")
	private WebElement nameField;
	
	@AndroidFindBy(className="android.widget.Button")
	private List<WebElement> ds;
	
	public void navigateToDependencies()
	{
		dependencies.click();
	}
	
	public void checkWiFiOption()
	{
		wiFiOption.click();
		Assert.assertTrue(editField.isDisplayed());
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
