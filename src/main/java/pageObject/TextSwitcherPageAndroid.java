package pageObject;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TextSwitcherPageAndroid implements TextSwitcherPage {
	
	public TextSwitcherPageAndroid(AppiumDriver driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='NEXT']")
	private WebElement next;
	
	@AndroidFindBy(className="android.widget.TextView")
	private List<WebElement> result;
	
	public void pressNext(int num) throws InterruptedException {
		for(int i=0; i<num; i++)
		{
			next.click();
			Thread.sleep(1000);
		}
		Assert.assertEquals(result.get(1).getText(), String.valueOf(num));	
	}
}
