package pageObject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class VisibilityPageAndroid implements VisibilityPage {
	
	public VisibilityPageAndroid(AppiumDriver driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(className="android.widget.TextView")
	private List<WebElement> views;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='INVIS']")
	private WebElement invisButton;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='VIS']")
	private WebElement visButton;
	
	public void checkVisibility() throws InterruptedException {
		Assert.assertEquals(views.size(), 4);
		invisButton.click();
		Thread.sleep(2000);
		Assert.assertEquals(views.size(), 3);
		visButton.click();
		Thread.sleep(2000);
		Assert.assertEquals(views.size(), 4);
	}
	
}
